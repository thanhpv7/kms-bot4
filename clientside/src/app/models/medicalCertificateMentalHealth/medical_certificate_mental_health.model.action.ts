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
import {MedicalCertificateMentalHealthModel} from './medical_certificate_mental_health.model';
import {MedicalCertificateMentalHealthModelAudit} from './medical_certificate_mental_health.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Certificate Mental Health model actions to be dispatched by NgRx.
 */
export enum MedicalCertificateMentalHealthModelActionTypes {
	CREATE_MEDICAL_CERTIFICATE_MENTAL_HEALTH = '[ENTITY] Create MedicalCertificateMentalHealthModel',
	CREATE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Create MedicalCertificateMentalHealthModel successfully',
	CREATE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Create MedicalCertificateMentalHealthModel failed',

	CREATE_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH = '[ENTITY] Create All MedicalCertificateMentalHealthModel',
	CREATE_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Create All MedicalCertificateMentalHealthModel successfully',
	CREATE_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Create All MedicalCertificateMentalHealthModel failed',

	DELETE_MEDICAL_CERTIFICATE_MENTAL_HEALTH = '[ENTITY] Delete MedicalCertificateMentalHealthModel',
	DELETE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Delete MedicalCertificateMentalHealthModel successfully',
	DELETE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Delete MedicalCertificateMentalHealthModel failed',


	DELETE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_EXCLUDING_IDS = '[ENTITY] Delete MedicalCertificateMentalHealthModels Excluding Ids',
	DELETE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalCertificateMentalHealthModels Excluding Ids successfully',
	DELETE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalCertificateMentalHealthModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH = '[ENTITY] Delete all MedicalCertificateMentalHealthModels',
	DELETE_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Delete all MedicalCertificateMentalHealthModels successfully',
	DELETE_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Delete all MedicalCertificateMentalHealthModels failed',

	UPDATE_MEDICAL_CERTIFICATE_MENTAL_HEALTH = '[ENTITY] Update MedicalCertificateMentalHealthModel',
	UPDATE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Update MedicalCertificateMentalHealthModel successfully',
	UPDATE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Update MedicalCertificateMentalHealthModel failed',

	UPDATE_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH = '[ENTITY] Update all MedicalCertificateMentalHealthModel',
	UPDATE_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Update all MedicalCertificateMentalHealthModel successfully',
	UPDATE_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Update all MedicalCertificateMentalHealthModel failed',

	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH= '[ENTITY] Fetch MedicalCertificateMentalHealthModel',
	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Fetch MedicalCertificateMentalHealthModel successfully',
	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Fetch MedicalCertificateMentalHealthModel failed',

	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_AUDIT= '[ENTITY] Fetch MedicalCertificateMentalHealthModel audit',
	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_AUDIT_OK = '[ENTITY] Fetch MedicalCertificateMentalHealthModel audit successfully',
	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_AUDIT_FAIL = '[ENTITY] Fetch MedicalCertificateMentalHealthModel audit failed',

	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalCertificateMentalHealthModel audits by entity id',
	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalCertificateMentalHealthModel audits by entity id successfully',
	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalCertificateMentalHealthModel audits by entity id failed',

	FETCH_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH = '[ENTITY] Fetch all MedicalCertificateMentalHealthModel',
	FETCH_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Fetch all MedicalCertificateMentalHealthModel successfully',
	FETCH_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Fetch all MedicalCertificateMentalHealthModel failed',

	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_WITH_QUERY = '[ENTITY] Fetch MedicalCertificateMentalHealthModel with query',
	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_WITH_QUERY_OK = '[ENTITY] Fetch MedicalCertificateMentalHealthModel with query successfully',
	FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalCertificateMentalHealthModel with query failed',

	FETCH_LAST_MEDICAL_CERTIFICATE_MENTAL_HEALTH_WITH_QUERY = '[ENTITY] Fetch last MedicalCertificateMentalHealthModel with query',
	FETCH_LAST_MEDICAL_CERTIFICATE_MENTAL_HEALTH_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalCertificateMentalHealthModel with query successfully',
	FETCH_LAST_MEDICAL_CERTIFICATE_MENTAL_HEALTH_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalCertificateMentalHealthModel with query failed',

