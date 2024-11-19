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
import {CoTreatingDoctorModel} from './co_treating_doctor.model';
import {CoTreatingDoctorModelAudit} from './co_treating_doctor.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Co Treating Doctor model actions to be dispatched by NgRx.
 */
export enum CoTreatingDoctorModelActionTypes {
	CREATE_CO_TREATING_DOCTOR = '[ENTITY] Create CoTreatingDoctorModel',
	CREATE_CO_TREATING_DOCTOR_OK = '[ENTITY] Create CoTreatingDoctorModel successfully',
	CREATE_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Create CoTreatingDoctorModel failed',

	CREATE_ALL_CO_TREATING_DOCTOR = '[ENTITY] Create All CoTreatingDoctorModel',
	CREATE_ALL_CO_TREATING_DOCTOR_OK = '[ENTITY] Create All CoTreatingDoctorModel successfully',
	CREATE_ALL_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Create All CoTreatingDoctorModel failed',

	DELETE_CO_TREATING_DOCTOR = '[ENTITY] Delete CoTreatingDoctorModel',
	DELETE_CO_TREATING_DOCTOR_OK = '[ENTITY] Delete CoTreatingDoctorModel successfully',
	DELETE_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Delete CoTreatingDoctorModel failed',


	DELETE_CO_TREATING_DOCTOR_EXCLUDING_IDS = '[ENTITY] Delete CoTreatingDoctorModels Excluding Ids',
	DELETE_CO_TREATING_DOCTOR_EXCLUDING_IDS_OK = '[ENTITY] Delete CoTreatingDoctorModels Excluding Ids successfully',
	DELETE_CO_TREATING_DOCTOR_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CoTreatingDoctorModels Excluding Ids failed',

	DELETE_ALL_CO_TREATING_DOCTOR = '[ENTITY] Delete all CoTreatingDoctorModels',
	DELETE_ALL_CO_TREATING_DOCTOR_OK = '[ENTITY] Delete all CoTreatingDoctorModels successfully',
	DELETE_ALL_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Delete all CoTreatingDoctorModels failed',

	UPDATE_CO_TREATING_DOCTOR = '[ENTITY] Update CoTreatingDoctorModel',
	UPDATE_CO_TREATING_DOCTOR_OK = '[ENTITY] Update CoTreatingDoctorModel successfully',
	UPDATE_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Update CoTreatingDoctorModel failed',

	UPDATE_ALL_CO_TREATING_DOCTOR = '[ENTITY] Update all CoTreatingDoctorModel',
	UPDATE_ALL_CO_TREATING_DOCTOR_OK = '[ENTITY] Update all CoTreatingDoctorModel successfully',
	UPDATE_ALL_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Update all CoTreatingDoctorModel failed',

	FETCH_CO_TREATING_DOCTOR= '[ENTITY] Fetch CoTreatingDoctorModel',
	FETCH_CO_TREATING_DOCTOR_OK = '[ENTITY] Fetch CoTreatingDoctorModel successfully',
	FETCH_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Fetch CoTreatingDoctorModel failed',

	FETCH_CO_TREATING_DOCTOR_AUDIT= '[ENTITY] Fetch CoTreatingDoctorModel audit',
	FETCH_CO_TREATING_DOCTOR_AUDIT_OK = '[ENTITY] Fetch CoTreatingDoctorModel audit successfully',
	FETCH_CO_TREATING_DOCTOR_AUDIT_FAIL = '[ENTITY] Fetch CoTreatingDoctorModel audit failed',

	FETCH_CO_TREATING_DOCTOR_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CoTreatingDoctorModel audits by entity id',
	FETCH_CO_TREATING_DOCTOR_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CoTreatingDoctorModel audits by entity id successfully',
	FETCH_CO_TREATING_DOCTOR_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CoTreatingDoctorModel audits by entity id failed',

	FETCH_ALL_CO_TREATING_DOCTOR = '[ENTITY] Fetch all CoTreatingDoctorModel',
	FETCH_ALL_CO_TREATING_DOCTOR_OK = '[ENTITY] Fetch all CoTreatingDoctorModel successfully',
	FETCH_ALL_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Fetch all CoTreatingDoctorModel failed',

	FETCH_CO_TREATING_DOCTOR_WITH_QUERY = '[ENTITY] Fetch CoTreatingDoctorModel with query',
	FETCH_CO_TREATING_DOCTOR_WITH_QUERY_OK = '[ENTITY] Fetch CoTreatingDoctorModel with query successfully',
	FETCH_CO_TREATING_DOCTOR_WITH_QUERY_FAIL = '[ENTITY] Fetch CoTreatingDoctorModel with query failed',

	FETCH_LAST_CO_TREATING_DOCTOR_WITH_QUERY = '[ENTITY] Fetch last CoTreatingDoctorModel with query',
	FETCH_LAST_CO_TREATING_DOCTOR_WITH_QUERY_OK = '[ENTITY] Fetch last CoTreatingDoctorModel with query successfully',
	FETCH_LAST_CO_TREATING_DOCTOR_WITH_QUERY_FAIL = '[ENTITY] Fetch last CoTreatingDoctorModel with query failed',

