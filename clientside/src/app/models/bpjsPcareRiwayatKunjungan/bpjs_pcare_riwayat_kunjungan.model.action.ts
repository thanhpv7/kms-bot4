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
import {BpjsPcareRiwayatKunjunganModel} from './bpjs_pcare_riwayat_kunjungan.model';
import {BpjsPcareRiwayatKunjunganModelAudit} from './bpjs_pcare_riwayat_kunjungan.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Bpjs Pcare Riwayat Kunjungan model actions to be dispatched by NgRx.
 */
export enum BpjsPcareRiwayatKunjunganModelActionTypes {
	CREATE_BPJS_PCARE_RIWAYAT_KUNJUNGAN = '[ENTITY] Create BpjsPcareRiwayatKunjunganModel',
	CREATE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Create BpjsPcareRiwayatKunjunganModel successfully',
	CREATE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Create BpjsPcareRiwayatKunjunganModel failed',

	CREATE_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN = '[ENTITY] Create All BpjsPcareRiwayatKunjunganModel',
	CREATE_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Create All BpjsPcareRiwayatKunjunganModel successfully',
	CREATE_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Create All BpjsPcareRiwayatKunjunganModel failed',

	DELETE_BPJS_PCARE_RIWAYAT_KUNJUNGAN = '[ENTITY] Delete BpjsPcareRiwayatKunjunganModel',
	DELETE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Delete BpjsPcareRiwayatKunjunganModel successfully',
	DELETE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Delete BpjsPcareRiwayatKunjunganModel failed',


	DELETE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcareRiwayatKunjunganModels Excluding Ids',
	DELETE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcareRiwayatKunjunganModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcareRiwayatKunjunganModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN = '[ENTITY] Delete all BpjsPcareRiwayatKunjunganModels',
	DELETE_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Delete all BpjsPcareRiwayatKunjunganModels successfully',
	DELETE_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Delete all BpjsPcareRiwayatKunjunganModels failed',

	UPDATE_BPJS_PCARE_RIWAYAT_KUNJUNGAN = '[ENTITY] Update BpjsPcareRiwayatKunjunganModel',
	UPDATE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Update BpjsPcareRiwayatKunjunganModel successfully',
	UPDATE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Update BpjsPcareRiwayatKunjunganModel failed',

	UPDATE_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN = '[ENTITY] Update all BpjsPcareRiwayatKunjunganModel',
	UPDATE_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Update all BpjsPcareRiwayatKunjunganModel successfully',
	UPDATE_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Update all BpjsPcareRiwayatKunjunganModel failed',

	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN= '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel',
	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel successfully',
	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel failed',

	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_AUDIT= '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel audit',
	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_AUDIT_OK = '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel audit successfully',
	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel audit failed',

	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel audits by entity id',
	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel audits by entity id successfully',
	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN = '[ENTITY] Fetch all BpjsPcareRiwayatKunjunganModel',
	FETCH_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Fetch all BpjsPcareRiwayatKunjunganModel successfully',
	FETCH_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Fetch all BpjsPcareRiwayatKunjunganModel failed',

	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_WITH_QUERY = '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel with query',
	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel with query successfully',
	FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcareRiwayatKunjunganModel with query failed',

	FETCH_LAST_BPJS_PCARE_RIWAYAT_KUNJUNGAN_WITH_QUERY = '[ENTITY] Fetch last BpjsPcareRiwayatKunjunganModel with query',
	FETCH_LAST_BPJS_PCARE_RIWAYAT_KUNJUNGAN_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcareRiwayatKunjunganModel with query successfully',
	FETCH_LAST_BPJS_PCARE_RIWAYAT_KUNJUNGAN_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcareRiwayatKunjunganModel with query failed',

	EXPORT_BPJS_PCARE_RIWAYAT_KUNJUNGAN = '[ENTITY] Export BpjsPcareRiwayatKunjunganModel',
	EXPORT_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Export BpjsPcareRiwayatKunjunganModel successfully',
	EXPORT_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Export BpjsPcareRiwayatKunjunganModel failed',

