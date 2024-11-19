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
import {BpjsPcareProviderRayonisasiModel} from './bpjs_pcare_provider_rayonisasi.model';
import {BpjsPcareProviderRayonisasiModelAudit} from './bpjs_pcare_provider_rayonisasi.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Pcare Provider Rayonisasi model actions to be dispatched by NgRx.
 */
export enum BpjsPcareProviderRayonisasiModelActionTypes {
	CREATE_BPJS_PCARE_PROVIDER_RAYONISASI = '[ENTITY] Create BpjsPcareProviderRayonisasiModel',
	CREATE_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Create BpjsPcareProviderRayonisasiModel successfully',
	CREATE_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Create BpjsPcareProviderRayonisasiModel failed',

	CREATE_ALL_BPJS_PCARE_PROVIDER_RAYONISASI = '[ENTITY] Create All BpjsPcareProviderRayonisasiModel',
	CREATE_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Create All BpjsPcareProviderRayonisasiModel successfully',
	CREATE_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Create All BpjsPcareProviderRayonisasiModel failed',

	DELETE_BPJS_PCARE_PROVIDER_RAYONISASI = '[ENTITY] Delete BpjsPcareProviderRayonisasiModel',
	DELETE_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Delete BpjsPcareProviderRayonisasiModel successfully',
	DELETE_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Delete BpjsPcareProviderRayonisasiModel failed',


	DELETE_BPJS_PCARE_PROVIDER_RAYONISASI_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcareProviderRayonisasiModels Excluding Ids',
	DELETE_BPJS_PCARE_PROVIDER_RAYONISASI_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcareProviderRayonisasiModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_PROVIDER_RAYONISASI_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcareProviderRayonisasiModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_PROVIDER_RAYONISASI = '[ENTITY] Delete all BpjsPcareProviderRayonisasiModels',
	DELETE_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Delete all BpjsPcareProviderRayonisasiModels successfully',
	DELETE_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Delete all BpjsPcareProviderRayonisasiModels failed',

	UPDATE_BPJS_PCARE_PROVIDER_RAYONISASI = '[ENTITY] Update BpjsPcareProviderRayonisasiModel',
	UPDATE_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Update BpjsPcareProviderRayonisasiModel successfully',
	UPDATE_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Update BpjsPcareProviderRayonisasiModel failed',

	UPDATE_ALL_BPJS_PCARE_PROVIDER_RAYONISASI = '[ENTITY] Update all BpjsPcareProviderRayonisasiModel',
	UPDATE_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Update all BpjsPcareProviderRayonisasiModel successfully',
	UPDATE_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Update all BpjsPcareProviderRayonisasiModel failed',

	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI= '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel',
	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel successfully',
	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel failed',

	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_AUDIT= '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel audit',
	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_AUDIT_OK = '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel audit successfully',
	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel audit failed',

	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel audits by entity id',
	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel audits by entity id successfully',
	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_PROVIDER_RAYONISASI = '[ENTITY] Fetch all BpjsPcareProviderRayonisasiModel',
	FETCH_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Fetch all BpjsPcareProviderRayonisasiModel successfully',
	FETCH_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Fetch all BpjsPcareProviderRayonisasiModel failed',

	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_WITH_QUERY = '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel with query',
	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel with query successfully',
	FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcareProviderRayonisasiModel with query failed',

	FETCH_LAST_BPJS_PCARE_PROVIDER_RAYONISASI_WITH_QUERY = '[ENTITY] Fetch last BpjsPcareProviderRayonisasiModel with query',
	FETCH_LAST_BPJS_PCARE_PROVIDER_RAYONISASI_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcareProviderRayonisasiModel with query successfully',
	FETCH_LAST_BPJS_PCARE_PROVIDER_RAYONISASI_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcareProviderRayonisasiModel with query failed',

	EXPORT_BPJS_PCARE_PROVIDER_RAYONISASI = '[ENTITY] Export BpjsPcareProviderRayonisasiModel',
	EXPORT_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Export BpjsPcareProviderRayonisasiModel successfully',
	EXPORT_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Export BpjsPcareProviderRayonisasiModel failed',

