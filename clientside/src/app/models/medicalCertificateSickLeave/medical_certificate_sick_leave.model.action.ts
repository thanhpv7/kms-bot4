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
import {MedicalCertificateSickLeaveModel} from './medical_certificate_sick_leave.model';
import {MedicalCertificateSickLeaveModelAudit} from './medical_certificate_sick_leave.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Certificate Sick Leave model actions to be dispatched by NgRx.
 */
export enum MedicalCertificateSickLeaveModelActionTypes {
	CREATE_MEDICAL_CERTIFICATE_SICK_LEAVE = '[ENTITY] Create MedicalCertificateSickLeaveModel',
	CREATE_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Create MedicalCertificateSickLeaveModel successfully',
	CREATE_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Create MedicalCertificateSickLeaveModel failed',

	CREATE_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE = '[ENTITY] Create All MedicalCertificateSickLeaveModel',
	CREATE_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Create All MedicalCertificateSickLeaveModel successfully',
	CREATE_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Create All MedicalCertificateSickLeaveModel failed',

	DELETE_MEDICAL_CERTIFICATE_SICK_LEAVE = '[ENTITY] Delete MedicalCertificateSickLeaveModel',
	DELETE_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Delete MedicalCertificateSickLeaveModel successfully',
	DELETE_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Delete MedicalCertificateSickLeaveModel failed',


	DELETE_MEDICAL_CERTIFICATE_SICK_LEAVE_EXCLUDING_IDS = '[ENTITY] Delete MedicalCertificateSickLeaveModels Excluding Ids',
	DELETE_MEDICAL_CERTIFICATE_SICK_LEAVE_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalCertificateSickLeaveModels Excluding Ids successfully',
	DELETE_MEDICAL_CERTIFICATE_SICK_LEAVE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalCertificateSickLeaveModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE = '[ENTITY] Delete all MedicalCertificateSickLeaveModels',
	DELETE_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Delete all MedicalCertificateSickLeaveModels successfully',
	DELETE_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Delete all MedicalCertificateSickLeaveModels failed',

	UPDATE_MEDICAL_CERTIFICATE_SICK_LEAVE = '[ENTITY] Update MedicalCertificateSickLeaveModel',
	UPDATE_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Update MedicalCertificateSickLeaveModel successfully',
	UPDATE_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Update MedicalCertificateSickLeaveModel failed',

	UPDATE_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE = '[ENTITY] Update all MedicalCertificateSickLeaveModel',
	UPDATE_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Update all MedicalCertificateSickLeaveModel successfully',
	UPDATE_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Update all MedicalCertificateSickLeaveModel failed',

	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE= '[ENTITY] Fetch MedicalCertificateSickLeaveModel',
	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Fetch MedicalCertificateSickLeaveModel successfully',
	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Fetch MedicalCertificateSickLeaveModel failed',

	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_AUDIT= '[ENTITY] Fetch MedicalCertificateSickLeaveModel audit',
	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_AUDIT_OK = '[ENTITY] Fetch MedicalCertificateSickLeaveModel audit successfully',
	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_AUDIT_FAIL = '[ENTITY] Fetch MedicalCertificateSickLeaveModel audit failed',

	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalCertificateSickLeaveModel audits by entity id',
	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalCertificateSickLeaveModel audits by entity id successfully',
	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalCertificateSickLeaveModel audits by entity id failed',

	FETCH_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE = '[ENTITY] Fetch all MedicalCertificateSickLeaveModel',
	FETCH_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Fetch all MedicalCertificateSickLeaveModel successfully',
	FETCH_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Fetch all MedicalCertificateSickLeaveModel failed',

	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_WITH_QUERY = '[ENTITY] Fetch MedicalCertificateSickLeaveModel with query',
	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_WITH_QUERY_OK = '[ENTITY] Fetch MedicalCertificateSickLeaveModel with query successfully',
	FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalCertificateSickLeaveModel with query failed',

