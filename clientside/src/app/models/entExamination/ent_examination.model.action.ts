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
import {EntExaminationModel} from './ent_examination.model';
import {EntExaminationModelAudit} from './ent_examination.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of ENT Examination model actions to be dispatched by NgRx.
 */
export enum EntExaminationModelActionTypes {
	CREATE_ENT_EXAMINATION = '[ENTITY] Create EntExaminationModel',
	CREATE_ENT_EXAMINATION_OK = '[ENTITY] Create EntExaminationModel successfully',
	CREATE_ENT_EXAMINATION_FAIL = '[ENTITY] Create EntExaminationModel failed',

	CREATE_ALL_ENT_EXAMINATION = '[ENTITY] Create All EntExaminationModel',
	CREATE_ALL_ENT_EXAMINATION_OK = '[ENTITY] Create All EntExaminationModel successfully',
	CREATE_ALL_ENT_EXAMINATION_FAIL = '[ENTITY] Create All EntExaminationModel failed',

	DELETE_ENT_EXAMINATION = '[ENTITY] Delete EntExaminationModel',
	DELETE_ENT_EXAMINATION_OK = '[ENTITY] Delete EntExaminationModel successfully',
	DELETE_ENT_EXAMINATION_FAIL = '[ENTITY] Delete EntExaminationModel failed',


	DELETE_ENT_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Delete EntExaminationModels Excluding Ids',
	DELETE_ENT_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Delete EntExaminationModels Excluding Ids successfully',
	DELETE_ENT_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete EntExaminationModels Excluding Ids failed',

	DELETE_ALL_ENT_EXAMINATION = '[ENTITY] Delete all EntExaminationModels',
	DELETE_ALL_ENT_EXAMINATION_OK = '[ENTITY] Delete all EntExaminationModels successfully',
	DELETE_ALL_ENT_EXAMINATION_FAIL = '[ENTITY] Delete all EntExaminationModels failed',

	UPDATE_ENT_EXAMINATION = '[ENTITY] Update EntExaminationModel',
	UPDATE_ENT_EXAMINATION_OK = '[ENTITY] Update EntExaminationModel successfully',
	UPDATE_ENT_EXAMINATION_FAIL = '[ENTITY] Update EntExaminationModel failed',

	UPDATE_ALL_ENT_EXAMINATION = '[ENTITY] Update all EntExaminationModel',
	UPDATE_ALL_ENT_EXAMINATION_OK = '[ENTITY] Update all EntExaminationModel successfully',
	UPDATE_ALL_ENT_EXAMINATION_FAIL = '[ENTITY] Update all EntExaminationModel failed',

	FETCH_ENT_EXAMINATION= '[ENTITY] Fetch EntExaminationModel',
	FETCH_ENT_EXAMINATION_OK = '[ENTITY] Fetch EntExaminationModel successfully',
	FETCH_ENT_EXAMINATION_FAIL = '[ENTITY] Fetch EntExaminationModel failed',

	FETCH_ENT_EXAMINATION_AUDIT= '[ENTITY] Fetch EntExaminationModel audit',
	FETCH_ENT_EXAMINATION_AUDIT_OK = '[ENTITY] Fetch EntExaminationModel audit successfully',
	FETCH_ENT_EXAMINATION_AUDIT_FAIL = '[ENTITY] Fetch EntExaminationModel audit failed',

	FETCH_ENT_EXAMINATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch EntExaminationModel audits by entity id',
	FETCH_ENT_EXAMINATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch EntExaminationModel audits by entity id successfully',
	FETCH_ENT_EXAMINATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch EntExaminationModel audits by entity id failed',

	FETCH_ALL_ENT_EXAMINATION = '[ENTITY] Fetch all EntExaminationModel',
	FETCH_ALL_ENT_EXAMINATION_OK = '[ENTITY] Fetch all EntExaminationModel successfully',
	FETCH_ALL_ENT_EXAMINATION_FAIL = '[ENTITY] Fetch all EntExaminationModel failed',

