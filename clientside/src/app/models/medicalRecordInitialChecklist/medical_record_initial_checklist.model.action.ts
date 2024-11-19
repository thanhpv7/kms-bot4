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
import {MedicalRecordInitialChecklistModel} from './medical_record_initial_checklist.model';
import {MedicalRecordInitialChecklistModelAudit} from './medical_record_initial_checklist.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Record Initial Checklist model actions to be dispatched by NgRx.
 */
export enum MedicalRecordInitialChecklistModelActionTypes {
	CREATE_MEDICAL_RECORD_INITIAL_CHECKLIST = '[ENTITY] Create MedicalRecordInitialChecklistModel',
	CREATE_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Create MedicalRecordInitialChecklistModel successfully',
	CREATE_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Create MedicalRecordInitialChecklistModel failed',

	CREATE_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST = '[ENTITY] Create All MedicalRecordInitialChecklistModel',
	CREATE_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Create All MedicalRecordInitialChecklistModel successfully',
	CREATE_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Create All MedicalRecordInitialChecklistModel failed',

	DELETE_MEDICAL_RECORD_INITIAL_CHECKLIST = '[ENTITY] Delete MedicalRecordInitialChecklistModel',
	DELETE_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Delete MedicalRecordInitialChecklistModel successfully',
	DELETE_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Delete MedicalRecordInitialChecklistModel failed',


	DELETE_MEDICAL_RECORD_INITIAL_CHECKLIST_EXCLUDING_IDS = '[ENTITY] Delete MedicalRecordInitialChecklistModels Excluding Ids',
	DELETE_MEDICAL_RECORD_INITIAL_CHECKLIST_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalRecordInitialChecklistModels Excluding Ids successfully',
	DELETE_MEDICAL_RECORD_INITIAL_CHECKLIST_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalRecordInitialChecklistModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST = '[ENTITY] Delete all MedicalRecordInitialChecklistModels',
	DELETE_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Delete all MedicalRecordInitialChecklistModels successfully',
	DELETE_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Delete all MedicalRecordInitialChecklistModels failed',

	UPDATE_MEDICAL_RECORD_INITIAL_CHECKLIST = '[ENTITY] Update MedicalRecordInitialChecklistModel',
	UPDATE_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Update MedicalRecordInitialChecklistModel successfully',
	UPDATE_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Update MedicalRecordInitialChecklistModel failed',

	UPDATE_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST = '[ENTITY] Update all MedicalRecordInitialChecklistModel',
	UPDATE_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Update all MedicalRecordInitialChecklistModel successfully',
	UPDATE_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Update all MedicalRecordInitialChecklistModel failed',

	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST= '[ENTITY] Fetch MedicalRecordInitialChecklistModel',
	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Fetch MedicalRecordInitialChecklistModel successfully',
	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Fetch MedicalRecordInitialChecklistModel failed',

	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_AUDIT= '[ENTITY] Fetch MedicalRecordInitialChecklistModel audit',
	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_AUDIT_OK = '[ENTITY] Fetch MedicalRecordInitialChecklistModel audit successfully',
	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_AUDIT_FAIL = '[ENTITY] Fetch MedicalRecordInitialChecklistModel audit failed',

	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalRecordInitialChecklistModel audits by entity id',
	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalRecordInitialChecklistModel audits by entity id successfully',
	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalRecordInitialChecklistModel audits by entity id failed',

	FETCH_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST = '[ENTITY] Fetch all MedicalRecordInitialChecklistModel',
	FETCH_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Fetch all MedicalRecordInitialChecklistModel successfully',
	FETCH_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Fetch all MedicalRecordInitialChecklistModel failed',

	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_WITH_QUERY = '[ENTITY] Fetch MedicalRecordInitialChecklistModel with query',
	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_WITH_QUERY_OK = '[ENTITY] Fetch MedicalRecordInitialChecklistModel with query successfully',
	FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalRecordInitialChecklistModel with query failed',

	FETCH_LAST_MEDICAL_RECORD_INITIAL_CHECKLIST_WITH_QUERY = '[ENTITY] Fetch last MedicalRecordInitialChecklistModel with query',
	FETCH_LAST_MEDICAL_RECORD_INITIAL_CHECKLIST_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalRecordInitialChecklistModel with query successfully',
	FETCH_LAST_MEDICAL_RECORD_INITIAL_CHECKLIST_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalRecordInitialChecklistModel with query failed',

