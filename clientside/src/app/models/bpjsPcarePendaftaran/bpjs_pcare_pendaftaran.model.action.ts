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
import {BpjsPcarePendaftaranModel} from './bpjs_pcare_pendaftaran.model';
import {BpjsPcarePendaftaranModelAudit} from './bpjs_pcare_pendaftaran.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Bpjs Pcare Pendaftaran model actions to be dispatched by NgRx.
 */
export enum BpjsPcarePendaftaranModelActionTypes {
	CREATE_BPJS_PCARE_PENDAFTARAN = '[ENTITY] Create BpjsPcarePendaftaranModel',
	CREATE_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Create BpjsPcarePendaftaranModel successfully',
	CREATE_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Create BpjsPcarePendaftaranModel failed',

	CREATE_ALL_BPJS_PCARE_PENDAFTARAN = '[ENTITY] Create All BpjsPcarePendaftaranModel',
	CREATE_ALL_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Create All BpjsPcarePendaftaranModel successfully',
	CREATE_ALL_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Create All BpjsPcarePendaftaranModel failed',

	DELETE_BPJS_PCARE_PENDAFTARAN = '[ENTITY] Delete BpjsPcarePendaftaranModel',
	DELETE_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Delete BpjsPcarePendaftaranModel successfully',
	DELETE_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Delete BpjsPcarePendaftaranModel failed',


	DELETE_BPJS_PCARE_PENDAFTARAN_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcarePendaftaranModels Excluding Ids',
	DELETE_BPJS_PCARE_PENDAFTARAN_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcarePendaftaranModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_PENDAFTARAN_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcarePendaftaranModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_PENDAFTARAN = '[ENTITY] Delete all BpjsPcarePendaftaranModels',
	DELETE_ALL_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Delete all BpjsPcarePendaftaranModels successfully',
	DELETE_ALL_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Delete all BpjsPcarePendaftaranModels failed',

	UPDATE_BPJS_PCARE_PENDAFTARAN = '[ENTITY] Update BpjsPcarePendaftaranModel',
	UPDATE_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Update BpjsPcarePendaftaranModel successfully',
	UPDATE_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Update BpjsPcarePendaftaranModel failed',

	UPDATE_ALL_BPJS_PCARE_PENDAFTARAN = '[ENTITY] Update all BpjsPcarePendaftaranModel',
	UPDATE_ALL_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Update all BpjsPcarePendaftaranModel successfully',
	UPDATE_ALL_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Update all BpjsPcarePendaftaranModel failed',

	FETCH_BPJS_PCARE_PENDAFTARAN= '[ENTITY] Fetch BpjsPcarePendaftaranModel',
	FETCH_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Fetch BpjsPcarePendaftaranModel successfully',
	FETCH_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Fetch BpjsPcarePendaftaranModel failed',

	FETCH_BPJS_PCARE_PENDAFTARAN_AUDIT= '[ENTITY] Fetch BpjsPcarePendaftaranModel audit',
	FETCH_BPJS_PCARE_PENDAFTARAN_AUDIT_OK = '[ENTITY] Fetch BpjsPcarePendaftaranModel audit successfully',
	FETCH_BPJS_PCARE_PENDAFTARAN_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcarePendaftaranModel audit failed',

	FETCH_BPJS_PCARE_PENDAFTARAN_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcarePendaftaranModel audits by entity id',
	FETCH_BPJS_PCARE_PENDAFTARAN_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcarePendaftaranModel audits by entity id successfully',
	FETCH_BPJS_PCARE_PENDAFTARAN_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcarePendaftaranModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_PENDAFTARAN = '[ENTITY] Fetch all BpjsPcarePendaftaranModel',
	FETCH_ALL_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Fetch all BpjsPcarePendaftaranModel successfully',
	FETCH_ALL_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Fetch all BpjsPcarePendaftaranModel failed',

	FETCH_BPJS_PCARE_PENDAFTARAN_WITH_QUERY = '[ENTITY] Fetch BpjsPcarePendaftaranModel with query',
	FETCH_BPJS_PCARE_PENDAFTARAN_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcarePendaftaranModel with query successfully',
	FETCH_BPJS_PCARE_PENDAFTARAN_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcarePendaftaranModel with query failed',

