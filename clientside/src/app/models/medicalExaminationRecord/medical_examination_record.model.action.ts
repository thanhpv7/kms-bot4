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
import {MedicalExaminationRecordModel} from './medical_examination_record.model';
import {MedicalExaminationRecordModelAudit} from './medical_examination_record.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Examination Record model actions to be dispatched by NgRx.
 */
export enum MedicalExaminationRecordModelActionTypes {
	CREATE_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create MedicalExaminationRecordModel',
	CREATE_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create MedicalExaminationRecordModel successfully',
	CREATE_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create MedicalExaminationRecordModel failed',

	CREATE_ALL_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create All MedicalExaminationRecordModel',
	CREATE_ALL_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create All MedicalExaminationRecordModel successfully',
	CREATE_ALL_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create All MedicalExaminationRecordModel failed',

	DELETE_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete MedicalExaminationRecordModel',
	DELETE_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete MedicalExaminationRecordModel successfully',
	DELETE_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete MedicalExaminationRecordModel failed',


	DELETE_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Delete MedicalExaminationRecordModels Excluding Ids',
	DELETE_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalExaminationRecordModels Excluding Ids successfully',
	DELETE_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalExaminationRecordModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete all MedicalExaminationRecordModels',
	DELETE_ALL_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete all MedicalExaminationRecordModels successfully',
	DELETE_ALL_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete all MedicalExaminationRecordModels failed',

	UPDATE_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update MedicalExaminationRecordModel',
	UPDATE_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update MedicalExaminationRecordModel successfully',
	UPDATE_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update MedicalExaminationRecordModel failed',

	UPDATE_ALL_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update all MedicalExaminationRecordModel',
	UPDATE_ALL_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update all MedicalExaminationRecordModel successfully',
	UPDATE_ALL_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update all MedicalExaminationRecordModel failed',

	FETCH_MEDICAL_EXAMINATION_RECORD= '[ENTITY] Fetch MedicalExaminationRecordModel',
	FETCH_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch MedicalExaminationRecordModel successfully',
	FETCH_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch MedicalExaminationRecordModel failed',

	FETCH_MEDICAL_EXAMINATION_RECORD_AUDIT= '[ENTITY] Fetch MedicalExaminationRecordModel audit',
	FETCH_MEDICAL_EXAMINATION_RECORD_AUDIT_OK = '[ENTITY] Fetch MedicalExaminationRecordModel audit successfully',
	FETCH_MEDICAL_EXAMINATION_RECORD_AUDIT_FAIL = '[ENTITY] Fetch MedicalExaminationRecordModel audit failed',

	FETCH_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalExaminationRecordModel audits by entity id',
	FETCH_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalExaminationRecordModel audits by entity id successfully',
	FETCH_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalExaminationRecordModel audits by entity id failed',

	FETCH_ALL_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Fetch all MedicalExaminationRecordModel',
	FETCH_ALL_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch all MedicalExaminationRecordModel successfully',
	FETCH_ALL_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch all MedicalExaminationRecordModel failed',

	FETCH_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch MedicalExaminationRecordModel with query',
	FETCH_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch MedicalExaminationRecordModel with query successfully',
	FETCH_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalExaminationRecordModel with query failed',

	FETCH_LAST_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch last MedicalExaminationRecordModel with query',
	FETCH_LAST_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalExaminationRecordModel with query successfully',
	FETCH_LAST_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalExaminationRecordModel with query failed',

	EXPORT_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export MedicalExaminationRecordModel',
	EXPORT_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export MedicalExaminationRecordModel successfully',
	EXPORT_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export MedicalExaminationRecordModel failed',

	EXPORT_ALL_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export All MedicalExaminationRecordModels',
	EXPORT_ALL_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export All MedicalExaminationRecordModels successfully',
	EXPORT_ALL_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export All MedicalExaminationRecordModels failed',

	EXPORT_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Export MedicalExaminationRecordModels excluding Ids',
	EXPORT_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalExaminationRecordModel excluding Ids successfully',
	EXPORT_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalExaminationRecordModel excluding Ids failed',

	COUNT_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Fetch number of MedicalExaminationRecordModel records',
	COUNT_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Fetch number of MedicalExaminationRecordModel records successfully ',
	COUNT_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Fetch number of MedicalExaminationRecordModel records failed',

	IMPORT_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Import MedicalExaminationRecordModels',
	IMPORT_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Import MedicalExaminationRecordModels successfully',
	IMPORT_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Import MedicalExaminationRecordModels fail',


	INITIALISE_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalExaminationRecordModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalExaminationRecordAction implements Action {
	readonly className: string = 'MedicalExaminationRecordModel';

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

export class MedicalExaminationRecordAction extends BaseMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class fields for MedicalExaminationRecordAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class methods for MedicalExaminationRecordAction here] end
}

export class MedicalExaminationRecordActionOK extends BaseMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalExaminationRecordActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalExaminationRecordModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalExaminationRecordActionOK here] end
}

export class MedicalExaminationRecordActionFail extends BaseMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalExaminationRecordActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalExaminationRecordActionFail here] end
}

export function isMedicalExaminationRecordModelAction(e: any): e is BaseMedicalExaminationRecordAction {
	return Object.values(MedicalExaminationRecordModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