	EXPORT_MEDICAL_CERTIFICATE_MENTAL_HEALTH = '[ENTITY] Export MedicalCertificateMentalHealthModel',
	EXPORT_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Export MedicalCertificateMentalHealthModel successfully',
	EXPORT_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Export MedicalCertificateMentalHealthModel failed',

	EXPORT_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH = '[ENTITY] Export All MedicalCertificateMentalHealthModels',
	EXPORT_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_OK = '[ENTITY] Export All MedicalCertificateMentalHealthModels successfully',
	EXPORT_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH_FAIL = '[ENTITY] Export All MedicalCertificateMentalHealthModels failed',

	EXPORT_MEDICAL_CERTIFICATE_MENTAL_HEALTH_EXCLUDING_IDS = '[ENTITY] Export MedicalCertificateMentalHealthModels excluding Ids',
	EXPORT_MEDICAL_CERTIFICATE_MENTAL_HEALTH_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalCertificateMentalHealthModel excluding Ids successfully',
	EXPORT_MEDICAL_CERTIFICATE_MENTAL_HEALTH_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalCertificateMentalHealthModel excluding Ids failed',

	COUNT_MEDICAL_CERTIFICATE_MENTAL_HEALTHS = '[ENTITY] Fetch number of MedicalCertificateMentalHealthModel records',
	COUNT_MEDICAL_CERTIFICATE_MENTAL_HEALTHS_OK = '[ENTITY] Fetch number of MedicalCertificateMentalHealthModel records successfully ',
	COUNT_MEDICAL_CERTIFICATE_MENTAL_HEALTHS_FAIL = '[ENTITY] Fetch number of MedicalCertificateMentalHealthModel records failed',

	IMPORT_MEDICAL_CERTIFICATE_MENTAL_HEALTHS = '[ENTITY] Import MedicalCertificateMentalHealthModels',
	IMPORT_MEDICAL_CERTIFICATE_MENTAL_HEALTHS_OK = '[ENTITY] Import MedicalCertificateMentalHealthModels successfully',
	IMPORT_MEDICAL_CERTIFICATE_MENTAL_HEALTHS_FAIL = '[ENTITY] Import MedicalCertificateMentalHealthModels fail',


	INITIALISE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalCertificateMentalHealthModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalCertificateMentalHealthAction implements Action {
	readonly className: string = 'MedicalCertificateMentalHealthModel';

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

export class MedicalCertificateMentalHealthAction extends BaseMedicalCertificateMentalHealthAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateMentalHealthAction here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateMentalHealthAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateMentalHealthModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMentalHealthAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMentalHealthAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMentalHealthAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMentalHealthAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateMentalHealthAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateMentalHealthAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateMentalHealthAction here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateMentalHealthAction here] end
}

export class MedicalCertificateMentalHealthActionOK extends BaseMedicalCertificateMentalHealthAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateMentalHealthActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateMentalHealthActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateMentalHealthModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMentalHealthActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMentalHealthActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalCertificateMentalHealthModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMentalHealthActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMentalHealthActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateMentalHealthActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateMentalHealthActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateMentalHealthActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateMentalHealthActionOK here] end
}

export class MedicalCertificateMentalHealthActionFail extends BaseMedicalCertificateMentalHealthAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateMentalHealthActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateMentalHealthActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalCertificateMentalHealthModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMentalHealthActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateMentalHealthActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMentalHealthActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateMentalHealthActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateMentalHealthActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateMentalHealthActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateMentalHealthActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateMentalHealthActionFail here] end
}

export function isMedicalCertificateMentalHealthModelAction(e: any): e is BaseMedicalCertificateMentalHealthAction {
	return Object.values(MedicalCertificateMentalHealthModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
