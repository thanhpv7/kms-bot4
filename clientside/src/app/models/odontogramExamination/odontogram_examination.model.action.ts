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
import {OdontogramExaminationModel} from './odontogram_examination.model';
import {OdontogramExaminationModelAudit} from './odontogram_examination.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Odontogram Examination model actions to be dispatched by NgRx.
 */
export enum OdontogramExaminationModelActionTypes {
	CREATE_ODONTOGRAM_EXAMINATION = '[ENTITY] Create OdontogramExaminationModel',
	CREATE_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Create OdontogramExaminationModel successfully',
	CREATE_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Create OdontogramExaminationModel failed',

	CREATE_ALL_ODONTOGRAM_EXAMINATION = '[ENTITY] Create All OdontogramExaminationModel',
	CREATE_ALL_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Create All OdontogramExaminationModel successfully',
	CREATE_ALL_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Create All OdontogramExaminationModel failed',

	DELETE_ODONTOGRAM_EXAMINATION = '[ENTITY] Delete OdontogramExaminationModel',
	DELETE_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Delete OdontogramExaminationModel successfully',
	DELETE_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Delete OdontogramExaminationModel failed',


	DELETE_ODONTOGRAM_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Delete OdontogramExaminationModels Excluding Ids',
	DELETE_ODONTOGRAM_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Delete OdontogramExaminationModels Excluding Ids successfully',
	DELETE_ODONTOGRAM_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete OdontogramExaminationModels Excluding Ids failed',

	DELETE_ALL_ODONTOGRAM_EXAMINATION = '[ENTITY] Delete all OdontogramExaminationModels',
	DELETE_ALL_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Delete all OdontogramExaminationModels successfully',
	DELETE_ALL_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Delete all OdontogramExaminationModels failed',

	UPDATE_ODONTOGRAM_EXAMINATION = '[ENTITY] Update OdontogramExaminationModel',
	UPDATE_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Update OdontogramExaminationModel successfully',
	UPDATE_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Update OdontogramExaminationModel failed',

	UPDATE_ALL_ODONTOGRAM_EXAMINATION = '[ENTITY] Update all OdontogramExaminationModel',
	UPDATE_ALL_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Update all OdontogramExaminationModel successfully',
	UPDATE_ALL_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Update all OdontogramExaminationModel failed',

	FETCH_ODONTOGRAM_EXAMINATION= '[ENTITY] Fetch OdontogramExaminationModel',
	FETCH_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Fetch OdontogramExaminationModel successfully',
	FETCH_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Fetch OdontogramExaminationModel failed',

	FETCH_ODONTOGRAM_EXAMINATION_AUDIT= '[ENTITY] Fetch OdontogramExaminationModel audit',
	FETCH_ODONTOGRAM_EXAMINATION_AUDIT_OK = '[ENTITY] Fetch OdontogramExaminationModel audit successfully',
	FETCH_ODONTOGRAM_EXAMINATION_AUDIT_FAIL = '[ENTITY] Fetch OdontogramExaminationModel audit failed',

	FETCH_ODONTOGRAM_EXAMINATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch OdontogramExaminationModel audits by entity id',
	FETCH_ODONTOGRAM_EXAMINATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch OdontogramExaminationModel audits by entity id successfully',
	FETCH_ODONTOGRAM_EXAMINATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch OdontogramExaminationModel audits by entity id failed',

	FETCH_ALL_ODONTOGRAM_EXAMINATION = '[ENTITY] Fetch all OdontogramExaminationModel',
	FETCH_ALL_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Fetch all OdontogramExaminationModel successfully',
	FETCH_ALL_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Fetch all OdontogramExaminationModel failed',

	FETCH_ODONTOGRAM_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch OdontogramExaminationModel with query',
	FETCH_ODONTOGRAM_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch OdontogramExaminationModel with query successfully',
	FETCH_ODONTOGRAM_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch OdontogramExaminationModel with query failed',

	FETCH_LAST_ODONTOGRAM_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch last OdontogramExaminationModel with query',
	FETCH_LAST_ODONTOGRAM_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch last OdontogramExaminationModel with query successfully',
	FETCH_LAST_ODONTOGRAM_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last OdontogramExaminationModel with query failed',