	EXPORT_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN = '[ENTITY] Export All BpjsPcareRiwayatKunjunganModels',
	EXPORT_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_OK = '[ENTITY] Export All BpjsPcareRiwayatKunjunganModels successfully',
	EXPORT_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN_FAIL = '[ENTITY] Export All BpjsPcareRiwayatKunjunganModels failed',

	EXPORT_BPJS_PCARE_RIWAYAT_KUNJUNGAN_EXCLUDING_IDS = '[ENTITY] Export BpjsPcareRiwayatKunjunganModels excluding Ids',
	EXPORT_BPJS_PCARE_RIWAYAT_KUNJUNGAN_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcareRiwayatKunjunganModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_RIWAYAT_KUNJUNGAN_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcareRiwayatKunjunganModel excluding Ids failed',

	COUNT_BPJS_PCARE_RIWAYAT_KUNJUNGANS = '[ENTITY] Fetch number of BpjsPcareRiwayatKunjunganModel records',
	COUNT_BPJS_PCARE_RIWAYAT_KUNJUNGANS_OK = '[ENTITY] Fetch number of BpjsPcareRiwayatKunjunganModel records successfully ',
	COUNT_BPJS_PCARE_RIWAYAT_KUNJUNGANS_FAIL = '[ENTITY] Fetch number of BpjsPcareRiwayatKunjunganModel records failed',

	IMPORT_BPJS_PCARE_RIWAYAT_KUNJUNGANS = '[ENTITY] Import BpjsPcareRiwayatKunjunganModels',
	IMPORT_BPJS_PCARE_RIWAYAT_KUNJUNGANS_OK = '[ENTITY] Import BpjsPcareRiwayatKunjunganModels successfully',
	IMPORT_BPJS_PCARE_RIWAYAT_KUNJUNGANS_FAIL = '[ENTITY] Import BpjsPcareRiwayatKunjunganModels fail',


	INITIALISE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcareRiwayatKunjunganModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcareRiwayatKunjunganAction implements Action {
	readonly className: string = 'BpjsPcareRiwayatKunjunganModel';

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

export class BpjsPcareRiwayatKunjunganAction extends BaseBpjsPcareRiwayatKunjunganAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareRiwayatKunjunganAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareRiwayatKunjunganAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareRiwayatKunjunganModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareRiwayatKunjunganAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareRiwayatKunjunganAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareRiwayatKunjunganAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareRiwayatKunjunganAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareRiwayatKunjunganAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareRiwayatKunjunganAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareRiwayatKunjunganAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareRiwayatKunjunganAction here] end
}

export class BpjsPcareRiwayatKunjunganActionOK extends BaseBpjsPcareRiwayatKunjunganAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareRiwayatKunjunganActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareRiwayatKunjunganActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareRiwayatKunjunganModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareRiwayatKunjunganActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareRiwayatKunjunganActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcareRiwayatKunjunganModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareRiwayatKunjunganActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareRiwayatKunjunganActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareRiwayatKunjunganActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareRiwayatKunjunganActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareRiwayatKunjunganActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareRiwayatKunjunganActionOK here] end
}

export class BpjsPcareRiwayatKunjunganActionFail extends BaseBpjsPcareRiwayatKunjunganAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareRiwayatKunjunganActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareRiwayatKunjunganActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcareRiwayatKunjunganModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareRiwayatKunjunganActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareRiwayatKunjunganActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareRiwayatKunjunganActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareRiwayatKunjunganActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareRiwayatKunjunganActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareRiwayatKunjunganActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareRiwayatKunjunganActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareRiwayatKunjunganActionFail here] end
}

export function isBpjsPcareRiwayatKunjunganModelAction(e: any): e is BaseBpjsPcareRiwayatKunjunganAction {
	return Object.values(BpjsPcareRiwayatKunjunganModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
