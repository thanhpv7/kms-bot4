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
import {MedicalCertificateHospitalizationModel} from './medical_certificate_hospitalization.model';
import {MedicalCertificateHospitalizationModelAudit} from './medical_certificate_hospitalization.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Certificate Hospitalization model actions to be dispatched by NgRx.
 */
export enum MedicalCertificateHospitalizationModelActionTypes {
	CREATE_MEDICAL_CERTIFICATE_HOSPITALIZATION = '[ENTITY] Create MedicalCertificateHospitalizationModel',
	CREATE_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Create MedicalCertificateHospitalizationModel successfully',
	CREATE_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Create MedicalCertificateHospitalizationModel failed',

	CREATE_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION = '[ENTITY] Create All MedicalCertificateHospitalizationModel',
	CREATE_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Create All MedicalCertificateHospitalizationModel successfully',
	CREATE_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Create All MedicalCertificateHospitalizationModel failed',

	DELETE_MEDICAL_CERTIFICATE_HOSPITALIZATION = '[ENTITY] Delete MedicalCertificateHospitalizationModel',
	DELETE_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Delete MedicalCertificateHospitalizationModel successfully',
	DELETE_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Delete MedicalCertificateHospitalizationModel failed',


	DELETE_MEDICAL_CERTIFICATE_HOSPITALIZATION_EXCLUDING_IDS = '[ENTITY] Delete MedicalCertificateHospitalizationModels Excluding Ids',
	DELETE_MEDICAL_CERTIFICATE_HOSPITALIZATION_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalCertificateHospitalizationModels Excluding Ids successfully',
	DELETE_MEDICAL_CERTIFICATE_HOSPITALIZATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalCertificateHospitalizationModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION = '[ENTITY] Delete all MedicalCertificateHospitalizationModels',
	DELETE_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Delete all MedicalCertificateHospitalizationModels successfully',
	DELETE_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Delete all MedicalCertificateHospitalizationModels failed',

	UPDATE_MEDICAL_CERTIFICATE_HOSPITALIZATION = '[ENTITY] Update MedicalCertificateHospitalizationModel',
	UPDATE_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Update MedicalCertificateHospitalizationModel successfully',
	UPDATE_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Update MedicalCertificateHospitalizationModel failed',

	UPDATE_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION = '[ENTITY] Update all MedicalCertificateHospitalizationModel',
	UPDATE_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Update all MedicalCertificateHospitalizationModel successfully',
	UPDATE_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Update all MedicalCertificateHospitalizationModel failed',

	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION= '[ENTITY] Fetch MedicalCertificateHospitalizationModel',
	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Fetch MedicalCertificateHospitalizationModel successfully',
	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Fetch MedicalCertificateHospitalizationModel failed',

	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_AUDIT= '[ENTITY] Fetch MedicalCertificateHospitalizationModel audit',
	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_AUDIT_OK = '[ENTITY] Fetch MedicalCertificateHospitalizationModel audit successfully',
	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_AUDIT_FAIL = '[ENTITY] Fetch MedicalCertificateHospitalizationModel audit failed',

	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalCertificateHospitalizationModel audits by entity id',
	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalCertificateHospitalizationModel audits by entity id successfully',
	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalCertificateHospitalizationModel audits by entity id failed',

	FETCH_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION = '[ENTITY] Fetch all MedicalCertificateHospitalizationModel',
	FETCH_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Fetch all MedicalCertificateHospitalizationModel successfully',
	FETCH_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Fetch all MedicalCertificateHospitalizationModel failed',

	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_WITH_QUERY = '[ENTITY] Fetch MedicalCertificateHospitalizationModel with query',
	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_WITH_QUERY_OK = '[ENTITY] Fetch MedicalCertificateHospitalizationModel with query successfully',
	FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalCertificateHospitalizationModel with query failed',

