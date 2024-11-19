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
import {MedicalCertificateRestrictedWorkModel} from './medical_certificate_restricted_work.model';
import {MedicalCertificateRestrictedWorkModelAudit} from './medical_certificate_restricted_work.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Certificate Restricted Work model actions to be dispatched by NgRx.
 */
export enum MedicalCertificateRestrictedWorkModelActionTypes {
	CREATE_MEDICAL_CERTIFICATE_RESTRICTED_WORK = '[ENTITY] Create MedicalCertificateRestrictedWorkModel',
	CREATE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Create MedicalCertificateRestrictedWorkModel successfully',
	CREATE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Create MedicalCertificateRestrictedWorkModel failed',

	CREATE_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK = '[ENTITY] Create All MedicalCertificateRestrictedWorkModel',
	CREATE_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Create All MedicalCertificateRestrictedWorkModel successfully',
	CREATE_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Create All MedicalCertificateRestrictedWorkModel failed',

	DELETE_MEDICAL_CERTIFICATE_RESTRICTED_WORK = '[ENTITY] Delete MedicalCertificateRestrictedWorkModel',
	DELETE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Delete MedicalCertificateRestrictedWorkModel successfully',
	DELETE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Delete MedicalCertificateRestrictedWorkModel failed',


	DELETE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_EXCLUDING_IDS = '[ENTITY] Delete MedicalCertificateRestrictedWorkModels Excluding Ids',
	DELETE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalCertificateRestrictedWorkModels Excluding Ids successfully',
	DELETE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalCertificateRestrictedWorkModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK = '[ENTITY] Delete all MedicalCertificateRestrictedWorkModels',
	DELETE_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Delete all MedicalCertificateRestrictedWorkModels successfully',
	DELETE_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Delete all MedicalCertificateRestrictedWorkModels failed',

	UPDATE_MEDICAL_CERTIFICATE_RESTRICTED_WORK = '[ENTITY] Update MedicalCertificateRestrictedWorkModel',
	UPDATE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Update MedicalCertificateRestrictedWorkModel successfully',
	UPDATE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Update MedicalCertificateRestrictedWorkModel failed',

	UPDATE_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK = '[ENTITY] Update all MedicalCertificateRestrictedWorkModel',
	UPDATE_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Update all MedicalCertificateRestrictedWorkModel successfully',
	UPDATE_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Update all MedicalCertificateRestrictedWorkModel failed',

	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK= '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel',
	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel successfully',
	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel failed',

	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_AUDIT= '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel audit',
	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_AUDIT_OK = '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel audit successfully',
	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_AUDIT_FAIL = '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel audit failed',

	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel audits by entity id',
	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel audits by entity id successfully',
	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel audits by entity id failed',

	FETCH_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK = '[ENTITY] Fetch all MedicalCertificateRestrictedWorkModel',
	FETCH_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Fetch all MedicalCertificateRestrictedWorkModel successfully',
	FETCH_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Fetch all MedicalCertificateRestrictedWorkModel failed',

	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_WITH_QUERY = '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel with query',
	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_WITH_QUERY_OK = '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel with query successfully',
	FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalCertificateRestrictedWorkModel with query failed',

	FETCH_LAST_MEDICAL_CERTIFICATE_RESTRICTED_WORK_WITH_QUERY = '[ENTITY] Fetch last MedicalCertificateRestrictedWorkModel with query',
	FETCH_LAST_MEDICAL_CERTIFICATE_RESTRICTED_WORK_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalCertificateRestrictedWorkModel with query successfully',
	FETCH_LAST_MEDICAL_CERTIFICATE_RESTRICTED_WORK_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalCertificateRestrictedWorkModel with query failed',

	EXPORT_MEDICAL_CERTIFICATE_RESTRICTED_WORK = '[ENTITY] Export MedicalCertificateRestrictedWorkModel',
	EXPORT_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Export MedicalCertificateRestrictedWorkModel successfully',
	EXPORT_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Export MedicalCertificateRestrictedWorkModel failed',

	EXPORT_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK = '[ENTITY] Export All MedicalCertificateRestrictedWorkModels',
	EXPORT_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_OK = '[ENTITY] Export All MedicalCertificateRestrictedWorkModels successfully',
	EXPORT_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK_FAIL = '[ENTITY] Export All MedicalCertificateRestrictedWorkModels failed',

	EXPORT_MEDICAL_CERTIFICATE_RESTRICTED_WORK_EXCLUDING_IDS = '[ENTITY] Export MedicalCertificateRestrictedWorkModels excluding Ids',
	EXPORT_MEDICAL_CERTIFICATE_RESTRICTED_WORK_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalCertificateRestrictedWorkModel excluding Ids successfully',
	EXPORT_MEDICAL_CERTIFICATE_RESTRICTED_WORK_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalCertificateRestrictedWorkModel excluding Ids failed',

	COUNT_MEDICAL_CERTIFICATE_RESTRICTED_WORKS = '[ENTITY] Fetch number of MedicalCertificateRestrictedWorkModel records',
	COUNT_MEDICAL_CERTIFICATE_RESTRICTED_WORKS_OK = '[ENTITY] Fetch number of MedicalCertificateRestrictedWorkModel records successfully ',
	COUNT_MEDICAL_CERTIFICATE_RESTRICTED_WORKS_FAIL = '[ENTITY] Fetch number of MedicalCertificateRestrictedWorkModel records failed',

	IMPORT_MEDICAL_CERTIFICATE_RESTRICTED_WORKS = '[ENTITY] Import MedicalCertificateRestrictedWorkModels',
	IMPORT_MEDICAL_CERTIFICATE_RESTRICTED_WORKS_OK = '[ENTITY] Import MedicalCertificateRestrictedWorkModels successfully',
	IMPORT_MEDICAL_CERTIFICATE_RESTRICTED_WORKS_FAIL = '[ENTITY] Import MedicalCertificateRestrictedWorkModels fail',


	INITIALISE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalCertificateRestrictedWorkModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalCertificateRestrictedWorkAction implements Action {
	readonly className: string = 'MedicalCertificateRestrictedWorkModel';

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

export class MedicalCertificateRestrictedWorkAction extends BaseMedicalCertificateRestrictedWorkAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateRestrictedWorkAction here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateRestrictedWorkAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateRestrictedWorkModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateRestrictedWorkAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateRestrictedWorkAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateRestrictedWorkAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateRestrictedWorkAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateRestrictedWorkAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateRestrictedWorkAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateRestrictedWorkAction here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateRestrictedWorkAction here] end
}

export class MedicalCertificateRestrictedWorkActionOK extends BaseMedicalCertificateRestrictedWorkAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateRestrictedWorkActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateRestrictedWorkActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateRestrictedWorkModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateRestrictedWorkActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateRestrictedWorkActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalCertificateRestrictedWorkModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateRestrictedWorkActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateRestrictedWorkActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateRestrictedWorkActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateRestrictedWorkActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateRestrictedWorkActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateRestrictedWorkActionOK here] end
}

export class MedicalCertificateRestrictedWorkActionFail extends BaseMedicalCertificateRestrictedWorkAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateRestrictedWorkActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateRestrictedWorkActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalCertificateRestrictedWorkModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateRestrictedWorkActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateRestrictedWorkActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateRestrictedWorkActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateRestrictedWorkActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateRestrictedWorkActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateRestrictedWorkActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateRestrictedWorkActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateRestrictedWorkActionFail here] end
}

export function isMedicalCertificateRestrictedWorkModelAction(e: any): e is BaseMedicalCertificateRestrictedWorkAction {
	return Object.values(MedicalCertificateRestrictedWorkModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
