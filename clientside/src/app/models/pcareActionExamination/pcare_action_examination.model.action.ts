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
import {PcareActionExaminationModel} from './pcare_action_examination.model';
import {PcareActionExaminationModelAudit} from './pcare_action_examination.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Action Examination model actions to be dispatched by NgRx.
 */
export enum PcareActionExaminationModelActionTypes {
	CREATE_PCARE_ACTION_EXAMINATION = '[ENTITY] Create PcareActionExaminationModel',
	CREATE_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Create PcareActionExaminationModel successfully',
	CREATE_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Create PcareActionExaminationModel failed',

	CREATE_ALL_PCARE_ACTION_EXAMINATION = '[ENTITY] Create All PcareActionExaminationModel',
	CREATE_ALL_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Create All PcareActionExaminationModel successfully',
	CREATE_ALL_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Create All PcareActionExaminationModel failed',

	DELETE_PCARE_ACTION_EXAMINATION = '[ENTITY] Delete PcareActionExaminationModel',
	DELETE_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Delete PcareActionExaminationModel successfully',
	DELETE_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Delete PcareActionExaminationModel failed',


	DELETE_PCARE_ACTION_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Delete PcareActionExaminationModels Excluding Ids',
	DELETE_PCARE_ACTION_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareActionExaminationModels Excluding Ids successfully',
	DELETE_PCARE_ACTION_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareActionExaminationModels Excluding Ids failed',

	DELETE_ALL_PCARE_ACTION_EXAMINATION = '[ENTITY] Delete all PcareActionExaminationModels',
	DELETE_ALL_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Delete all PcareActionExaminationModels successfully',
	DELETE_ALL_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Delete all PcareActionExaminationModels failed',

	UPDATE_PCARE_ACTION_EXAMINATION = '[ENTITY] Update PcareActionExaminationModel',
	UPDATE_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Update PcareActionExaminationModel successfully',
	UPDATE_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Update PcareActionExaminationModel failed',

	UPDATE_ALL_PCARE_ACTION_EXAMINATION = '[ENTITY] Update all PcareActionExaminationModel',
	UPDATE_ALL_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Update all PcareActionExaminationModel successfully',
	UPDATE_ALL_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Update all PcareActionExaminationModel failed',

	FETCH_PCARE_ACTION_EXAMINATION= '[ENTITY] Fetch PcareActionExaminationModel',
	FETCH_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Fetch PcareActionExaminationModel successfully',
	FETCH_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Fetch PcareActionExaminationModel failed',

	FETCH_PCARE_ACTION_EXAMINATION_AUDIT= '[ENTITY] Fetch PcareActionExaminationModel audit',
	FETCH_PCARE_ACTION_EXAMINATION_AUDIT_OK = '[ENTITY] Fetch PcareActionExaminationModel audit successfully',
	FETCH_PCARE_ACTION_EXAMINATION_AUDIT_FAIL = '[ENTITY] Fetch PcareActionExaminationModel audit failed',

	FETCH_PCARE_ACTION_EXAMINATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareActionExaminationModel audits by entity id',
	FETCH_PCARE_ACTION_EXAMINATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareActionExaminationModel audits by entity id successfully',
	FETCH_PCARE_ACTION_EXAMINATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareActionExaminationModel audits by entity id failed',

	FETCH_ALL_PCARE_ACTION_EXAMINATION = '[ENTITY] Fetch all PcareActionExaminationModel',
	FETCH_ALL_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Fetch all PcareActionExaminationModel successfully',
	FETCH_ALL_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Fetch all PcareActionExaminationModel failed',

	FETCH_PCARE_ACTION_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch PcareActionExaminationModel with query',
	FETCH_PCARE_ACTION_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch PcareActionExaminationModel with query successfully',
	FETCH_PCARE_ACTION_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareActionExaminationModel with query failed',

	FETCH_LAST_PCARE_ACTION_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch last PcareActionExaminationModel with query',
	FETCH_LAST_PCARE_ACTION_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch last PcareActionExaminationModel with query successfully',
	FETCH_LAST_PCARE_ACTION_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareActionExaminationModel with query failed',

	EXPORT_PCARE_ACTION_EXAMINATION = '[ENTITY] Export PcareActionExaminationModel',
	EXPORT_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Export PcareActionExaminationModel successfully',
	EXPORT_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Export PcareActionExaminationModel failed',

	EXPORT_ALL_PCARE_ACTION_EXAMINATION = '[ENTITY] Export All PcareActionExaminationModels',
	EXPORT_ALL_PCARE_ACTION_EXAMINATION_OK = '[ENTITY] Export All PcareActionExaminationModels successfully',
	EXPORT_ALL_PCARE_ACTION_EXAMINATION_FAIL = '[ENTITY] Export All PcareActionExaminationModels failed',

	EXPORT_PCARE_ACTION_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Export PcareActionExaminationModels excluding Ids',
	EXPORT_PCARE_ACTION_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Export PcareActionExaminationModel excluding Ids successfully',
	EXPORT_PCARE_ACTION_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareActionExaminationModel excluding Ids failed',

	COUNT_PCARE_ACTION_EXAMINATIONS = '[ENTITY] Fetch number of PcareActionExaminationModel records',
	COUNT_PCARE_ACTION_EXAMINATIONS_OK = '[ENTITY] Fetch number of PcareActionExaminationModel records successfully ',
	COUNT_PCARE_ACTION_EXAMINATIONS_FAIL = '[ENTITY] Fetch number of PcareActionExaminationModel records failed',

	IMPORT_PCARE_ACTION_EXAMINATIONS = '[ENTITY] Import PcareActionExaminationModels',
	IMPORT_PCARE_ACTION_EXAMINATIONS_OK = '[ENTITY] Import PcareActionExaminationModels successfully',
	IMPORT_PCARE_ACTION_EXAMINATIONS_FAIL = '[ENTITY] Import PcareActionExaminationModels fail',


	INITIALISE_PCARE_ACTION_EXAMINATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareActionExaminationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareActionExaminationAction implements Action {
	readonly className: string = 'PcareActionExaminationModel';

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

export class PcareActionExaminationAction extends BasePcareActionExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareActionExaminationAction here] off begin
	// % protected region % [Add any additional class fields for PcareActionExaminationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareActionExaminationModel>,
		// % protected region % [Add any additional constructor parameters for PcareActionExaminationAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareActionExaminationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareActionExaminationAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareActionExaminationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareActionExaminationAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareActionExaminationAction here] end
	}

	// % protected region % [Add any additional class methods for PcareActionExaminationAction here] off begin
	// % protected region % [Add any additional class methods for PcareActionExaminationAction here] end
}

export class PcareActionExaminationActionOK extends BasePcareActionExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareActionExaminationActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareActionExaminationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareActionExaminationModel>,
		// % protected region % [Add any additional constructor parameters for PcareActionExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareActionExaminationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareActionExaminationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareActionExaminationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareActionExaminationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareActionExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareActionExaminationActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareActionExaminationActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareActionExaminationActionOK here] end
}

export class PcareActionExaminationActionFail extends BasePcareActionExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareActionExaminationActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareActionExaminationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareActionExaminationModel>,
		// % protected region % [Add any additional constructor parameters for PcareActionExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareActionExaminationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareActionExaminationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareActionExaminationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareActionExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareActionExaminationActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareActionExaminationActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareActionExaminationActionFail here] end
}

export function isPcareActionExaminationModelAction(e: any): e is BasePcareActionExaminationAction {
	return Object.values(PcareActionExaminationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