	FETCH_LAST_MEDICAL_CERTIFICATE_HOSPITALIZATION_WITH_QUERY = '[ENTITY] Fetch last MedicalCertificateHospitalizationModel with query',
	FETCH_LAST_MEDICAL_CERTIFICATE_HOSPITALIZATION_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalCertificateHospitalizationModel with query successfully',
	FETCH_LAST_MEDICAL_CERTIFICATE_HOSPITALIZATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalCertificateHospitalizationModel with query failed',

	EXPORT_MEDICAL_CERTIFICATE_HOSPITALIZATION = '[ENTITY] Export MedicalCertificateHospitalizationModel',
	EXPORT_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Export MedicalCertificateHospitalizationModel successfully',
	EXPORT_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Export MedicalCertificateHospitalizationModel failed',

	EXPORT_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION = '[ENTITY] Export All MedicalCertificateHospitalizationModels',
	EXPORT_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_OK = '[ENTITY] Export All MedicalCertificateHospitalizationModels successfully',
	EXPORT_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION_FAIL = '[ENTITY] Export All MedicalCertificateHospitalizationModels failed',

	EXPORT_MEDICAL_CERTIFICATE_HOSPITALIZATION_EXCLUDING_IDS = '[ENTITY] Export MedicalCertificateHospitalizationModels excluding Ids',
	EXPORT_MEDICAL_CERTIFICATE_HOSPITALIZATION_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalCertificateHospitalizationModel excluding Ids successfully',
	EXPORT_MEDICAL_CERTIFICATE_HOSPITALIZATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalCertificateHospitalizationModel excluding Ids failed',

	COUNT_MEDICAL_CERTIFICATE_HOSPITALIZATIONS = '[ENTITY] Fetch number of MedicalCertificateHospitalizationModel records',
	COUNT_MEDICAL_CERTIFICATE_HOSPITALIZATIONS_OK = '[ENTITY] Fetch number of MedicalCertificateHospitalizationModel records successfully ',
	COUNT_MEDICAL_CERTIFICATE_HOSPITALIZATIONS_FAIL = '[ENTITY] Fetch number of MedicalCertificateHospitalizationModel records failed',

	IMPORT_MEDICAL_CERTIFICATE_HOSPITALIZATIONS = '[ENTITY] Import MedicalCertificateHospitalizationModels',
	IMPORT_MEDICAL_CERTIFICATE_HOSPITALIZATIONS_OK = '[ENTITY] Import MedicalCertificateHospitalizationModels successfully',
	IMPORT_MEDICAL_CERTIFICATE_HOSPITALIZATIONS_FAIL = '[ENTITY] Import MedicalCertificateHospitalizationModels fail',


	INITIALISE_MEDICAL_CERTIFICATE_HOSPITALIZATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalCertificateHospitalizationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalCertificateHospitalizationAction implements Action {
	readonly className: string = 'MedicalCertificateHospitalizationModel';

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

export class MedicalCertificateHospitalizationAction extends BaseMedicalCertificateHospitalizationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateHospitalizationAction here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateHospitalizationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateHospitalizationModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateHospitalizationAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateHospitalizationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateHospitalizationAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateHospitalizationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateHospitalizationAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateHospitalizationAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateHospitalizationAction here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateHospitalizationAction here] end
}

export class MedicalCertificateHospitalizationActionOK extends BaseMedicalCertificateHospitalizationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateHospitalizationActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateHospitalizationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateHospitalizationModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateHospitalizationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateHospitalizationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalCertificateHospitalizationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateHospitalizationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateHospitalizationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateHospitalizationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateHospitalizationActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateHospitalizationActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateHospitalizationActionOK here] end
}

export class MedicalCertificateHospitalizationActionFail extends BaseMedicalCertificateHospitalizationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateHospitalizationActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateHospitalizationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalCertificateHospitalizationModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateHospitalizationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateHospitalizationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateHospitalizationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateHospitalizationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateHospitalizationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateHospitalizationActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateHospitalizationActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateHospitalizationActionFail here] end
}

export function isMedicalCertificateHospitalizationModelAction(e: any): e is BaseMedicalCertificateHospitalizationAction {
	return Object.values(MedicalCertificateHospitalizationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
