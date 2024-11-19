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
import {EmergencyMedicalExaminationRecordModel} from './emergency_medical_examination_record.model';
import {EmergencyMedicalExaminationRecordModelAudit} from './emergency_medical_examination_record.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Emergency Medical Examination Record model actions to be dispatched by NgRx.
 */
export enum EmergencyMedicalExaminationRecordModelActionTypes {
	CREATE_EMERGENCY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create EmergencyMedicalExaminationRecordModel',
	CREATE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create EmergencyMedicalExaminationRecordModel successfully',
	CREATE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create EmergencyMedicalExaminationRecordModel failed',

	CREATE_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create All EmergencyMedicalExaminationRecordModel',
	CREATE_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create All EmergencyMedicalExaminationRecordModel successfully',
	CREATE_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create All EmergencyMedicalExaminationRecordModel failed',

	DELETE_EMERGENCY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete EmergencyMedicalExaminationRecordModel',
	DELETE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete EmergencyMedicalExaminationRecordModel successfully',
	DELETE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete EmergencyMedicalExaminationRecordModel failed',


	DELETE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Delete EmergencyMedicalExaminationRecordModels Excluding Ids',
	DELETE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Delete EmergencyMedicalExaminationRecordModels Excluding Ids successfully',
	DELETE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Delete EmergencyMedicalExaminationRecordModels Excluding Ids failed',

	DELETE_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete all EmergencyMedicalExaminationRecordModels',
	DELETE_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete all EmergencyMedicalExaminationRecordModels successfully',
	DELETE_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete all EmergencyMedicalExaminationRecordModels failed',

	UPDATE_EMERGENCY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update EmergencyMedicalExaminationRecordModel',
	UPDATE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update EmergencyMedicalExaminationRecordModel successfully',
	UPDATE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update EmergencyMedicalExaminationRecordModel failed',

	UPDATE_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update all EmergencyMedicalExaminationRecordModel',
	UPDATE_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update all EmergencyMedicalExaminationRecordModel successfully',
	UPDATE_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update all EmergencyMedicalExaminationRecordModel failed',

	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD= '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel',
	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel successfully',
	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel failed',

	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_AUDIT= '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel audit',
	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_AUDIT_OK = '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel audit successfully',
	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_AUDIT_FAIL = '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel audit failed',

	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel audits by entity id',
	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel audits by entity id successfully',
	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel audits by entity id failed',

	FETCH_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Fetch all EmergencyMedicalExaminationRecordModel',
	FETCH_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch all EmergencyMedicalExaminationRecordModel successfully',
	FETCH_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch all EmergencyMedicalExaminationRecordModel failed',

	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel with query',
	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel with query successfully',
	FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch EmergencyMedicalExaminationRecordModel with query failed',

	FETCH_LAST_EMERGENCY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch last EmergencyMedicalExaminationRecordModel with query',
	FETCH_LAST_EMERGENCY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch last EmergencyMedicalExaminationRecordModel with query successfully',
	FETCH_LAST_EMERGENCY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch last EmergencyMedicalExaminationRecordModel with query failed',

	EXPORT_EMERGENCY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export EmergencyMedicalExaminationRecordModel',
	EXPORT_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export EmergencyMedicalExaminationRecordModel successfully',
	EXPORT_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export EmergencyMedicalExaminationRecordModel failed',

	EXPORT_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export All EmergencyMedicalExaminationRecordModels',
	EXPORT_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export All EmergencyMedicalExaminationRecordModels successfully',
	EXPORT_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export All EmergencyMedicalExaminationRecordModels failed',

	EXPORT_EMERGENCY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Export EmergencyMedicalExaminationRecordModels excluding Ids',
	EXPORT_EMERGENCY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Export EmergencyMedicalExaminationRecordModel excluding Ids successfully',
	EXPORT_EMERGENCY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Export EmergencyMedicalExaminationRecordModel excluding Ids failed',

	COUNT_EMERGENCY_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Fetch number of EmergencyMedicalExaminationRecordModel records',
	COUNT_EMERGENCY_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Fetch number of EmergencyMedicalExaminationRecordModel records successfully ',
	COUNT_EMERGENCY_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Fetch number of EmergencyMedicalExaminationRecordModel records failed',

	IMPORT_EMERGENCY_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Import EmergencyMedicalExaminationRecordModels',
	IMPORT_EMERGENCY_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Import EmergencyMedicalExaminationRecordModels successfully',
	IMPORT_EMERGENCY_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Import EmergencyMedicalExaminationRecordModels fail',


	INITIALISE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of EmergencyMedicalExaminationRecordModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseEmergencyMedicalExaminationRecordAction implements Action {
	readonly className: string = 'EmergencyMedicalExaminationRecordModel';

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

export class EmergencyMedicalExaminationRecordAction extends BaseEmergencyMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for EmergencyMedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class fields for EmergencyMedicalExaminationRecordAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<EmergencyMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for EmergencyMedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor parameters for EmergencyMedicalExaminationRecordAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for EmergencyMedicalExaminationRecordAction here] off begin
			// % protected region % [Add any additional constructor arguments for EmergencyMedicalExaminationRecordAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for EmergencyMedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor logic for EmergencyMedicalExaminationRecordAction here] end
	}

	// % protected region % [Add any additional class methods for EmergencyMedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class methods for EmergencyMedicalExaminationRecordAction here] end
}

export class EmergencyMedicalExaminationRecordActionOK extends BaseEmergencyMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for EmergencyMedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class fields for EmergencyMedicalExaminationRecordActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<EmergencyMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for EmergencyMedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for EmergencyMedicalExaminationRecordActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: EmergencyMedicalExaminationRecordModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for EmergencyMedicalExaminationRecordActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for EmergencyMedicalExaminationRecordActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for EmergencyMedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor logic for EmergencyMedicalExaminationRecordActionOK here] end
	}

	// % protected region % [Add any additional class methods for EmergencyMedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class methods for EmergencyMedicalExaminationRecordActionOK here] end
}

export class EmergencyMedicalExaminationRecordActionFail extends BaseEmergencyMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for EmergencyMedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class fields for EmergencyMedicalExaminationRecordActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<EmergencyMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for EmergencyMedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for EmergencyMedicalExaminationRecordActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for EmergencyMedicalExaminationRecordActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for EmergencyMedicalExaminationRecordActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for EmergencyMedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor logic for EmergencyMedicalExaminationRecordActionFail here] end
	}

	// % protected region % [Add any additional class methods for EmergencyMedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class methods for EmergencyMedicalExaminationRecordActionFail here] end
}

export function isEmergencyMedicalExaminationRecordModelAction(e: any): e is BaseEmergencyMedicalExaminationRecordAction {
	return Object.values(EmergencyMedicalExaminationRecordModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