	FETCH_LAST_BPJS_PCARE_PENDAFTARAN_WITH_QUERY = '[ENTITY] Fetch last BpjsPcarePendaftaranModel with query',
	FETCH_LAST_BPJS_PCARE_PENDAFTARAN_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcarePendaftaranModel with query successfully',
	FETCH_LAST_BPJS_PCARE_PENDAFTARAN_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcarePendaftaranModel with query failed',

	EXPORT_BPJS_PCARE_PENDAFTARAN = '[ENTITY] Export BpjsPcarePendaftaranModel',
	EXPORT_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Export BpjsPcarePendaftaranModel successfully',
	EXPORT_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Export BpjsPcarePendaftaranModel failed',

	EXPORT_ALL_BPJS_PCARE_PENDAFTARAN = '[ENTITY] Export All BpjsPcarePendaftaranModels',
	EXPORT_ALL_BPJS_PCARE_PENDAFTARAN_OK = '[ENTITY] Export All BpjsPcarePendaftaranModels successfully',
	EXPORT_ALL_BPJS_PCARE_PENDAFTARAN_FAIL = '[ENTITY] Export All BpjsPcarePendaftaranModels failed',

	EXPORT_BPJS_PCARE_PENDAFTARAN_EXCLUDING_IDS = '[ENTITY] Export BpjsPcarePendaftaranModels excluding Ids',
	EXPORT_BPJS_PCARE_PENDAFTARAN_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcarePendaftaranModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_PENDAFTARAN_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcarePendaftaranModel excluding Ids failed',

	COUNT_BPJS_PCARE_PENDAFTARANS = '[ENTITY] Fetch number of BpjsPcarePendaftaranModel records',
	COUNT_BPJS_PCARE_PENDAFTARANS_OK = '[ENTITY] Fetch number of BpjsPcarePendaftaranModel records successfully ',
	COUNT_BPJS_PCARE_PENDAFTARANS_FAIL = '[ENTITY] Fetch number of BpjsPcarePendaftaranModel records failed',

	IMPORT_BPJS_PCARE_PENDAFTARANS = '[ENTITY] Import BpjsPcarePendaftaranModels',
	IMPORT_BPJS_PCARE_PENDAFTARANS_OK = '[ENTITY] Import BpjsPcarePendaftaranModels successfully',
	IMPORT_BPJS_PCARE_PENDAFTARANS_FAIL = '[ENTITY] Import BpjsPcarePendaftaranModels fail',


	INITIALISE_BPJS_PCARE_PENDAFTARAN_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcarePendaftaranModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcarePendaftaranAction implements Action {
	readonly className: string = 'BpjsPcarePendaftaranModel';

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

export class BpjsPcarePendaftaranAction extends BaseBpjsPcarePendaftaranAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcarePendaftaranAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcarePendaftaranAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcarePendaftaranModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcarePendaftaranAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcarePendaftaranAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcarePendaftaranAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcarePendaftaranAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcarePendaftaranAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcarePendaftaranAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcarePendaftaranAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcarePendaftaranAction here] end
}

export class BpjsPcarePendaftaranActionOK extends BaseBpjsPcarePendaftaranAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcarePendaftaranActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcarePendaftaranActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcarePendaftaranModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcarePendaftaranActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcarePendaftaranActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcarePendaftaranModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcarePendaftaranActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcarePendaftaranActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcarePendaftaranActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcarePendaftaranActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcarePendaftaranActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcarePendaftaranActionOK here] end
}

export class BpjsPcarePendaftaranActionFail extends BaseBpjsPcarePendaftaranAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcarePendaftaranActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcarePendaftaranActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcarePendaftaranModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcarePendaftaranActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcarePendaftaranActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcarePendaftaranActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcarePendaftaranActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcarePendaftaranActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcarePendaftaranActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcarePendaftaranActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcarePendaftaranActionFail here] end
}

export function isBpjsPcarePendaftaranModelAction(e: any): e is BaseBpjsPcarePendaftaranAction {
	return Object.values(BpjsPcarePendaftaranModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
