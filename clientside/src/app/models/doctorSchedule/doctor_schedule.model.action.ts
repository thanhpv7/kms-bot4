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
import {DoctorScheduleModel} from './doctor_schedule.model';
import {DoctorScheduleModelAudit} from './doctor_schedule.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Doctor Schedule model actions to be dispatched by NgRx.
 */
export enum DoctorScheduleModelActionTypes {
	CREATE_DOCTOR_SCHEDULE = '[ENTITY] Create DoctorScheduleModel',
	CREATE_DOCTOR_SCHEDULE_OK = '[ENTITY] Create DoctorScheduleModel successfully',
	CREATE_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Create DoctorScheduleModel failed',

	CREATE_ALL_DOCTOR_SCHEDULE = '[ENTITY] Create All DoctorScheduleModel',
	CREATE_ALL_DOCTOR_SCHEDULE_OK = '[ENTITY] Create All DoctorScheduleModel successfully',
	CREATE_ALL_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Create All DoctorScheduleModel failed',

	DELETE_DOCTOR_SCHEDULE = '[ENTITY] Delete DoctorScheduleModel',
	DELETE_DOCTOR_SCHEDULE_OK = '[ENTITY] Delete DoctorScheduleModel successfully',
	DELETE_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Delete DoctorScheduleModel failed',


	DELETE_DOCTOR_SCHEDULE_EXCLUDING_IDS = '[ENTITY] Delete DoctorScheduleModels Excluding Ids',
	DELETE_DOCTOR_SCHEDULE_EXCLUDING_IDS_OK = '[ENTITY] Delete DoctorScheduleModels Excluding Ids successfully',
	DELETE_DOCTOR_SCHEDULE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DoctorScheduleModels Excluding Ids failed',

	DELETE_ALL_DOCTOR_SCHEDULE = '[ENTITY] Delete all DoctorScheduleModels',
	DELETE_ALL_DOCTOR_SCHEDULE_OK = '[ENTITY] Delete all DoctorScheduleModels successfully',
	DELETE_ALL_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Delete all DoctorScheduleModels failed',

	UPDATE_DOCTOR_SCHEDULE = '[ENTITY] Update DoctorScheduleModel',
	UPDATE_DOCTOR_SCHEDULE_OK = '[ENTITY] Update DoctorScheduleModel successfully',
	UPDATE_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Update DoctorScheduleModel failed',

	UPDATE_ALL_DOCTOR_SCHEDULE = '[ENTITY] Update all DoctorScheduleModel',
	UPDATE_ALL_DOCTOR_SCHEDULE_OK = '[ENTITY] Update all DoctorScheduleModel successfully',
	UPDATE_ALL_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Update all DoctorScheduleModel failed',

	FETCH_DOCTOR_SCHEDULE= '[ENTITY] Fetch DoctorScheduleModel',
	FETCH_DOCTOR_SCHEDULE_OK = '[ENTITY] Fetch DoctorScheduleModel successfully',
	FETCH_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Fetch DoctorScheduleModel failed',

	FETCH_DOCTOR_SCHEDULE_AUDIT= '[ENTITY] Fetch DoctorScheduleModel audit',
	FETCH_DOCTOR_SCHEDULE_AUDIT_OK = '[ENTITY] Fetch DoctorScheduleModel audit successfully',
	FETCH_DOCTOR_SCHEDULE_AUDIT_FAIL = '[ENTITY] Fetch DoctorScheduleModel audit failed',

	FETCH_DOCTOR_SCHEDULE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DoctorScheduleModel audits by entity id',
	FETCH_DOCTOR_SCHEDULE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DoctorScheduleModel audits by entity id successfully',
	FETCH_DOCTOR_SCHEDULE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DoctorScheduleModel audits by entity id failed',

	FETCH_ALL_DOCTOR_SCHEDULE = '[ENTITY] Fetch all DoctorScheduleModel',
	FETCH_ALL_DOCTOR_SCHEDULE_OK = '[ENTITY] Fetch all DoctorScheduleModel successfully',
	FETCH_ALL_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Fetch all DoctorScheduleModel failed',

	FETCH_DOCTOR_SCHEDULE_WITH_QUERY = '[ENTITY] Fetch DoctorScheduleModel with query',
	FETCH_DOCTOR_SCHEDULE_WITH_QUERY_OK = '[ENTITY] Fetch DoctorScheduleModel with query successfully',
	FETCH_DOCTOR_SCHEDULE_WITH_QUERY_FAIL = '[ENTITY] Fetch DoctorScheduleModel with query failed',

