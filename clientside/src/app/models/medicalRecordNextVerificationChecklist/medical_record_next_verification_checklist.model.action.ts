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
import {MedicalRecordNextVerificationChecklistModel} from './medical_record_next_verification_checklist.model';
import {MedicalRecordNextVerificationChecklistModelAudit} from './medical_record_next_verification_checklist.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Record Next Verification Checklist model actions to be dispatched by NgRx.
 */
export enum MedicalRecordNextVerificationChecklistModelActionTypes {
	CREATE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST = '[ENTITY] Create MedicalRecordNextVerificationChecklistModel',
	CREATE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Create MedicalRecordNextVerificationChecklistModel successfully',
	CREATE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Create MedicalRecordNextVerificationChecklistModel failed',

	CREATE_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST = '[ENTITY] Create All MedicalRecordNextVerificationChecklistModel',
	CREATE_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Create All MedicalRecordNextVerificationChecklistModel successfully',
	CREATE_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Create All MedicalRecordNextVerificationChecklistModel failed',

	DELETE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST = '[ENTITY] Delete MedicalRecordNextVerificationChecklistModel',
	DELETE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Delete MedicalRecordNextVerificationChecklistModel successfully',
	DELETE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Delete MedicalRecordNextVerificationChecklistModel failed',


	DELETE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_EXCLUDING_IDS = '[ENTITY] Delete MedicalRecordNextVerificationChecklistModels Excluding Ids',
	DELETE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalRecordNextVerificationChecklistModels Excluding Ids successfully',
	DELETE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalRecordNextVerificationChecklistModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST = '[ENTITY] Delete all MedicalRecordNextVerificationChecklistModels',
	DELETE_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Delete all MedicalRecordNextVerificationChecklistModels successfully',
	DELETE_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Delete all MedicalRecordNextVerificationChecklistModels failed',

	UPDATE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST = '[ENTITY] Update MedicalRecordNextVerificationChecklistModel',
	UPDATE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Update MedicalRecordNextVerificationChecklistModel successfully',
	UPDATE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Update MedicalRecordNextVerificationChecklistModel failed',

	UPDATE_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST = '[ENTITY] Update all MedicalRecordNextVerificationChecklistModel',
	UPDATE_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Update all MedicalRecordNextVerificationChecklistModel successfully',
	UPDATE_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Update all MedicalRecordNextVerificationChecklistModel failed',

	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST= '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel',
	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel successfully',
	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel failed',

	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_AUDIT= '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel audit',
	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_AUDIT_OK = '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel audit successfully',
	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_AUDIT_FAIL = '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel audit failed',

	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel audits by entity id',
	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel audits by entity id successfully',
	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel audits by entity id failed',

	FETCH_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST = '[ENTITY] Fetch all MedicalRecordNextVerificationChecklistModel',
	FETCH_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Fetch all MedicalRecordNextVerificationChecklistModel successfully',
	FETCH_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Fetch all MedicalRecordNextVerificationChecklistModel failed',

	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_WITH_QUERY = '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel with query',
	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_WITH_QUERY_OK = '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel with query successfully',
	FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalRecordNextVerificationChecklistModel with query failed',

	FETCH_LAST_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_WITH_QUERY = '[ENTITY] Fetch last MedicalRecordNextVerificationChecklistModel with query',
	FETCH_LAST_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalRecordNextVerificationChecklistModel with query successfully',
	FETCH_LAST_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalRecordNextVerificationChecklistModel with query failed',

	EXPORT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST = '[ENTITY] Export MedicalRecordNextVerificationChecklistModel',
	EXPORT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Export MedicalRecordNextVerificationChecklistModel successfully',
	EXPORT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Export MedicalRecordNextVerificationChecklistModel failed',

	EXPORT_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST = '[ENTITY] Export All MedicalRecordNextVerificationChecklistModels',
	EXPORT_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_OK = '[ENTITY] Export All MedicalRecordNextVerificationChecklistModels successfully',
	EXPORT_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_FAIL = '[ENTITY] Export All MedicalRecordNextVerificationChecklistModels failed',

	EXPORT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_EXCLUDING_IDS = '[ENTITY] Export MedicalRecordNextVerificationChecklistModels excluding Ids',
	EXPORT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalRecordNextVerificationChecklistModel excluding Ids successfully',
	EXPORT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalRecordNextVerificationChecklistModel excluding Ids failed',

	COUNT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLISTS = '[ENTITY] Fetch number of MedicalRecordNextVerificationChecklistModel records',
	COUNT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLISTS_OK = '[ENTITY] Fetch number of MedicalRecordNextVerificationChecklistModel records successfully ',
	COUNT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLISTS_FAIL = '[ENTITY] Fetch number of MedicalRecordNextVerificationChecklistModel records failed',

	IMPORT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLISTS = '[ENTITY] Import MedicalRecordNextVerificationChecklistModels',
	IMPORT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLISTS_OK = '[ENTITY] Import MedicalRecordNextVerificationChecklistModels successfully',
	IMPORT_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLISTS_FAIL = '[ENTITY] Import MedicalRecordNextVerificationChecklistModels fail',


	INITIALISE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalRecordNextVerificationChecklistModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalRecordNextVerificationChecklistAction implements Action {
	readonly className: string = 'MedicalRecordNextVerificationChecklistModel';

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

export class MedicalRecordNextVerificationChecklistAction extends BaseMedicalRecordNextVerificationChecklistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalRecordNextVerificationChecklistAction here] off begin
	// % protected region % [Add any additional class fields for MedicalRecordNextVerificationChecklistAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalRecordNextVerificationChecklistModel>,
		// % protected region % [Add any additional constructor parameters for MedicalRecordNextVerificationChecklistAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalRecordNextVerificationChecklistAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalRecordNextVerificationChecklistAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalRecordNextVerificationChecklistAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalRecordNextVerificationChecklistAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalRecordNextVerificationChecklistAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalRecordNextVerificationChecklistAction here] off begin
	// % protected region % [Add any additional class methods for MedicalRecordNextVerificationChecklistAction here] end
}

export class MedicalRecordNextVerificationChecklistActionOK extends BaseMedicalRecordNextVerificationChecklistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalRecordNextVerificationChecklistActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalRecordNextVerificationChecklistActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalRecordNextVerificationChecklistModel>,
		// % protected region % [Add any additional constructor parameters for MedicalRecordNextVerificationChecklistActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalRecordNextVerificationChecklistActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalRecordNextVerificationChecklistModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalRecordNextVerificationChecklistActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalRecordNextVerificationChecklistActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalRecordNextVerificationChecklistActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalRecordNextVerificationChecklistActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalRecordNextVerificationChecklistActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalRecordNextVerificationChecklistActionOK here] end
}

export class MedicalRecordNextVerificationChecklistActionFail extends BaseMedicalRecordNextVerificationChecklistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalRecordNextVerificationChecklistActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalRecordNextVerificationChecklistActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalRecordNextVerificationChecklistModel>,
		// % protected region % [Add any additional constructor parameters for MedicalRecordNextVerificationChecklistActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalRecordNextVerificationChecklistActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalRecordNextVerificationChecklistActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalRecordNextVerificationChecklistActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalRecordNextVerificationChecklistActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalRecordNextVerificationChecklistActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalRecordNextVerificationChecklistActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalRecordNextVerificationChecklistActionFail here] end
}

export function isMedicalRecordNextVerificationChecklistModelAction(e: any): e is BaseMedicalRecordNextVerificationChecklistAction {
	return Object.values(MedicalRecordNextVerificationChecklistModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
