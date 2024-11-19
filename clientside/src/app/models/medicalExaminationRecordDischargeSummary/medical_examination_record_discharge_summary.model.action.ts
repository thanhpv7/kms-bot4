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
import {MedicalExaminationRecordDischargeSummaryModel} from './medical_examination_record_discharge_summary.model';
import {MedicalExaminationRecordDischargeSummaryModelAudit} from './medical_examination_record_discharge_summary.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Examination Record Discharge Summary model actions to be dispatched by NgRx.
 */
export enum MedicalExaminationRecordDischargeSummaryModelActionTypes {
	CREATE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY = '[ENTITY] Create MedicalExaminationRecordDischargeSummaryModel',
	CREATE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Create MedicalExaminationRecordDischargeSummaryModel successfully',
	CREATE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Create MedicalExaminationRecordDischargeSummaryModel failed',

	CREATE_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY = '[ENTITY] Create All MedicalExaminationRecordDischargeSummaryModel',
	CREATE_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Create All MedicalExaminationRecordDischargeSummaryModel successfully',
	CREATE_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Create All MedicalExaminationRecordDischargeSummaryModel failed',

	DELETE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY = '[ENTITY] Delete MedicalExaminationRecordDischargeSummaryModel',
	DELETE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Delete MedicalExaminationRecordDischargeSummaryModel successfully',
	DELETE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Delete MedicalExaminationRecordDischargeSummaryModel failed',


	DELETE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_EXCLUDING_IDS = '[ENTITY] Delete MedicalExaminationRecordDischargeSummaryModels Excluding Ids',
	DELETE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalExaminationRecordDischargeSummaryModels Excluding Ids successfully',
	DELETE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalExaminationRecordDischargeSummaryModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY = '[ENTITY] Delete all MedicalExaminationRecordDischargeSummaryModels',
	DELETE_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Delete all MedicalExaminationRecordDischargeSummaryModels successfully',
	DELETE_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Delete all MedicalExaminationRecordDischargeSummaryModels failed',

	UPDATE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY = '[ENTITY] Update MedicalExaminationRecordDischargeSummaryModel',
	UPDATE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Update MedicalExaminationRecordDischargeSummaryModel successfully',
	UPDATE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Update MedicalExaminationRecordDischargeSummaryModel failed',

	UPDATE_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY = '[ENTITY] Update all MedicalExaminationRecordDischargeSummaryModel',
	UPDATE_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Update all MedicalExaminationRecordDischargeSummaryModel successfully',
	UPDATE_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Update all MedicalExaminationRecordDischargeSummaryModel failed',

	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY= '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel',
	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel successfully',
	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel failed',

	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_AUDIT= '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel audit',
	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_AUDIT_OK = '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel audit successfully',
	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_AUDIT_FAIL = '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel audit failed',

	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel audits by entity id',
	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel audits by entity id successfully',
	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel audits by entity id failed',

	FETCH_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY = '[ENTITY] Fetch all MedicalExaminationRecordDischargeSummaryModel',
	FETCH_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Fetch all MedicalExaminationRecordDischargeSummaryModel successfully',
	FETCH_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Fetch all MedicalExaminationRecordDischargeSummaryModel failed',

	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_WITH_QUERY = '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel with query',
	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_WITH_QUERY_OK = '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel with query successfully',
	FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalExaminationRecordDischargeSummaryModel with query failed',

	FETCH_LAST_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_WITH_QUERY = '[ENTITY] Fetch last MedicalExaminationRecordDischargeSummaryModel with query',
	FETCH_LAST_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalExaminationRecordDischargeSummaryModel with query successfully',
	FETCH_LAST_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalExaminationRecordDischargeSummaryModel with query failed',

	EXPORT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY = '[ENTITY] Export MedicalExaminationRecordDischargeSummaryModel',
	EXPORT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Export MedicalExaminationRecordDischargeSummaryModel successfully',
	EXPORT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Export MedicalExaminationRecordDischargeSummaryModel failed',

	EXPORT_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY = '[ENTITY] Export All MedicalExaminationRecordDischargeSummaryModels',
	EXPORT_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_OK = '[ENTITY] Export All MedicalExaminationRecordDischargeSummaryModels successfully',
	EXPORT_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_FAIL = '[ENTITY] Export All MedicalExaminationRecordDischargeSummaryModels failed',

	EXPORT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_EXCLUDING_IDS = '[ENTITY] Export MedicalExaminationRecordDischargeSummaryModels excluding Ids',
	EXPORT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalExaminationRecordDischargeSummaryModel excluding Ids successfully',
	EXPORT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalExaminationRecordDischargeSummaryModel excluding Ids failed',

	COUNT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARYS = '[ENTITY] Fetch number of MedicalExaminationRecordDischargeSummaryModel records',
	COUNT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARYS_OK = '[ENTITY] Fetch number of MedicalExaminationRecordDischargeSummaryModel records successfully ',
	COUNT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARYS_FAIL = '[ENTITY] Fetch number of MedicalExaminationRecordDischargeSummaryModel records failed',

	IMPORT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARYS = '[ENTITY] Import MedicalExaminationRecordDischargeSummaryModels',
	IMPORT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARYS_OK = '[ENTITY] Import MedicalExaminationRecordDischargeSummaryModels successfully',
	IMPORT_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARYS_FAIL = '[ENTITY] Import MedicalExaminationRecordDischargeSummaryModels fail',


	INITIALISE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalExaminationRecordDischargeSummaryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalExaminationRecordDischargeSummaryAction implements Action {
	readonly className: string = 'MedicalExaminationRecordDischargeSummaryModel';

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

export class MedicalExaminationRecordDischargeSummaryAction extends BaseMedicalExaminationRecordDischargeSummaryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalExaminationRecordDischargeSummaryAction here] off begin
	// % protected region % [Add any additional class fields for MedicalExaminationRecordDischargeSummaryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalExaminationRecordDischargeSummaryModel>,
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordDischargeSummaryAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordDischargeSummaryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordDischargeSummaryAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordDischargeSummaryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordDischargeSummaryAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordDischargeSummaryAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalExaminationRecordDischargeSummaryAction here] off begin
	// % protected region % [Add any additional class methods for MedicalExaminationRecordDischargeSummaryAction here] end
}

export class MedicalExaminationRecordDischargeSummaryActionOK extends BaseMedicalExaminationRecordDischargeSummaryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalExaminationRecordDischargeSummaryActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalExaminationRecordDischargeSummaryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalExaminationRecordDischargeSummaryModel>,
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordDischargeSummaryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordDischargeSummaryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalExaminationRecordDischargeSummaryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordDischargeSummaryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordDischargeSummaryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordDischargeSummaryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordDischargeSummaryActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalExaminationRecordDischargeSummaryActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalExaminationRecordDischargeSummaryActionOK here] end
}

export class MedicalExaminationRecordDischargeSummaryActionFail extends BaseMedicalExaminationRecordDischargeSummaryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalExaminationRecordDischargeSummaryActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalExaminationRecordDischargeSummaryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalExaminationRecordDischargeSummaryModel>,
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordDischargeSummaryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalExaminationRecordDischargeSummaryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordDischargeSummaryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalExaminationRecordDischargeSummaryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordDischargeSummaryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalExaminationRecordDischargeSummaryActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalExaminationRecordDischargeSummaryActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalExaminationRecordDischargeSummaryActionFail here] end
}

export function isMedicalExaminationRecordDischargeSummaryModelAction(e: any): e is BaseMedicalExaminationRecordDischargeSummaryAction {
	return Object.values(MedicalExaminationRecordDischargeSummaryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
