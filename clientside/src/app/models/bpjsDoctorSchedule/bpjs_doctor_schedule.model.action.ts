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
import {BpjsDoctorScheduleModel} from './bpjs_doctor_schedule.model';
import {BpjsDoctorScheduleModelAudit} from './bpjs_doctor_schedule.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Doctor Schedule model actions to be dispatched by NgRx.
 */
export enum BpjsDoctorScheduleModelActionTypes {
	CREATE_BPJS_DOCTOR_SCHEDULE = '[ENTITY] Create BpjsDoctorScheduleModel',
	CREATE_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Create BpjsDoctorScheduleModel successfully',
	CREATE_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Create BpjsDoctorScheduleModel failed',

	CREATE_ALL_BPJS_DOCTOR_SCHEDULE = '[ENTITY] Create All BpjsDoctorScheduleModel',
	CREATE_ALL_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Create All BpjsDoctorScheduleModel successfully',
	CREATE_ALL_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Create All BpjsDoctorScheduleModel failed',

	DELETE_BPJS_DOCTOR_SCHEDULE = '[ENTITY] Delete BpjsDoctorScheduleModel',
	DELETE_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Delete BpjsDoctorScheduleModel successfully',
	DELETE_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Delete BpjsDoctorScheduleModel failed',


	DELETE_BPJS_DOCTOR_SCHEDULE_EXCLUDING_IDS = '[ENTITY] Delete BpjsDoctorScheduleModels Excluding Ids',
	DELETE_BPJS_DOCTOR_SCHEDULE_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsDoctorScheduleModels Excluding Ids successfully',
	DELETE_BPJS_DOCTOR_SCHEDULE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsDoctorScheduleModels Excluding Ids failed',

	DELETE_ALL_BPJS_DOCTOR_SCHEDULE = '[ENTITY] Delete all BpjsDoctorScheduleModels',
	DELETE_ALL_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Delete all BpjsDoctorScheduleModels successfully',
	DELETE_ALL_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Delete all BpjsDoctorScheduleModels failed',

	UPDATE_BPJS_DOCTOR_SCHEDULE = '[ENTITY] Update BpjsDoctorScheduleModel',
	UPDATE_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Update BpjsDoctorScheduleModel successfully',
	UPDATE_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Update BpjsDoctorScheduleModel failed',

	UPDATE_ALL_BPJS_DOCTOR_SCHEDULE = '[ENTITY] Update all BpjsDoctorScheduleModel',
	UPDATE_ALL_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Update all BpjsDoctorScheduleModel successfully',
	UPDATE_ALL_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Update all BpjsDoctorScheduleModel failed',

	FETCH_BPJS_DOCTOR_SCHEDULE= '[ENTITY] Fetch BpjsDoctorScheduleModel',
	FETCH_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Fetch BpjsDoctorScheduleModel successfully',
	FETCH_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Fetch BpjsDoctorScheduleModel failed',

	FETCH_BPJS_DOCTOR_SCHEDULE_AUDIT= '[ENTITY] Fetch BpjsDoctorScheduleModel audit',
	FETCH_BPJS_DOCTOR_SCHEDULE_AUDIT_OK = '[ENTITY] Fetch BpjsDoctorScheduleModel audit successfully',
	FETCH_BPJS_DOCTOR_SCHEDULE_AUDIT_FAIL = '[ENTITY] Fetch BpjsDoctorScheduleModel audit failed',

	FETCH_BPJS_DOCTOR_SCHEDULE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsDoctorScheduleModel audits by entity id',
	FETCH_BPJS_DOCTOR_SCHEDULE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsDoctorScheduleModel audits by entity id successfully',
	FETCH_BPJS_DOCTOR_SCHEDULE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsDoctorScheduleModel audits by entity id failed',

	FETCH_ALL_BPJS_DOCTOR_SCHEDULE = '[ENTITY] Fetch all BpjsDoctorScheduleModel',
	FETCH_ALL_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Fetch all BpjsDoctorScheduleModel successfully',
	FETCH_ALL_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Fetch all BpjsDoctorScheduleModel failed',

	FETCH_BPJS_DOCTOR_SCHEDULE_WITH_QUERY = '[ENTITY] Fetch BpjsDoctorScheduleModel with query',
	FETCH_BPJS_DOCTOR_SCHEDULE_WITH_QUERY_OK = '[ENTITY] Fetch BpjsDoctorScheduleModel with query successfully',
	FETCH_BPJS_DOCTOR_SCHEDULE_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsDoctorScheduleModel with query failed',