	FETCH_LAST_MEDICAL_CERTIFICATE_SICK_LEAVE_WITH_QUERY = '[ENTITY] Fetch last MedicalCertificateSickLeaveModel with query',
	FETCH_LAST_MEDICAL_CERTIFICATE_SICK_LEAVE_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalCertificateSickLeaveModel with query successfully',
	FETCH_LAST_MEDICAL_CERTIFICATE_SICK_LEAVE_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalCertificateSickLeaveModel with query failed',

	EXPORT_MEDICAL_CERTIFICATE_SICK_LEAVE = '[ENTITY] Export MedicalCertificateSickLeaveModel',
	EXPORT_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Export MedicalCertificateSickLeaveModel successfully',
	EXPORT_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Export MedicalCertificateSickLeaveModel failed',

	EXPORT_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE = '[ENTITY] Export All MedicalCertificateSickLeaveModels',
	EXPORT_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_OK = '[ENTITY] Export All MedicalCertificateSickLeaveModels successfully',
	EXPORT_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE_FAIL = '[ENTITY] Export All MedicalCertificateSickLeaveModels failed',

	EXPORT_MEDICAL_CERTIFICATE_SICK_LEAVE_EXCLUDING_IDS = '[ENTITY] Export MedicalCertificateSickLeaveModels excluding Ids',
	EXPORT_MEDICAL_CERTIFICATE_SICK_LEAVE_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalCertificateSickLeaveModel excluding Ids successfully',
	EXPORT_MEDICAL_CERTIFICATE_SICK_LEAVE_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalCertificateSickLeaveModel excluding Ids failed',

	COUNT_MEDICAL_CERTIFICATE_SICK_LEAVES = '[ENTITY] Fetch number of MedicalCertificateSickLeaveModel records',
	COUNT_MEDICAL_CERTIFICATE_SICK_LEAVES_OK = '[ENTITY] Fetch number of MedicalCertificateSickLeaveModel records successfully ',
	COUNT_MEDICAL_CERTIFICATE_SICK_LEAVES_FAIL = '[ENTITY] Fetch number of MedicalCertificateSickLeaveModel records failed',

	IMPORT_MEDICAL_CERTIFICATE_SICK_LEAVES = '[ENTITY] Import MedicalCertificateSickLeaveModels',
	IMPORT_MEDICAL_CERTIFICATE_SICK_LEAVES_OK = '[ENTITY] Import MedicalCertificateSickLeaveModels successfully',
	IMPORT_MEDICAL_CERTIFICATE_SICK_LEAVES_FAIL = '[ENTITY] Import MedicalCertificateSickLeaveModels fail',


	INITIALISE_MEDICAL_CERTIFICATE_SICK_LEAVE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalCertificateSickLeaveModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalCertificateSickLeaveAction implements Action {
	readonly className: string = 'MedicalCertificateSickLeaveModel';

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

export class MedicalCertificateSickLeaveAction extends BaseMedicalCertificateSickLeaveAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateSickLeaveAction here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateSickLeaveAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateSickLeaveModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateSickLeaveAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateSickLeaveAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateSickLeaveAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateSickLeaveAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateSickLeaveAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateSickLeaveAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateSickLeaveAction here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateSickLeaveAction here] end
}

export class MedicalCertificateSickLeaveActionOK extends BaseMedicalCertificateSickLeaveAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateSickLeaveActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateSickLeaveActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateSickLeaveModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateSickLeaveActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateSickLeaveActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalCertificateSickLeaveModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateSickLeaveActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateSickLeaveActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateSickLeaveActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateSickLeaveActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateSickLeaveActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateSickLeaveActionOK here] end
}

export class MedicalCertificateSickLeaveActionFail extends BaseMedicalCertificateSickLeaveAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateSickLeaveActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateSickLeaveActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalCertificateSickLeaveModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateSickLeaveActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateSickLeaveActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateSickLeaveActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateSickLeaveActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateSickLeaveActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateSickLeaveActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateSickLeaveActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateSickLeaveActionFail here] end
}

export function isMedicalCertificateSickLeaveModelAction(e: any): e is BaseMedicalCertificateSickLeaveAction {
	return Object.values(MedicalCertificateSickLeaveModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
