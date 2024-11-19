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
import {HemodialysisExaminationModel} from './hemodialysis_examination.model';
import {HemodialysisExaminationModelAudit} from './hemodialysis_examination.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Hemodialysis Examination model actions to be dispatched by NgRx.
 */
export enum HemodialysisExaminationModelActionTypes {
	CREATE_HEMODIALYSIS_EXAMINATION = '[ENTITY] Create HemodialysisExaminationModel',
	CREATE_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Create HemodialysisExaminationModel successfully',
	CREATE_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Create HemodialysisExaminationModel failed',

	CREATE_ALL_HEMODIALYSIS_EXAMINATION = '[ENTITY] Create All HemodialysisExaminationModel',
	CREATE_ALL_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Create All HemodialysisExaminationModel successfully',
	CREATE_ALL_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Create All HemodialysisExaminationModel failed',

	DELETE_HEMODIALYSIS_EXAMINATION = '[ENTITY] Delete HemodialysisExaminationModel',
	DELETE_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Delete HemodialysisExaminationModel successfully',
	DELETE_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Delete HemodialysisExaminationModel failed',


	DELETE_HEMODIALYSIS_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Delete HemodialysisExaminationModels Excluding Ids',
	DELETE_HEMODIALYSIS_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Delete HemodialysisExaminationModels Excluding Ids successfully',
	DELETE_HEMODIALYSIS_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete HemodialysisExaminationModels Excluding Ids failed',

	DELETE_ALL_HEMODIALYSIS_EXAMINATION = '[ENTITY] Delete all HemodialysisExaminationModels',
	DELETE_ALL_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Delete all HemodialysisExaminationModels successfully',
	DELETE_ALL_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Delete all HemodialysisExaminationModels failed',

	UPDATE_HEMODIALYSIS_EXAMINATION = '[ENTITY] Update HemodialysisExaminationModel',
	UPDATE_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Update HemodialysisExaminationModel successfully',
	UPDATE_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Update HemodialysisExaminationModel failed',

	UPDATE_ALL_HEMODIALYSIS_EXAMINATION = '[ENTITY] Update all HemodialysisExaminationModel',
	UPDATE_ALL_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Update all HemodialysisExaminationModel successfully',
	UPDATE_ALL_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Update all HemodialysisExaminationModel failed',

	FETCH_HEMODIALYSIS_EXAMINATION= '[ENTITY] Fetch HemodialysisExaminationModel',
	FETCH_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Fetch HemodialysisExaminationModel successfully',
	FETCH_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Fetch HemodialysisExaminationModel failed',

	FETCH_HEMODIALYSIS_EXAMINATION_AUDIT= '[ENTITY] Fetch HemodialysisExaminationModel audit',
	FETCH_HEMODIALYSIS_EXAMINATION_AUDIT_OK = '[ENTITY] Fetch HemodialysisExaminationModel audit successfully',
	FETCH_HEMODIALYSIS_EXAMINATION_AUDIT_FAIL = '[ENTITY] Fetch HemodialysisExaminationModel audit failed',

	FETCH_HEMODIALYSIS_EXAMINATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch HemodialysisExaminationModel audits by entity id',
	FETCH_HEMODIALYSIS_EXAMINATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch HemodialysisExaminationModel audits by entity id successfully',
	FETCH_HEMODIALYSIS_EXAMINATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch HemodialysisExaminationModel audits by entity id failed',

	FETCH_ALL_HEMODIALYSIS_EXAMINATION = '[ENTITY] Fetch all HemodialysisExaminationModel',
	FETCH_ALL_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Fetch all HemodialysisExaminationModel successfully',
	FETCH_ALL_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Fetch all HemodialysisExaminationModel failed',

	FETCH_HEMODIALYSIS_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch HemodialysisExaminationModel with query',
	FETCH_HEMODIALYSIS_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch HemodialysisExaminationModel with query successfully',
	FETCH_HEMODIALYSIS_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch HemodialysisExaminationModel with query failed',

	FETCH_LAST_HEMODIALYSIS_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch last HemodialysisExaminationModel with query',
	FETCH_LAST_HEMODIALYSIS_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch last HemodialysisExaminationModel with query successfully',
	FETCH_LAST_HEMODIALYSIS_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last HemodialysisExaminationModel with query failed',

