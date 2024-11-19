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
import {MedicalCertificateBirthModel} from './medical_certificate_birth.model';
import {MedicalCertificateBirthModelAudit} from './medical_certificate_birth.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Certificate Birth model actions to be dispatched by NgRx.
 */
export enum MedicalCertificateBirthModelActionTypes {
	CREATE_MEDICAL_CERTIFICATE_BIRTH = '[ENTITY] Create MedicalCertificateBirthModel',
	CREATE_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Create MedicalCertificateBirthModel successfully',
	CREATE_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Create MedicalCertificateBirthModel failed',

	CREATE_ALL_MEDICAL_CERTIFICATE_BIRTH = '[ENTITY] Create All MedicalCertificateBirthModel',
	CREATE_ALL_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Create All MedicalCertificateBirthModel successfully',
	CREATE_ALL_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Create All MedicalCertificateBirthModel failed',

	DELETE_MEDICAL_CERTIFICATE_BIRTH = '[ENTITY] Delete MedicalCertificateBirthModel',
	DELETE_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Delete MedicalCertificateBirthModel successfully',
	DELETE_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Delete MedicalCertificateBirthModel failed',


	DELETE_MEDICAL_CERTIFICATE_BIRTH_EXCLUDING_IDS = '[ENTITY] Delete MedicalCertificateBirthModels Excluding Ids',
	DELETE_MEDICAL_CERTIFICATE_BIRTH_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalCertificateBirthModels Excluding Ids successfully',
	DELETE_MEDICAL_CERTIFICATE_BIRTH_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalCertificateBirthModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_CERTIFICATE_BIRTH = '[ENTITY] Delete all MedicalCertificateBirthModels',
	DELETE_ALL_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Delete all MedicalCertificateBirthModels successfully',
	DELETE_ALL_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Delete all MedicalCertificateBirthModels failed',

	UPDATE_MEDICAL_CERTIFICATE_BIRTH = '[ENTITY] Update MedicalCertificateBirthModel',
	UPDATE_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Update MedicalCertificateBirthModel successfully',
	UPDATE_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Update MedicalCertificateBirthModel failed',

	UPDATE_ALL_MEDICAL_CERTIFICATE_BIRTH = '[ENTITY] Update all MedicalCertificateBirthModel',
	UPDATE_ALL_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Update all MedicalCertificateBirthModel successfully',
	UPDATE_ALL_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Update all MedicalCertificateBirthModel failed',

	FETCH_MEDICAL_CERTIFICATE_BIRTH= '[ENTITY] Fetch MedicalCertificateBirthModel',
	FETCH_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Fetch MedicalCertificateBirthModel successfully',
	FETCH_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Fetch MedicalCertificateBirthModel failed',

	FETCH_MEDICAL_CERTIFICATE_BIRTH_AUDIT= '[ENTITY] Fetch MedicalCertificateBirthModel audit',
	FETCH_MEDICAL_CERTIFICATE_BIRTH_AUDIT_OK = '[ENTITY] Fetch MedicalCertificateBirthModel audit successfully',
	FETCH_MEDICAL_CERTIFICATE_BIRTH_AUDIT_FAIL = '[ENTITY] Fetch MedicalCertificateBirthModel audit failed',

	FETCH_MEDICAL_CERTIFICATE_BIRTH_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalCertificateBirthModel audits by entity id',
	FETCH_MEDICAL_CERTIFICATE_BIRTH_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalCertificateBirthModel audits by entity id successfully',
	FETCH_MEDICAL_CERTIFICATE_BIRTH_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalCertificateBirthModel audits by entity id failed',

	FETCH_ALL_MEDICAL_CERTIFICATE_BIRTH = '[ENTITY] Fetch all MedicalCertificateBirthModel',
	FETCH_ALL_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Fetch all MedicalCertificateBirthModel successfully',
	FETCH_ALL_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Fetch all MedicalCertificateBirthModel failed',

	FETCH_MEDICAL_CERTIFICATE_BIRTH_WITH_QUERY = '[ENTITY] Fetch MedicalCertificateBirthModel with query',
	FETCH_MEDICAL_CERTIFICATE_BIRTH_WITH_QUERY_OK = '[ENTITY] Fetch MedicalCertificateBirthModel with query successfully',
	FETCH_MEDICAL_CERTIFICATE_BIRTH_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalCertificateBirthModel with query failed',

