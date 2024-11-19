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
import {MedicalCertificateMedicalAttendanceModel} from './medical_certificate_medical_attendance.model';
import {MedicalCertificateMedicalAttendanceModelAudit} from './medical_certificate_medical_attendance.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Certificate Medical Attendance model actions to be dispatched by NgRx.
 */
export enum MedicalCertificateMedicalAttendanceModelActionTypes {
	CREATE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE = '[ENTITY] Create MedicalCertificateMedicalAttendanceModel',
	CREATE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Create MedicalCertificateMedicalAttendanceModel successfully',
	CREATE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Create MedicalCertificateMedicalAttendanceModel failed',

	CREATE_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE = '[ENTITY] Create All MedicalCertificateMedicalAttendanceModel',
	CREATE_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Create All MedicalCertificateMedicalAttendanceModel successfully',
	CREATE_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Create All MedicalCertificateMedicalAttendanceModel failed',

	DELETE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE = '[ENTITY] Delete MedicalCertificateMedicalAttendanceModel',
	DELETE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Delete MedicalCertificateMedicalAttendanceModel successfully',
	DELETE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Delete MedicalCertificateMedicalAttendanceModel failed',


	DELETE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_EXCLUDING_IDS = '[ENTITY] Delete MedicalCertificateMedicalAttendanceModels Excluding Ids',
	DELETE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalCertificateMedicalAttendanceModels Excluding Ids successfully',
	DELETE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalCertificateMedicalAttendanceModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE = '[ENTITY] Delete all MedicalCertificateMedicalAttendanceModels',
	DELETE_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Delete all MedicalCertificateMedicalAttendanceModels successfully',
	DELETE_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Delete all MedicalCertificateMedicalAttendanceModels failed',

	UPDATE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE = '[ENTITY] Update MedicalCertificateMedicalAttendanceModel',
	UPDATE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Update MedicalCertificateMedicalAttendanceModel successfully',
	UPDATE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Update MedicalCertificateMedicalAttendanceModel failed',

	UPDATE_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE = '[ENTITY] Update all MedicalCertificateMedicalAttendanceModel',
	UPDATE_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Update all MedicalCertificateMedicalAttendanceModel successfully',
	UPDATE_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Update all MedicalCertificateMedicalAttendanceModel failed',

	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE= '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel',
	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel successfully',
	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel failed',

	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_AUDIT= '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel audit',
	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_AUDIT_OK = '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel audit successfully',
	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_AUDIT_FAIL = '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel audit failed',

	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel audits by entity id',
	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel audits by entity id successfully',
	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel audits by entity id failed',

	FETCH_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE = '[ENTITY] Fetch all MedicalCertificateMedicalAttendanceModel',
	FETCH_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Fetch all MedicalCertificateMedicalAttendanceModel successfully',
	FETCH_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Fetch all MedicalCertificateMedicalAttendanceModel failed',

	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_WITH_QUERY = '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel with query',
	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_WITH_QUERY_OK = '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel with query successfully',
	FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalCertificateMedicalAttendanceModel with query failed',

	FETCH_LAST_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_WITH_QUERY = '[ENTITY] Fetch last MedicalCertificateMedicalAttendanceModel with query',
	FETCH_LAST_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalCertificateMedicalAttendanceModel with query successfully',
	FETCH_LAST_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalCertificateMedicalAttendanceModel with query failed',

	EXPORT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE = '[ENTITY] Export MedicalCertificateMedicalAttendanceModel',
	EXPORT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Export MedicalCertificateMedicalAttendanceModel successfully',
	EXPORT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Export MedicalCertificateMedicalAttendanceModel failed',

	EXPORT_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE = '[ENTITY] Export All MedicalCertificateMedicalAttendanceModels',
	EXPORT_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_OK = '[ENTITY] Export All MedicalCertificateMedicalAttendanceModels successfully',
	EXPORT_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_FAIL = '[ENTITY] Export All MedicalCertificateMedicalAttendanceModels failed',

	EXPORT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_EXCLUDING_IDS = '[ENTITY] Export MedicalCertificateMedicalAttendanceModels excluding Ids',
	EXPORT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalCertificateMedicalAttendanceModel excluding Ids successfully',
	EXPORT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalCertificateMedicalAttendanceModel excluding Ids failed',

	COUNT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCES = '[ENTITY] Fetch number of MedicalCertificateMedicalAttendanceModel records',
	COUNT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCES_OK = '[ENTITY] Fetch number of MedicalCertificateMedicalAttendanceModel records successfully ',
	COUNT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCES_FAIL = '[ENTITY] Fetch number of MedicalCertificateMedicalAttendanceModel records failed',

	IMPORT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCES = '[ENTITY] Import MedicalCertificateMedicalAttendanceModels',
	IMPORT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCES_OK = '[ENTITY] Import MedicalCertificateMedicalAttendanceModels successfully',
	IMPORT_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCES_FAIL = '[ENTITY] Import MedicalCertificateMedicalAttendanceModels fail',


	INITIALISE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalCertificateMedicalAttendanceModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalCertificateMedicalAttendanceAction implements Action {
	readonly className: string = 'MedicalCertificateMedicalAttendanceModel';

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

export class MedicalCertificateMedicalAttendanceAction extends BaseMedicalCertificateMedicalAttendanceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateMedicalAttendanceAction here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateMedicalAttendanceAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateMedicalAttendanceModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMedicalAttendanceAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMedicalAttendanceAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMedicalAttendanceAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMedicalAttendanceAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateMedicalAttendanceAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateMedicalAttendanceAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateMedicalAttendanceAction here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateMedicalAttendanceAction here] end
}

export class MedicalCertificateMedicalAttendanceActionOK extends BaseMedicalCertificateMedicalAttendanceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateMedicalAttendanceActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateMedicalAttendanceActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateMedicalAttendanceModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMedicalAttendanceActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMedicalAttendanceActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalCertificateMedicalAttendanceModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMedicalAttendanceActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMedicalAttendanceActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateMedicalAttendanceActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateMedicalAttendanceActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateMedicalAttendanceActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateMedicalAttendanceActionOK here] end
}

export class MedicalCertificateMedicalAttendanceActionFail extends BaseMedicalCertificateMedicalAttendanceAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateMedicalAttendanceActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateMedicalAttendanceActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalCertificateMedicalAttendanceModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMedicalAttendanceActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMedicalAttendanceActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMedicalAttendanceActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMedicalAttendanceActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateMedicalAttendanceActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateMedicalAttendanceActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateMedicalAttendanceActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateMedicalAttendanceActionFail here] end
}

export function isMedicalCertificateMedicalAttendanceModelAction(e: any): e is BaseMedicalCertificateMedicalAttendanceAction {
	return Object.values(MedicalCertificateMedicalAttendanceModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