	EXPORT_HEMODIALYSIS_EXAMINATION = '[ENTITY] Export HemodialysisExaminationModel',
	EXPORT_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Export HemodialysisExaminationModel successfully',
	EXPORT_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Export HemodialysisExaminationModel failed',

	EXPORT_ALL_HEMODIALYSIS_EXAMINATION = '[ENTITY] Export All HemodialysisExaminationModels',
	EXPORT_ALL_HEMODIALYSIS_EXAMINATION_OK = '[ENTITY] Export All HemodialysisExaminationModels successfully',
	EXPORT_ALL_HEMODIALYSIS_EXAMINATION_FAIL = '[ENTITY] Export All HemodialysisExaminationModels failed',

	EXPORT_HEMODIALYSIS_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Export HemodialysisExaminationModels excluding Ids',
	EXPORT_HEMODIALYSIS_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Export HemodialysisExaminationModel excluding Ids successfully',
	EXPORT_HEMODIALYSIS_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export HemodialysisExaminationModel excluding Ids failed',

	COUNT_HEMODIALYSIS_EXAMINATIONS = '[ENTITY] Fetch number of HemodialysisExaminationModel records',
	COUNT_HEMODIALYSIS_EXAMINATIONS_OK = '[ENTITY] Fetch number of HemodialysisExaminationModel records successfully ',
	COUNT_HEMODIALYSIS_EXAMINATIONS_FAIL = '[ENTITY] Fetch number of HemodialysisExaminationModel records failed',

	IMPORT_HEMODIALYSIS_EXAMINATIONS = '[ENTITY] Import HemodialysisExaminationModels',
	IMPORT_HEMODIALYSIS_EXAMINATIONS_OK = '[ENTITY] Import HemodialysisExaminationModels successfully',
	IMPORT_HEMODIALYSIS_EXAMINATIONS_FAIL = '[ENTITY] Import HemodialysisExaminationModels fail',


	INITIALISE_HEMODIALYSIS_EXAMINATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of HemodialysisExaminationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseHemodialysisExaminationAction implements Action {
	readonly className: string = 'HemodialysisExaminationModel';

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

export class HemodialysisExaminationAction extends BaseHemodialysisExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HemodialysisExaminationAction here] off begin
	// % protected region % [Add any additional class fields for HemodialysisExaminationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HemodialysisExaminationModel>,
		// % protected region % [Add any additional constructor parameters for HemodialysisExaminationAction here] off begin
		// % protected region % [Add any additional constructor parameters for HemodialysisExaminationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HemodialysisExaminationAction here] off begin
			// % protected region % [Add any additional constructor arguments for HemodialysisExaminationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HemodialysisExaminationAction here] off begin
		// % protected region % [Add any additional constructor logic for HemodialysisExaminationAction here] end
	}

	// % protected region % [Add any additional class methods for HemodialysisExaminationAction here] off begin
	// % protected region % [Add any additional class methods for HemodialysisExaminationAction here] end
}

export class HemodialysisExaminationActionOK extends BaseHemodialysisExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HemodialysisExaminationActionOK here] off begin
	// % protected region % [Add any additional class fields for HemodialysisExaminationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HemodialysisExaminationModel>,
		// % protected region % [Add any additional constructor parameters for HemodialysisExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for HemodialysisExaminationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: HemodialysisExaminationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HemodialysisExaminationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for HemodialysisExaminationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HemodialysisExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for HemodialysisExaminationActionOK here] end
	}

	// % protected region % [Add any additional class methods for HemodialysisExaminationActionOK here] off begin
	// % protected region % [Add any additional class methods for HemodialysisExaminationActionOK here] end
}

export class HemodialysisExaminationActionFail extends BaseHemodialysisExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HemodialysisExaminationActionFail here] off begin
	// % protected region % [Add any additional class fields for HemodialysisExaminationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<HemodialysisExaminationModel>,
		// % protected region % [Add any additional constructor parameters for HemodialysisExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for HemodialysisExaminationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HemodialysisExaminationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for HemodialysisExaminationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HemodialysisExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for HemodialysisExaminationActionFail here] end
	}

	// % protected region % [Add any additional class methods for HemodialysisExaminationActionFail here] off begin
	// % protected region % [Add any additional class methods for HemodialysisExaminationActionFail here] end
}

export function isHemodialysisExaminationModelAction(e: any): e is BaseHemodialysisExaminationAction {
	return Object.values(HemodialysisExaminationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
