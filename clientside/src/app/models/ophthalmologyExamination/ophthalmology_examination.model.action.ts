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
import {OphthalmologyExaminationModel} from './ophthalmology_examination.model';
import {OphthalmologyExaminationModelAudit} from './ophthalmology_examination.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Ophthalmology Examination model actions to be dispatched by NgRx.
 */
export enum OphthalmologyExaminationModelActionTypes {
	CREATE_OPHTHALMOLOGY_EXAMINATION = '[ENTITY] Create OphthalmologyExaminationModel',
	CREATE_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Create OphthalmologyExaminationModel successfully',
	CREATE_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Create OphthalmologyExaminationModel failed',

	CREATE_ALL_OPHTHALMOLOGY_EXAMINATION = '[ENTITY] Create All OphthalmologyExaminationModel',
	CREATE_ALL_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Create All OphthalmologyExaminationModel successfully',
	CREATE_ALL_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Create All OphthalmologyExaminationModel failed',

	DELETE_OPHTHALMOLOGY_EXAMINATION = '[ENTITY] Delete OphthalmologyExaminationModel',
	DELETE_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Delete OphthalmologyExaminationModel successfully',
	DELETE_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Delete OphthalmologyExaminationModel failed',


	DELETE_OPHTHALMOLOGY_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Delete OphthalmologyExaminationModels Excluding Ids',
	DELETE_OPHTHALMOLOGY_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Delete OphthalmologyExaminationModels Excluding Ids successfully',
	DELETE_OPHTHALMOLOGY_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete OphthalmologyExaminationModels Excluding Ids failed',

	DELETE_ALL_OPHTHALMOLOGY_EXAMINATION = '[ENTITY] Delete all OphthalmologyExaminationModels',
	DELETE_ALL_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Delete all OphthalmologyExaminationModels successfully',
	DELETE_ALL_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Delete all OphthalmologyExaminationModels failed',

	UPDATE_OPHTHALMOLOGY_EXAMINATION = '[ENTITY] Update OphthalmologyExaminationModel',
	UPDATE_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Update OphthalmologyExaminationModel successfully',
	UPDATE_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Update OphthalmologyExaminationModel failed',

	UPDATE_ALL_OPHTHALMOLOGY_EXAMINATION = '[ENTITY] Update all OphthalmologyExaminationModel',
	UPDATE_ALL_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Update all OphthalmologyExaminationModel successfully',
	UPDATE_ALL_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Update all OphthalmologyExaminationModel failed',

	FETCH_OPHTHALMOLOGY_EXAMINATION= '[ENTITY] Fetch OphthalmologyExaminationModel',
	FETCH_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Fetch OphthalmologyExaminationModel successfully',
	FETCH_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Fetch OphthalmologyExaminationModel failed',

	FETCH_OPHTHALMOLOGY_EXAMINATION_AUDIT= '[ENTITY] Fetch OphthalmologyExaminationModel audit',
	FETCH_OPHTHALMOLOGY_EXAMINATION_AUDIT_OK = '[ENTITY] Fetch OphthalmologyExaminationModel audit successfully',
	FETCH_OPHTHALMOLOGY_EXAMINATION_AUDIT_FAIL = '[ENTITY] Fetch OphthalmologyExaminationModel audit failed',

	FETCH_OPHTHALMOLOGY_EXAMINATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch OphthalmologyExaminationModel audits by entity id',
	FETCH_OPHTHALMOLOGY_EXAMINATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch OphthalmologyExaminationModel audits by entity id successfully',
	FETCH_OPHTHALMOLOGY_EXAMINATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch OphthalmologyExaminationModel audits by entity id failed',

	FETCH_ALL_OPHTHALMOLOGY_EXAMINATION = '[ENTITY] Fetch all OphthalmologyExaminationModel',
	FETCH_ALL_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Fetch all OphthalmologyExaminationModel successfully',
	FETCH_ALL_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Fetch all OphthalmologyExaminationModel failed',

	FETCH_OPHTHALMOLOGY_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch OphthalmologyExaminationModel with query',
	FETCH_OPHTHALMOLOGY_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch OphthalmologyExaminationModel with query successfully',
	FETCH_OPHTHALMOLOGY_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch OphthalmologyExaminationModel with query failed',

	FETCH_LAST_OPHTHALMOLOGY_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch last OphthalmologyExaminationModel with query',
	FETCH_LAST_OPHTHALMOLOGY_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch last OphthalmologyExaminationModel with query successfully',
	FETCH_LAST_OPHTHALMOLOGY_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last OphthalmologyExaminationModel with query failed',