	EXPORT_ALL_BPJS_PCARE_PROVIDER_RAYONISASI = '[ENTITY] Export All BpjsPcareProviderRayonisasiModels',
	EXPORT_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_OK = '[ENTITY] Export All BpjsPcareProviderRayonisasiModels successfully',
	EXPORT_ALL_BPJS_PCARE_PROVIDER_RAYONISASI_FAIL = '[ENTITY] Export All BpjsPcareProviderRayonisasiModels failed',

	EXPORT_BPJS_PCARE_PROVIDER_RAYONISASI_EXCLUDING_IDS = '[ENTITY] Export BpjsPcareProviderRayonisasiModels excluding Ids',
	EXPORT_BPJS_PCARE_PROVIDER_RAYONISASI_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcareProviderRayonisasiModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_PROVIDER_RAYONISASI_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcareProviderRayonisasiModel excluding Ids failed',

	COUNT_BPJS_PCARE_PROVIDER_RAYONISASIS = '[ENTITY] Fetch number of BpjsPcareProviderRayonisasiModel records',
	COUNT_BPJS_PCARE_PROVIDER_RAYONISASIS_OK = '[ENTITY] Fetch number of BpjsPcareProviderRayonisasiModel records successfully ',
	COUNT_BPJS_PCARE_PROVIDER_RAYONISASIS_FAIL = '[ENTITY] Fetch number of BpjsPcareProviderRayonisasiModel records failed',

	IMPORT_BPJS_PCARE_PROVIDER_RAYONISASIS = '[ENTITY] Import BpjsPcareProviderRayonisasiModels',
	IMPORT_BPJS_PCARE_PROVIDER_RAYONISASIS_OK = '[ENTITY] Import BpjsPcareProviderRayonisasiModels successfully',
	IMPORT_BPJS_PCARE_PROVIDER_RAYONISASIS_FAIL = '[ENTITY] Import BpjsPcareProviderRayonisasiModels fail',


	INITIALISE_BPJS_PCARE_PROVIDER_RAYONISASI_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcareProviderRayonisasiModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcareProviderRayonisasiAction implements Action {
	readonly className: string = 'BpjsPcareProviderRayonisasiModel';

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

export class BpjsPcareProviderRayonisasiAction extends BaseBpjsPcareProviderRayonisasiAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareProviderRayonisasiAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareProviderRayonisasiAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareProviderRayonisasiModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareProviderRayonisasiAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareProviderRayonisasiAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareProviderRayonisasiAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareProviderRayonisasiAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareProviderRayonisasiAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareProviderRayonisasiAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareProviderRayonisasiAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareProviderRayonisasiAction here] end
}

export class BpjsPcareProviderRayonisasiActionOK extends BaseBpjsPcareProviderRayonisasiAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareProviderRayonisasiActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareProviderRayonisasiActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareProviderRayonisasiModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareProviderRayonisasiActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareProviderRayonisasiActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcareProviderRayonisasiModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareProviderRayonisasiActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareProviderRayonisasiActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareProviderRayonisasiActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareProviderRayonisasiActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareProviderRayonisasiActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareProviderRayonisasiActionOK here] end
}

export class BpjsPcareProviderRayonisasiActionFail extends BaseBpjsPcareProviderRayonisasiAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareProviderRayonisasiActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareProviderRayonisasiActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcareProviderRayonisasiModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareProviderRayonisasiActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareProviderRayonisasiActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareProviderRayonisasiActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareProviderRayonisasiActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareProviderRayonisasiActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareProviderRayonisasiActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareProviderRayonisasiActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareProviderRayonisasiActionFail here] end
}

export function isBpjsPcareProviderRayonisasiModelAction(e: any): e is BaseBpjsPcareProviderRayonisasiAction {
	return Object.values(BpjsPcareProviderRayonisasiModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