	EXPORT_CO_TREATING_DOCTOR = '[ENTITY] Export CoTreatingDoctorModel',
	EXPORT_CO_TREATING_DOCTOR_OK = '[ENTITY] Export CoTreatingDoctorModel successfully',
	EXPORT_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Export CoTreatingDoctorModel failed',

	EXPORT_ALL_CO_TREATING_DOCTOR = '[ENTITY] Export All CoTreatingDoctorModels',
	EXPORT_ALL_CO_TREATING_DOCTOR_OK = '[ENTITY] Export All CoTreatingDoctorModels successfully',
	EXPORT_ALL_CO_TREATING_DOCTOR_FAIL = '[ENTITY] Export All CoTreatingDoctorModels failed',

	EXPORT_CO_TREATING_DOCTOR_EXCLUDING_IDS = '[ENTITY] Export CoTreatingDoctorModels excluding Ids',
	EXPORT_CO_TREATING_DOCTOR_EXCLUDING_IDS_OK = '[ENTITY] Export CoTreatingDoctorModel excluding Ids successfully',
	EXPORT_CO_TREATING_DOCTOR_EXCLUDING_IDS_FAIL = '[ENTITY] Export CoTreatingDoctorModel excluding Ids failed',

	COUNT_CO_TREATING_DOCTORS = '[ENTITY] Fetch number of CoTreatingDoctorModel records',
	COUNT_CO_TREATING_DOCTORS_OK = '[ENTITY] Fetch number of CoTreatingDoctorModel records successfully ',
	COUNT_CO_TREATING_DOCTORS_FAIL = '[ENTITY] Fetch number of CoTreatingDoctorModel records failed',

	IMPORT_CO_TREATING_DOCTORS = '[ENTITY] Import CoTreatingDoctorModels',
	IMPORT_CO_TREATING_DOCTORS_OK = '[ENTITY] Import CoTreatingDoctorModels successfully',
	IMPORT_CO_TREATING_DOCTORS_FAIL = '[ENTITY] Import CoTreatingDoctorModels fail',


	INITIALISE_CO_TREATING_DOCTOR_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CoTreatingDoctorModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCoTreatingDoctorAction implements Action {
	readonly className: string = 'CoTreatingDoctorModel';

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

export class CoTreatingDoctorAction extends BaseCoTreatingDoctorAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CoTreatingDoctorAction here] off begin
	// % protected region % [Add any additional class fields for CoTreatingDoctorAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CoTreatingDoctorModel>,
		// % protected region % [Add any additional constructor parameters for CoTreatingDoctorAction here] off begin
		// % protected region % [Add any additional constructor parameters for CoTreatingDoctorAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CoTreatingDoctorAction here] off begin
			// % protected region % [Add any additional constructor arguments for CoTreatingDoctorAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CoTreatingDoctorAction here] off begin
		// % protected region % [Add any additional constructor logic for CoTreatingDoctorAction here] end
	}

	// % protected region % [Add any additional class methods for CoTreatingDoctorAction here] off begin
	// % protected region % [Add any additional class methods for CoTreatingDoctorAction here] end
}

export class CoTreatingDoctorActionOK extends BaseCoTreatingDoctorAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CoTreatingDoctorActionOK here] off begin
	// % protected region % [Add any additional class fields for CoTreatingDoctorActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CoTreatingDoctorModel>,
		// % protected region % [Add any additional constructor parameters for CoTreatingDoctorActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CoTreatingDoctorActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CoTreatingDoctorModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CoTreatingDoctorActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CoTreatingDoctorActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CoTreatingDoctorActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CoTreatingDoctorActionOK here] end
	}

	// % protected region % [Add any additional class methods for CoTreatingDoctorActionOK here] off begin
	// % protected region % [Add any additional class methods for CoTreatingDoctorActionOK here] end
}

export class CoTreatingDoctorActionFail extends BaseCoTreatingDoctorAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CoTreatingDoctorActionFail here] off begin
	// % protected region % [Add any additional class fields for CoTreatingDoctorActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CoTreatingDoctorModel>,
		// % protected region % [Add any additional constructor parameters for CoTreatingDoctorActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CoTreatingDoctorActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CoTreatingDoctorActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CoTreatingDoctorActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CoTreatingDoctorActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CoTreatingDoctorActionFail here] end
	}

	// % protected region % [Add any additional class methods for CoTreatingDoctorActionFail here] off begin
	// % protected region % [Add any additional class methods for CoTreatingDoctorActionFail here] end
}

export function isCoTreatingDoctorModelAction(e: any): e is BaseCoTreatingDoctorAction {
	return Object.values(CoTreatingDoctorModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