	EXPORT_OPHTHALMOLOGY_EXAMINATION = '[ENTITY] Export OphthalmologyExaminationModel',
	EXPORT_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Export OphthalmologyExaminationModel successfully',
	EXPORT_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Export OphthalmologyExaminationModel failed',

	EXPORT_ALL_OPHTHALMOLOGY_EXAMINATION = '[ENTITY] Export All OphthalmologyExaminationModels',
	EXPORT_ALL_OPHTHALMOLOGY_EXAMINATION_OK = '[ENTITY] Export All OphthalmologyExaminationModels successfully',
	EXPORT_ALL_OPHTHALMOLOGY_EXAMINATION_FAIL = '[ENTITY] Export All OphthalmologyExaminationModels failed',

	EXPORT_OPHTHALMOLOGY_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Export OphthalmologyExaminationModels excluding Ids',
	EXPORT_OPHTHALMOLOGY_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Export OphthalmologyExaminationModel excluding Ids successfully',
	EXPORT_OPHTHALMOLOGY_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export OphthalmologyExaminationModel excluding Ids failed',

	COUNT_OPHTHALMOLOGY_EXAMINATIONS = '[ENTITY] Fetch number of OphthalmologyExaminationModel records',
	COUNT_OPHTHALMOLOGY_EXAMINATIONS_OK = '[ENTITY] Fetch number of OphthalmologyExaminationModel records successfully ',
	COUNT_OPHTHALMOLOGY_EXAMINATIONS_FAIL = '[ENTITY] Fetch number of OphthalmologyExaminationModel records failed',

	IMPORT_OPHTHALMOLOGY_EXAMINATIONS = '[ENTITY] Import OphthalmologyExaminationModels',
	IMPORT_OPHTHALMOLOGY_EXAMINATIONS_OK = '[ENTITY] Import OphthalmologyExaminationModels successfully',
	IMPORT_OPHTHALMOLOGY_EXAMINATIONS_FAIL = '[ENTITY] Import OphthalmologyExaminationModels fail',


	INITIALISE_OPHTHALMOLOGY_EXAMINATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of OphthalmologyExaminationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseOphthalmologyExaminationAction implements Action {
	readonly className: string = 'OphthalmologyExaminationModel';

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

export class OphthalmologyExaminationAction extends BaseOphthalmologyExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for OphthalmologyExaminationAction here] off begin
	// % protected region % [Add any additional class fields for OphthalmologyExaminationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<OphthalmologyExaminationModel>,
		// % protected region % [Add any additional constructor parameters for OphthalmologyExaminationAction here] off begin
		// % protected region % [Add any additional constructor parameters for OphthalmologyExaminationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for OphthalmologyExaminationAction here] off begin
			// % protected region % [Add any additional constructor arguments for OphthalmologyExaminationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for OphthalmologyExaminationAction here] off begin
		// % protected region % [Add any additional constructor logic for OphthalmologyExaminationAction here] end
	}

	// % protected region % [Add any additional class methods for OphthalmologyExaminationAction here] off begin
	// % protected region % [Add any additional class methods for OphthalmologyExaminationAction here] end
}

export class OphthalmologyExaminationActionOK extends BaseOphthalmologyExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for OphthalmologyExaminationActionOK here] off begin
	// % protected region % [Add any additional class fields for OphthalmologyExaminationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<OphthalmologyExaminationModel>,
		// % protected region % [Add any additional constructor parameters for OphthalmologyExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for OphthalmologyExaminationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: OphthalmologyExaminationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for OphthalmologyExaminationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for OphthalmologyExaminationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for OphthalmologyExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for OphthalmologyExaminationActionOK here] end
	}

	// % protected region % [Add any additional class methods for OphthalmologyExaminationActionOK here] off begin
	// % protected region % [Add any additional class methods for OphthalmologyExaminationActionOK here] end
}

export class OphthalmologyExaminationActionFail extends BaseOphthalmologyExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for OphthalmologyExaminationActionFail here] off begin
	// % protected region % [Add any additional class fields for OphthalmologyExaminationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<OphthalmologyExaminationModel>,
		// % protected region % [Add any additional constructor parameters for OphthalmologyExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for OphthalmologyExaminationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for OphthalmologyExaminationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for OphthalmologyExaminationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for OphthalmologyExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for OphthalmologyExaminationActionFail here] end
	}

	// % protected region % [Add any additional class methods for OphthalmologyExaminationActionFail here] off begin
	// % protected region % [Add any additional class methods for OphthalmologyExaminationActionFail here] end
}

export function isOphthalmologyExaminationModelAction(e: any): e is BaseOphthalmologyExaminationAction {
	return Object.values(OphthalmologyExaminationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