	FETCH_LAST_MEDICAL_CERTIFICATE_BIRTH_WITH_QUERY = '[ENTITY] Fetch last MedicalCertificateBirthModel with query',
	FETCH_LAST_MEDICAL_CERTIFICATE_BIRTH_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalCertificateBirthModel with query successfully',
	FETCH_LAST_MEDICAL_CERTIFICATE_BIRTH_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalCertificateBirthModel with query failed',

	EXPORT_MEDICAL_CERTIFICATE_BIRTH = '[ENTITY] Export MedicalCertificateBirthModel',
	EXPORT_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Export MedicalCertificateBirthModel successfully',
	EXPORT_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Export MedicalCertificateBirthModel failed',

	EXPORT_ALL_MEDICAL_CERTIFICATE_BIRTH = '[ENTITY] Export All MedicalCertificateBirthModels',
	EXPORT_ALL_MEDICAL_CERTIFICATE_BIRTH_OK = '[ENTITY] Export All MedicalCertificateBirthModels successfully',
	EXPORT_ALL_MEDICAL_CERTIFICATE_BIRTH_FAIL = '[ENTITY] Export All MedicalCertificateBirthModels failed',

	EXPORT_MEDICAL_CERTIFICATE_BIRTH_EXCLUDING_IDS = '[ENTITY] Export MedicalCertificateBirthModels excluding Ids',
	EXPORT_MEDICAL_CERTIFICATE_BIRTH_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalCertificateBirthModel excluding Ids successfully',
	EXPORT_MEDICAL_CERTIFICATE_BIRTH_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalCertificateBirthModel excluding Ids failed',

	COUNT_MEDICAL_CERTIFICATE_BIRTHS = '[ENTITY] Fetch number of MedicalCertificateBirthModel records',
	COUNT_MEDICAL_CERTIFICATE_BIRTHS_OK = '[ENTITY] Fetch number of MedicalCertificateBirthModel records successfully ',
	COUNT_MEDICAL_CERTIFICATE_BIRTHS_FAIL = '[ENTITY] Fetch number of MedicalCertificateBirthModel records failed',

	IMPORT_MEDICAL_CERTIFICATE_BIRTHS = '[ENTITY] Import MedicalCertificateBirthModels',
	IMPORT_MEDICAL_CERTIFICATE_BIRTHS_OK = '[ENTITY] Import MedicalCertificateBirthModels successfully',
	IMPORT_MEDICAL_CERTIFICATE_BIRTHS_FAIL = '[ENTITY] Import MedicalCertificateBirthModels fail',


	INITIALISE_MEDICAL_CERTIFICATE_BIRTH_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalCertificateBirthModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalCertificateBirthAction implements Action {
	readonly className: string = 'MedicalCertificateBirthModel';

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

export class MedicalCertificateBirthAction extends BaseMedicalCertificateBirthAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateBirthAction here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateBirthAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateBirthModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateBirthAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateBirthAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateBirthAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateBirthAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateBirthAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateBirthAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateBirthAction here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateBirthAction here] end
}

export class MedicalCertificateBirthActionOK extends BaseMedicalCertificateBirthAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateBirthActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateBirthActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalCertificateBirthModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateBirthActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateBirthActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalCertificateBirthModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateBirthActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateBirthActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateBirthActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateBirthActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateBirthActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateBirthActionOK here] end
}

export class MedicalCertificateBirthActionFail extends BaseMedicalCertificateBirthAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalCertificateBirthActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalCertificateBirthActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalCertificateBirthModel>,
		// % protected region % [Add any additional constructor parameters for MedicalCertificateBirthActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalCertificateBirthActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalCertificateBirthActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalCertificateBirthActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalCertificateBirthActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalCertificateBirthActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalCertificateBirthActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalCertificateBirthActionFail here] end
}

export function isMedicalCertificateBirthModelAction(e: any): e is BaseMedicalCertificateBirthAction {
	return Object.values(MedicalCertificateBirthModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
