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
import {MedicalCertificatePhysicalHealthModel} from './medical_certificate_physical_health.model';
import {MedicalCertificatePhysicalHealthModelAudit} from './medical_certificate_physical_health.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Certificate Physical Health model actions to be dispatched by NgRx.
 */
export enum MedicalCertificatePhysicalHealthModelActionTypes {
	CREATE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH = '[ENTITY] Create MedicalCertificatePhysicalHealthModel',
	CREATE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Create MedicalCertificatePhysicalHealthModel successfully',
	CREATE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Create MedicalCertificatePhysicalHealthModel failed',

	CREATE_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH = '[ENTITY] Create All MedicalCertificatePhysicalHealthModel',
	CREATE_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Create All MedicalCertificatePhysicalHealthModel successfully',
	CREATE_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Create All MedicalCertificatePhysicalHealthModel failed',

	DELETE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH = '[ENTITY] Delete MedicalCertificatePhysicalHealthModel',
	DELETE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Delete MedicalCertificatePhysicalHealthModel successfully',
	DELETE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Delete MedicalCertificatePhysicalHealthModel failed',


	DELETE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_EXCLUDING_IDS = '[ENTITY] Delete MedicalCertificatePhysicalHealthModels Excluding Ids',
	DELETE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalCertificatePhysicalHealthModels Excluding Ids successfully',
	DELETE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalCertificatePhysicalHealthModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH = '[ENTITY] Delete all MedicalCertificatePhysicalHealthModels',
	DELETE_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Delete all MedicalCertificatePhysicalHealthModels successfully',
	DELETE_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Delete all MedicalCertificatePhysicalHealthModels failed',

	UPDATE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH = '[ENTITY] Update MedicalCertificatePhysicalHealthModel',
	UPDATE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Update MedicalCertificatePhysicalHealthModel successfully',
	UPDATE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Update MedicalCertificatePhysicalHealthModel failed',

	UPDATE_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH = '[ENTITY] Update all MedicalCertificatePhysicalHealthModel',
	UPDATE_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Update all MedicalCertificatePhysicalHealthModel successfully',
	UPDATE_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Update all MedicalCertificatePhysicalHealthModel failed',

	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH= '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel',
	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel successfully',
	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel failed',

	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_AUDIT= '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel audit',
	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_AUDIT_OK = '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel audit successfully',
	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_AUDIT_FAIL = '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel audit failed',

	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel audits by entity id',
	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel audits by entity id successfully',
	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel audits by entity id failed',

	FETCH_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH = '[ENTITY] Fetch all MedicalCertificatePhysicalHealthModel',
	FETCH_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Fetch all MedicalCertificatePhysicalHealthModel successfully',
	FETCH_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Fetch all MedicalCertificatePhysicalHealthModel failed',

	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_WITH_QUERY = '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel with query',
	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_WITH_QUERY_OK = '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel with query successfully',
	FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalCertificatePhysicalHealthModel with query failed',

	FETCH_LAST_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_WITH_QUERY = '[ENTITY] Fetch last MedicalCertificatePhysicalHealthModel with query',
	FETCH_LAST_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalCertificatePhysicalHealthModel with query successfully',
	FETCH_LAST_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalCertificatePhysicalHealthModel with query failed',

	EXPORT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH = '[ENTITY] Export MedicalCertificatePhysicalHealthModel',
	EXPORT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Export MedicalCertificatePhysicalHealthModel successfully',
	EXPORT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Export MedicalCertificatePhysicalHealthModel failed',

	EXPORT_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH = '[ENTITY] Export All MedicalCertificatePhysicalHealthModels',
	EXPORT_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_OK = '[ENTITY] Export All MedicalCertificatePhysicalHealthModels successfully',
	EXPORT_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_FAIL = '[ENTITY] Export All MedicalCertificatePhysicalHealthModels failed',

	EXPORT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_EXCLUDING_IDS = '[ENTITY] Export MedicalCertificatePhysicalHealthModels excluding Ids',
	EXPORT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalCertificatePhysicalHealthModel excluding Ids successfully',
	EXPORT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalCertificatePhysicalHealthModel excluding Ids failed',

	COUNT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTHS = '[ENTITY] Fetch number of MedicalCertificatePhysicalHealthModel records',
	COUNT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTHS_OK = '[ENTITY] Fetch number of MedicalCertificatePhysicalHealthModel records successfully ',
	COUNT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTHS_FAIL = '[ENTITY] Fetch number of MedicalCertificatePhysicalHealthModel records failed',

	IMPORT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTHS = '[ENTITY] Import MedicalCertificatePhysicalHealthModels',
	IMPORT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTHS_OK = '[ENTITY] Import MedicalCertificatePhysicalHealthModels successfully',
	IMPORT_MEDICAL_CERTIFICATE_PHYSICAL_HEALTHS_FAIL = '[ENTITY] Import MedicalCertificatePhysicalHealthModels fail',


	INITIALISE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalCertificatePhysicalHealthModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalCertificatePhysicalHealthAction implements Action {
	readonly className: string = 'MedicalCertificatePhysicalHealthModel';

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

export class MedicalCertificatePhysicalHealthAction extends BaseMedicalCertificatePhysicalHealthAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificatePhysicalHealthAction here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificatePhysicalHealthAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificatePhysicalHealthModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificatePhysicalHealthAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificatePhysicalHealthAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificatePhysicalHealthAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificatePhysicalHealthAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificatePhysicalHealthAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificatePhysicalHealthAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificatePhysicalHealthAction here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificatePhysicalHealthAction here] end
}

export class MedicalCertificatePhysicalHealthActionOK extends BaseMedicalCertificatePhysicalHealthAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificatePhysicalHealthActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificatePhysicalHealthActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificatePhysicalHealthModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificatePhysicalHealthActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificatePhysicalHealthActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalCertificatePhysicalHealthModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificatePhysicalHealthActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificatePhysicalHealthActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificatePhysicalHealthActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificatePhysicalHealthActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificatePhysicalHealthActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificatePhysicalHealthActionOK here] end
}

export class MedicalCertificatePhysicalHealthActionFail extends BaseMedicalCertificatePhysicalHealthAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificatePhysicalHealthActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificatePhysicalHealthActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalCertificatePhysicalHealthModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificatePhysicalHealthActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificatePhysicalHealthActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificatePhysicalHealthActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificatePhysicalHealthActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificatePhysicalHealthActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificatePhysicalHealthActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificatePhysicalHealthActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificatePhysicalHealthActionFail here] end
}

export function isMedicalCertificatePhysicalHealthModelAction(e: any): e is BaseMedicalCertificatePhysicalHealthAction {
	return Object.values(MedicalCertificatePhysicalHealthModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