	EXPORT_ODONTOGRAM_EXAMINATION = '[ENTITY] Export OdontogramExaminationModel',
	EXPORT_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Export OdontogramExaminationModel successfully',
	EXPORT_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Export OdontogramExaminationModel failed',

	EXPORT_ALL_ODONTOGRAM_EXAMINATION = '[ENTITY] Export All OdontogramExaminationModels',
	EXPORT_ALL_ODONTOGRAM_EXAMINATION_OK = '[ENTITY] Export All OdontogramExaminationModels successfully',
	EXPORT_ALL_ODONTOGRAM_EXAMINATION_FAIL = '[ENTITY] Export All OdontogramExaminationModels failed',

	EXPORT_ODONTOGRAM_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Export OdontogramExaminationModels excluding Ids',
	EXPORT_ODONTOGRAM_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Export OdontogramExaminationModel excluding Ids successfully',
	EXPORT_ODONTOGRAM_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export OdontogramExaminationModel excluding Ids failed',

	COUNT_ODONTOGRAM_EXAMINATIONS = '[ENTITY] Fetch number of OdontogramExaminationModel records',
	COUNT_ODONTOGRAM_EXAMINATIONS_OK = '[ENTITY] Fetch number of OdontogramExaminationModel records successfully ',
	COUNT_ODONTOGRAM_EXAMINATIONS_FAIL = '[ENTITY] Fetch number of OdontogramExaminationModel records failed',

	IMPORT_ODONTOGRAM_EXAMINATIONS = '[ENTITY] Import OdontogramExaminationModels',
	IMPORT_ODONTOGRAM_EXAMINATIONS_OK = '[ENTITY] Import OdontogramExaminationModels successfully',
	IMPORT_ODONTOGRAM_EXAMINATIONS_FAIL = '[ENTITY] Import OdontogramExaminationModels fail',


	INITIALISE_ODONTOGRAM_EXAMINATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of OdontogramExaminationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseOdontogramExaminationAction implements Action {
	readonly className: string = 'OdontogramExaminationModel';

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

export class OdontogramExaminationAction extends BaseOdontogramExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for OdontogramExaminationAction here] off begin
	// % protected region % [Add any additional class fields for OdontogramExaminationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<OdontogramExaminationModel>,
		// % protected region % [Add any additional constructor parameters for OdontogramExaminationAction here] off begin
		// % protected region % [Add any additional constructor parameters for OdontogramExaminationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for OdontogramExaminationAction here] off begin
			// % protected region % [Add any additional constructor arguments for OdontogramExaminationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for OdontogramExaminationAction here] off begin
		// % protected region % [Add any additional constructor logic for OdontogramExaminationAction here] end
	}

	// % protected region % [Add any additional class methods for OdontogramExaminationAction here] off begin
	// % protected region % [Add any additional class methods for OdontogramExaminationAction here] end
}

export class OdontogramExaminationActionOK extends BaseOdontogramExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for OdontogramExaminationActionOK here] off begin
	// % protected region % [Add any additional class fields for OdontogramExaminationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<OdontogramExaminationModel>,
		// % protected region % [Add any additional constructor parameters for OdontogramExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for OdontogramExaminationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: OdontogramExaminationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for OdontogramExaminationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for OdontogramExaminationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for OdontogramExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for OdontogramExaminationActionOK here] end
	}

	// % protected region % [Add any additional class methods for OdontogramExaminationActionOK here] off begin
	// % protected region % [Add any additional class methods for OdontogramExaminationActionOK here] end
}

export class OdontogramExaminationActionFail extends BaseOdontogramExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for OdontogramExaminationActionFail here] off begin
	// % protected region % [Add any additional class fields for OdontogramExaminationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<OdontogramExaminationModel>,
		// % protected region % [Add any additional constructor parameters for OdontogramExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for OdontogramExaminationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for OdontogramExaminationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for OdontogramExaminationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for OdontogramExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for OdontogramExaminationActionFail here] end
	}

	// % protected region % [Add any additional class methods for OdontogramExaminationActionFail here] off begin
	// % protected region % [Add any additional class methods for OdontogramExaminationActionFail here] end
}

export function isOdontogramExaminationModelAction(e: any): e is BaseOdontogramExaminationAction {
	return Object.values(OdontogramExaminationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