	FETCH_ENT_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch EntExaminationModel with query',
	FETCH_ENT_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch EntExaminationModel with query successfully',
	FETCH_ENT_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch EntExaminationModel with query failed',

	FETCH_LAST_ENT_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch last EntExaminationModel with query',
	FETCH_LAST_ENT_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch last EntExaminationModel with query successfully',
	FETCH_LAST_ENT_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last EntExaminationModel with query failed',

	EXPORT_ENT_EXAMINATION = '[ENTITY] Export EntExaminationModel',
	EXPORT_ENT_EXAMINATION_OK = '[ENTITY] Export EntExaminationModel successfully',
	EXPORT_ENT_EXAMINATION_FAIL = '[ENTITY] Export EntExaminationModel failed',

	EXPORT_ALL_ENT_EXAMINATION = '[ENTITY] Export All EntExaminationModels',
	EXPORT_ALL_ENT_EXAMINATION_OK = '[ENTITY] Export All EntExaminationModels successfully',
	EXPORT_ALL_ENT_EXAMINATION_FAIL = '[ENTITY] Export All EntExaminationModels failed',

	EXPORT_ENT_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Export EntExaminationModels excluding Ids',
	EXPORT_ENT_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Export EntExaminationModel excluding Ids successfully',
	EXPORT_ENT_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export EntExaminationModel excluding Ids failed',

	COUNT_ENT_EXAMINATIONS = '[ENTITY] Fetch number of EntExaminationModel records',
	COUNT_ENT_EXAMINATIONS_OK = '[ENTITY] Fetch number of EntExaminationModel records successfully ',
	COUNT_ENT_EXAMINATIONS_FAIL = '[ENTITY] Fetch number of EntExaminationModel records failed',

	IMPORT_ENT_EXAMINATIONS = '[ENTITY] Import EntExaminationModels',
	IMPORT_ENT_EXAMINATIONS_OK = '[ENTITY] Import EntExaminationModels successfully',
	IMPORT_ENT_EXAMINATIONS_FAIL = '[ENTITY] Import EntExaminationModels fail',


	INITIALISE_ENT_EXAMINATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of EntExaminationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseEntExaminationAction implements Action {
	readonly className: string = 'EntExaminationModel';

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

export class EntExaminationAction extends BaseEntExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for EntExaminationAction here] off begin
	// % protected region % [Add any additional class fields for EntExaminationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<EntExaminationModel>,
		// % protected region % [Add any additional constructor parameters for EntExaminationAction here] off begin
		// % protected region % [Add any additional constructor parameters for EntExaminationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for EntExaminationAction here] off begin
			// % protected region % [Add any additional constructor arguments for EntExaminationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for EntExaminationAction here] off begin
		// % protected region % [Add any additional constructor logic for EntExaminationAction here] end
	}

	// % protected region % [Add any additional class methods for EntExaminationAction here] off begin
	// % protected region % [Add any additional class methods for EntExaminationAction here] end
}

export class EntExaminationActionOK extends BaseEntExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for EntExaminationActionOK here] off begin
	// % protected region % [Add any additional class fields for EntExaminationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<EntExaminationModel>,
		// % protected region % [Add any additional constructor parameters for EntExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for EntExaminationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: EntExaminationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for EntExaminationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for EntExaminationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for EntExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for EntExaminationActionOK here] end
	}

	// % protected region % [Add any additional class methods for EntExaminationActionOK here] off begin
	// % protected region % [Add any additional class methods for EntExaminationActionOK here] end
}

export class EntExaminationActionFail extends BaseEntExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for EntExaminationActionFail here] off begin
	// % protected region % [Add any additional class fields for EntExaminationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<EntExaminationModel>,
		// % protected region % [Add any additional constructor parameters for EntExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for EntExaminationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for EntExaminationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for EntExaminationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for EntExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for EntExaminationActionFail here] end
	}

	// % protected region % [Add any additional class methods for EntExaminationActionFail here] off begin
	// % protected region % [Add any additional class methods for EntExaminationActionFail here] end
}

export function isEntExaminationModelAction(e: any): e is BaseEntExaminationAction {
	return Object.values(EntExaminationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