	FETCH_LAST_DOCTOR_SCHEDULE_WITH_QUERY = '[ENTITY] Fetch last DoctorScheduleModel with query',
	FETCH_LAST_DOCTOR_SCHEDULE_WITH_QUERY_OK = '[ENTITY] Fetch last DoctorScheduleModel with query successfully',
	FETCH_LAST_DOCTOR_SCHEDULE_WITH_QUERY_FAIL = '[ENTITY] Fetch last DoctorScheduleModel with query failed',

	EXPORT_DOCTOR_SCHEDULE = '[ENTITY] Export DoctorScheduleModel',
	EXPORT_DOCTOR_SCHEDULE_OK = '[ENTITY] Export DoctorScheduleModel successfully',
	EXPORT_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Export DoctorScheduleModel failed',

	EXPORT_ALL_DOCTOR_SCHEDULE = '[ENTITY] Export All DoctorScheduleModels',
	EXPORT_ALL_DOCTOR_SCHEDULE_OK = '[ENTITY] Export All DoctorScheduleModels successfully',
	EXPORT_ALL_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Export All DoctorScheduleModels failed',

	EXPORT_DOCTOR_SCHEDULE_EXCLUDING_IDS = '[ENTITY] Export DoctorScheduleModels excluding Ids',
	EXPORT_DOCTOR_SCHEDULE_EXCLUDING_IDS_OK = '[ENTITY] Export DoctorScheduleModel excluding Ids successfully',
	EXPORT_DOCTOR_SCHEDULE_EXCLUDING_IDS_FAIL = '[ENTITY] Export DoctorScheduleModel excluding Ids failed',

	COUNT_DOCTOR_SCHEDULES = '[ENTITY] Fetch number of DoctorScheduleModel records',
	COUNT_DOCTOR_SCHEDULES_OK = '[ENTITY] Fetch number of DoctorScheduleModel records successfully ',
	COUNT_DOCTOR_SCHEDULES_FAIL = '[ENTITY] Fetch number of DoctorScheduleModel records failed',

	IMPORT_DOCTOR_SCHEDULES = '[ENTITY] Import DoctorScheduleModels',
	IMPORT_DOCTOR_SCHEDULES_OK = '[ENTITY] Import DoctorScheduleModels successfully',
	IMPORT_DOCTOR_SCHEDULES_FAIL = '[ENTITY] Import DoctorScheduleModels fail',


	INITIALISE_DOCTOR_SCHEDULE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DoctorScheduleModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDoctorScheduleAction implements Action {
	readonly className: string = 'DoctorScheduleModel';

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

export class DoctorScheduleAction extends BaseDoctorScheduleAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DoctorScheduleAction here] off begin
	// % protected region % [Add any additional class fields for DoctorScheduleAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DoctorScheduleModel>,
		// % protected region % [Add any additional constructor parameters for DoctorScheduleAction here] off begin
		// % protected region % [Add any additional constructor parameters for DoctorScheduleAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DoctorScheduleAction here] off begin
			// % protected region % [Add any additional constructor arguments for DoctorScheduleAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DoctorScheduleAction here] off begin
		// % protected region % [Add any additional constructor logic for DoctorScheduleAction here] end
	}

	// % protected region % [Add any additional class methods for DoctorScheduleAction here] off begin
	// % protected region % [Add any additional class methods for DoctorScheduleAction here] end
}

export class DoctorScheduleActionOK extends BaseDoctorScheduleAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DoctorScheduleActionOK here] off begin
	// % protected region % [Add any additional class fields for DoctorScheduleActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DoctorScheduleModel>,
		// % protected region % [Add any additional constructor parameters for DoctorScheduleActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DoctorScheduleActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DoctorScheduleModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DoctorScheduleActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DoctorScheduleActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DoctorScheduleActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DoctorScheduleActionOK here] end
	}

	// % protected region % [Add any additional class methods for DoctorScheduleActionOK here] off begin
	// % protected region % [Add any additional class methods for DoctorScheduleActionOK here] end
}

export class DoctorScheduleActionFail extends BaseDoctorScheduleAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DoctorScheduleActionFail here] off begin
	// % protected region % [Add any additional class fields for DoctorScheduleActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DoctorScheduleModel>,
		// % protected region % [Add any additional constructor parameters for DoctorScheduleActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DoctorScheduleActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DoctorScheduleActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DoctorScheduleActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DoctorScheduleActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DoctorScheduleActionFail here] end
	}

	// % protected region % [Add any additional class methods for DoctorScheduleActionFail here] off begin
	// % protected region % [Add any additional class methods for DoctorScheduleActionFail here] end
}

export function isDoctorScheduleModelAction(e: any): e is BaseDoctorScheduleAction {
	return Object.values(DoctorScheduleModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