	FETCH_LAST_BPJS_DOCTOR_SCHEDULE_WITH_QUERY = '[ENTITY] Fetch last BpjsDoctorScheduleModel with query',
	FETCH_LAST_BPJS_DOCTOR_SCHEDULE_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsDoctorScheduleModel with query successfully',
	FETCH_LAST_BPJS_DOCTOR_SCHEDULE_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsDoctorScheduleModel with query failed',

	EXPORT_BPJS_DOCTOR_SCHEDULE = '[ENTITY] Export BpjsDoctorScheduleModel',
	EXPORT_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Export BpjsDoctorScheduleModel successfully',
	EXPORT_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Export BpjsDoctorScheduleModel failed',

	EXPORT_ALL_BPJS_DOCTOR_SCHEDULE = '[ENTITY] Export All BpjsDoctorScheduleModels',
	EXPORT_ALL_BPJS_DOCTOR_SCHEDULE_OK = '[ENTITY] Export All BpjsDoctorScheduleModels successfully',
	EXPORT_ALL_BPJS_DOCTOR_SCHEDULE_FAIL = '[ENTITY] Export All BpjsDoctorScheduleModels failed',

	EXPORT_BPJS_DOCTOR_SCHEDULE_EXCLUDING_IDS = '[ENTITY] Export BpjsDoctorScheduleModels excluding Ids',
	EXPORT_BPJS_DOCTOR_SCHEDULE_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsDoctorScheduleModel excluding Ids successfully',
	EXPORT_BPJS_DOCTOR_SCHEDULE_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsDoctorScheduleModel excluding Ids failed',

	COUNT_BPJS_DOCTOR_SCHEDULES = '[ENTITY] Fetch number of BpjsDoctorScheduleModel records',
	COUNT_BPJS_DOCTOR_SCHEDULES_OK = '[ENTITY] Fetch number of BpjsDoctorScheduleModel records successfully ',
	COUNT_BPJS_DOCTOR_SCHEDULES_FAIL = '[ENTITY] Fetch number of BpjsDoctorScheduleModel records failed',

	IMPORT_BPJS_DOCTOR_SCHEDULES = '[ENTITY] Import BpjsDoctorScheduleModels',
	IMPORT_BPJS_DOCTOR_SCHEDULES_OK = '[ENTITY] Import BpjsDoctorScheduleModels successfully',
	IMPORT_BPJS_DOCTOR_SCHEDULES_FAIL = '[ENTITY] Import BpjsDoctorScheduleModels fail',


	INITIALISE_BPJS_DOCTOR_SCHEDULE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsDoctorScheduleModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsDoctorScheduleAction implements Action {
	readonly className: string = 'BpjsDoctorScheduleModel';

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

export class BpjsDoctorScheduleAction extends BaseBpjsDoctorScheduleAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDoctorScheduleAction here] off begin
	// % protected region % [Add any additional class fields for BpjsDoctorScheduleAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDoctorScheduleModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDoctorScheduleAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDoctorScheduleAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDoctorScheduleAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDoctorScheduleAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDoctorScheduleAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDoctorScheduleAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsDoctorScheduleAction here] off begin
	// % protected region % [Add any additional class methods for BpjsDoctorScheduleAction here] end
}

export class BpjsDoctorScheduleActionOK extends BaseBpjsDoctorScheduleAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDoctorScheduleActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsDoctorScheduleActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDoctorScheduleModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDoctorScheduleActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDoctorScheduleActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsDoctorScheduleModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDoctorScheduleActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDoctorScheduleActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDoctorScheduleActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDoctorScheduleActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsDoctorScheduleActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsDoctorScheduleActionOK here] end
}

export class BpjsDoctorScheduleActionFail extends BaseBpjsDoctorScheduleAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDoctorScheduleActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsDoctorScheduleActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsDoctorScheduleModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDoctorScheduleActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDoctorScheduleActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDoctorScheduleActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDoctorScheduleActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDoctorScheduleActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDoctorScheduleActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsDoctorScheduleActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsDoctorScheduleActionFail here] end
}

export function isBpjsDoctorScheduleModelAction(e: any): e is BaseBpjsDoctorScheduleAction {
	return Object.values(BpjsDoctorScheduleModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