	EXPORT_MEDICAL_RECORD_INITIAL_CHECKLIST = '[ENTITY] Export MedicalRecordInitialChecklistModel',
	EXPORT_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Export MedicalRecordInitialChecklistModel successfully',
	EXPORT_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Export MedicalRecordInitialChecklistModel failed',

	EXPORT_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST = '[ENTITY] Export All MedicalRecordInitialChecklistModels',
	EXPORT_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_OK = '[ENTITY] Export All MedicalRecordInitialChecklistModels successfully',
	EXPORT_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST_FAIL = '[ENTITY] Export All MedicalRecordInitialChecklistModels failed',

	EXPORT_MEDICAL_RECORD_INITIAL_CHECKLIST_EXCLUDING_IDS = '[ENTITY] Export MedicalRecordInitialChecklistModels excluding Ids',
	EXPORT_MEDICAL_RECORD_INITIAL_CHECKLIST_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalRecordInitialChecklistModel excluding Ids successfully',
	EXPORT_MEDICAL_RECORD_INITIAL_CHECKLIST_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalRecordInitialChecklistModel excluding Ids failed',

	COUNT_MEDICAL_RECORD_INITIAL_CHECKLISTS = '[ENTITY] Fetch number of MedicalRecordInitialChecklistModel records',
	COUNT_MEDICAL_RECORD_INITIAL_CHECKLISTS_OK = '[ENTITY] Fetch number of MedicalRecordInitialChecklistModel records successfully ',
	COUNT_MEDICAL_RECORD_INITIAL_CHECKLISTS_FAIL = '[ENTITY] Fetch number of MedicalRecordInitialChecklistModel records failed',

	IMPORT_MEDICAL_RECORD_INITIAL_CHECKLISTS = '[ENTITY] Import MedicalRecordInitialChecklistModels',
	IMPORT_MEDICAL_RECORD_INITIAL_CHECKLISTS_OK = '[ENTITY] Import MedicalRecordInitialChecklistModels successfully',
	IMPORT_MEDICAL_RECORD_INITIAL_CHECKLISTS_FAIL = '[ENTITY] Import MedicalRecordInitialChecklistModels fail',


	INITIALISE_MEDICAL_RECORD_INITIAL_CHECKLIST_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalRecordInitialChecklistModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalRecordInitialChecklistAction implements Action {
	readonly className: string = 'MedicalRecordInitialChecklistModel';

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

export class MedicalRecordInitialChecklistAction extends BaseMedicalRecordInitialChecklistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalRecordInitialChecklistAction here] off begin
	// % protected region % [Add any additional class fields for MedicalRecordInitialChecklistAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalRecordInitialChecklistModel>,
		// % protected region % [Add any additional constructor parameters for MedicalRecordInitialChecklistAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalRecordInitialChecklistAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalRecordInitialChecklistAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalRecordInitialChecklistAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalRecordInitialChecklistAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalRecordInitialChecklistAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalRecordInitialChecklistAction here] off begin
	// % protected region % [Add any additional class methods for MedicalRecordInitialChecklistAction here] end
}

export class MedicalRecordInitialChecklistActionOK extends BaseMedicalRecordInitialChecklistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalRecordInitialChecklistActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalRecordInitialChecklistActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalRecordInitialChecklistModel>,
		// % protected region % [Add any additional constructor parameters for MedicalRecordInitialChecklistActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalRecordInitialChecklistActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalRecordInitialChecklistModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalRecordInitialChecklistActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalRecordInitialChecklistActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalRecordInitialChecklistActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalRecordInitialChecklistActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalRecordInitialChecklistActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalRecordInitialChecklistActionOK here] end
}

export class MedicalRecordInitialChecklistActionFail extends BaseMedicalRecordInitialChecklistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalRecordInitialChecklistActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalRecordInitialChecklistActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalRecordInitialChecklistModel>,
		// % protected region % [Add any additional constructor parameters for MedicalRecordInitialChecklistActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalRecordInitialChecklistActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalRecordInitialChecklistActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalRecordInitialChecklistActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalRecordInitialChecklistActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalRecordInitialChecklistActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalRecordInitialChecklistActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalRecordInitialChecklistActionFail here] end
}

export function isMedicalRecordInitialChecklistModelAction(e: any): e is BaseMedicalRecordInitialChecklistAction {
	return Object.values(MedicalRecordInitialChecklistModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
