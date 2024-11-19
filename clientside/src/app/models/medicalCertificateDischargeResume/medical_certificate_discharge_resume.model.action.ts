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
import {MedicalCertificateDischargeResumeModel} from './medical_certificate_discharge_resume.model';
import {MedicalCertificateDischargeResumeModelAudit} from './medical_certificate_discharge_resume.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Certificate  Discharge Resume model actions to be dispatched by NgRx.
 */
export enum MedicalCertificateDischargeResumeModelActionTypes {
	CREATE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME = '[ENTITY] Create MedicalCertificateDischargeResumeModel',
	CREATE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Create MedicalCertificateDischargeResumeModel successfully',
	CREATE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Create MedicalCertificateDischargeResumeModel failed',

	CREATE_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME = '[ENTITY] Create All MedicalCertificateDischargeResumeModel',
	CREATE_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Create All MedicalCertificateDischargeResumeModel successfully',
	CREATE_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Create All MedicalCertificateDischargeResumeModel failed',

	DELETE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME = '[ENTITY] Delete MedicalCertificateDischargeResumeModel',
	DELETE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Delete MedicalCertificateDischargeResumeModel successfully',
	DELETE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Delete MedicalCertificateDischargeResumeModel failed',


	DELETE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_EXCLUDING_IDS = '[ENTITY] Delete MedicalCertificateDischargeResumeModels Excluding Ids',
	DELETE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalCertificateDischargeResumeModels Excluding Ids successfully',
	DELETE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalCertificateDischargeResumeModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME = '[ENTITY] Delete all MedicalCertificateDischargeResumeModels',
	DELETE_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Delete all MedicalCertificateDischargeResumeModels successfully',
	DELETE_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Delete all MedicalCertificateDischargeResumeModels failed',

	UPDATE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME = '[ENTITY] Update MedicalCertificateDischargeResumeModel',
	UPDATE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Update MedicalCertificateDischargeResumeModel successfully',
	UPDATE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Update MedicalCertificateDischargeResumeModel failed',

	UPDATE_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME = '[ENTITY] Update all MedicalCertificateDischargeResumeModel',
	UPDATE_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Update all MedicalCertificateDischargeResumeModel successfully',
	UPDATE_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Update all MedicalCertificateDischargeResumeModel failed',

	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME= '[ENTITY] Fetch MedicalCertificateDischargeResumeModel',
	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Fetch MedicalCertificateDischargeResumeModel successfully',
	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Fetch MedicalCertificateDischargeResumeModel failed',

	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_AUDIT= '[ENTITY] Fetch MedicalCertificateDischargeResumeModel audit',
	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_AUDIT_OK = '[ENTITY] Fetch MedicalCertificateDischargeResumeModel audit successfully',
	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_AUDIT_FAIL = '[ENTITY] Fetch MedicalCertificateDischargeResumeModel audit failed',

	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalCertificateDischargeResumeModel audits by entity id',
	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalCertificateDischargeResumeModel audits by entity id successfully',
	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalCertificateDischargeResumeModel audits by entity id failed',

	FETCH_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME = '[ENTITY] Fetch all MedicalCertificateDischargeResumeModel',
	FETCH_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Fetch all MedicalCertificateDischargeResumeModel successfully',
	FETCH_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Fetch all MedicalCertificateDischargeResumeModel failed',

	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_WITH_QUERY = '[ENTITY] Fetch MedicalCertificateDischargeResumeModel with query',
	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_WITH_QUERY_OK = '[ENTITY] Fetch MedicalCertificateDischargeResumeModel with query successfully',
	FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalCertificateDischargeResumeModel with query failed',

	FETCH_LAST_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_WITH_QUERY = '[ENTITY] Fetch last MedicalCertificateDischargeResumeModel with query',
	FETCH_LAST_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalCertificateDischargeResumeModel with query successfully',
	FETCH_LAST_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalCertificateDischargeResumeModel with query failed',

	EXPORT_MEDICAL_CERTIFICATE_DISCHARGE_RESUME = '[ENTITY] Export MedicalCertificateDischargeResumeModel',
	EXPORT_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Export MedicalCertificateDischargeResumeModel successfully',
	EXPORT_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Export MedicalCertificateDischargeResumeModel failed',

	EXPORT_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME = '[ENTITY] Export All MedicalCertificateDischargeResumeModels',
	EXPORT_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_OK = '[ENTITY] Export All MedicalCertificateDischargeResumeModels successfully',
	EXPORT_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_FAIL = '[ENTITY] Export All MedicalCertificateDischargeResumeModels failed',

	EXPORT_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_EXCLUDING_IDS = '[ENTITY] Export MedicalCertificateDischargeResumeModels excluding Ids',
	EXPORT_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalCertificateDischargeResumeModel excluding Ids successfully',
	EXPORT_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalCertificateDischargeResumeModel excluding Ids failed',

	COUNT_MEDICAL_CERTIFICATE_DISCHARGE_RESUMES = '[ENTITY] Fetch number of MedicalCertificateDischargeResumeModel records',
	COUNT_MEDICAL_CERTIFICATE_DISCHARGE_RESUMES_OK = '[ENTITY] Fetch number of MedicalCertificateDischargeResumeModel records successfully ',
	COUNT_MEDICAL_CERTIFICATE_DISCHARGE_RESUMES_FAIL = '[ENTITY] Fetch number of MedicalCertificateDischargeResumeModel records failed',

	IMPORT_MEDICAL_CERTIFICATE_DISCHARGE_RESUMES = '[ENTITY] Import MedicalCertificateDischargeResumeModels',
	IMPORT_MEDICAL_CERTIFICATE_DISCHARGE_RESUMES_OK = '[ENTITY] Import MedicalCertificateDischargeResumeModels successfully',
	IMPORT_MEDICAL_CERTIFICATE_DISCHARGE_RESUMES_FAIL = '[ENTITY] Import MedicalCertificateDischargeResumeModels fail',


	INITIALISE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalCertificateDischargeResumeModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalCertificateDischargeResumeAction implements Action {
	readonly className: string = 'MedicalCertificateDischargeResumeModel';

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

export class MedicalCertificateDischargeResumeAction extends BaseMedicalCertificateDischargeResumeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateDischargeResumeAction here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateDischargeResumeAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateDischargeResumeModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateDischargeResumeAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateDischargeResumeAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateDischargeResumeAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateDischargeResumeAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateDischargeResumeAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateDischargeResumeAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateDischargeResumeAction here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateDischargeResumeAction here] end
}

export class MedicalCertificateDischargeResumeActionOK extends BaseMedicalCertificateDischargeResumeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateDischargeResumeActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateDischargeResumeActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateDischargeResumeModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateDischargeResumeActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateDischargeResumeActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalCertificateDischargeResumeModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateDischargeResumeActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateDischargeResumeActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateDischargeResumeActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateDischargeResumeActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateDischargeResumeActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateDischargeResumeActionOK here] end
}

export class MedicalCertificateDischargeResumeActionFail extends BaseMedicalCertificateDischargeResumeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateDischargeResumeActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateDischargeResumeActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalCertificateDischargeResumeModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateDischargeResumeActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateDischargeResumeActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateDischargeResumeActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateDischargeResumeActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateDischargeResumeActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateDischargeResumeActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateDischargeResumeActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateDischargeResumeActionFail here] end
}

export function isMedicalCertificateDischargeResumeModelAction(e: any): e is BaseMedicalCertificateDischargeResumeAction {
	return Object.values(MedicalCertificateDischargeResumeModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
