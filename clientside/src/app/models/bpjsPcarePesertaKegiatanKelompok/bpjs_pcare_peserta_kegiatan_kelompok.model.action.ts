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
import {BpjsPcarePesertaKegiatanKelompokModel} from './bpjs_pcare_peserta_kegiatan_kelompok.model';
import {BpjsPcarePesertaKegiatanKelompokModelAudit} from './bpjs_pcare_peserta_kegiatan_kelompok.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Pcare Peserta Kegiatan Kelompok model actions to be dispatched by NgRx.
 */
export enum BpjsPcarePesertaKegiatanKelompokModelActionTypes {
	CREATE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK = '[ENTITY] Create BpjsPcarePesertaKegiatanKelompokModel',
	CREATE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Create BpjsPcarePesertaKegiatanKelompokModel successfully',
	CREATE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Create BpjsPcarePesertaKegiatanKelompokModel failed',

	CREATE_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK = '[ENTITY] Create All BpjsPcarePesertaKegiatanKelompokModel',
	CREATE_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Create All BpjsPcarePesertaKegiatanKelompokModel successfully',
	CREATE_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Create All BpjsPcarePesertaKegiatanKelompokModel failed',

	DELETE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK = '[ENTITY] Delete BpjsPcarePesertaKegiatanKelompokModel',
	DELETE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Delete BpjsPcarePesertaKegiatanKelompokModel successfully',
	DELETE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Delete BpjsPcarePesertaKegiatanKelompokModel failed',


	DELETE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcarePesertaKegiatanKelompokModels Excluding Ids',
	DELETE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcarePesertaKegiatanKelompokModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcarePesertaKegiatanKelompokModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK = '[ENTITY] Delete all BpjsPcarePesertaKegiatanKelompokModels',
	DELETE_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Delete all BpjsPcarePesertaKegiatanKelompokModels successfully',
	DELETE_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Delete all BpjsPcarePesertaKegiatanKelompokModels failed',

	UPDATE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK = '[ENTITY] Update BpjsPcarePesertaKegiatanKelompokModel',
	UPDATE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Update BpjsPcarePesertaKegiatanKelompokModel successfully',
	UPDATE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Update BpjsPcarePesertaKegiatanKelompokModel failed',

	UPDATE_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK = '[ENTITY] Update all BpjsPcarePesertaKegiatanKelompokModel',
	UPDATE_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Update all BpjsPcarePesertaKegiatanKelompokModel successfully',
	UPDATE_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Update all BpjsPcarePesertaKegiatanKelompokModel failed',

	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK= '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel',
	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel successfully',
	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel failed',

	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_AUDIT= '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel audit',
	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_AUDIT_OK = '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel audit successfully',
	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel audit failed',

	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel audits by entity id',
	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel audits by entity id successfully',
	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK = '[ENTITY] Fetch all BpjsPcarePesertaKegiatanKelompokModel',
	FETCH_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Fetch all BpjsPcarePesertaKegiatanKelompokModel successfully',
	FETCH_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Fetch all BpjsPcarePesertaKegiatanKelompokModel failed',

	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_WITH_QUERY = '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel with query',
	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel with query successfully',
	FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcarePesertaKegiatanKelompokModel with query failed',

	FETCH_LAST_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_WITH_QUERY = '[ENTITY] Fetch last BpjsPcarePesertaKegiatanKelompokModel with query',
	FETCH_LAST_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcarePesertaKegiatanKelompokModel with query successfully',
	FETCH_LAST_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcarePesertaKegiatanKelompokModel with query failed',

	EXPORT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK = '[ENTITY] Export BpjsPcarePesertaKegiatanKelompokModel',
	EXPORT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Export BpjsPcarePesertaKegiatanKelompokModel successfully',
	EXPORT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Export BpjsPcarePesertaKegiatanKelompokModel failed',

	EXPORT_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK = '[ENTITY] Export All BpjsPcarePesertaKegiatanKelompokModels',
	EXPORT_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_OK = '[ENTITY] Export All BpjsPcarePesertaKegiatanKelompokModels successfully',
	EXPORT_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Export All BpjsPcarePesertaKegiatanKelompokModels failed',

	EXPORT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_EXCLUDING_IDS = '[ENTITY] Export BpjsPcarePesertaKegiatanKelompokModels excluding Ids',
	EXPORT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcarePesertaKegiatanKelompokModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcarePesertaKegiatanKelompokModel excluding Ids failed',

	COUNT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOKS = '[ENTITY] Fetch number of BpjsPcarePesertaKegiatanKelompokModel records',
	COUNT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOKS_OK = '[ENTITY] Fetch number of BpjsPcarePesertaKegiatanKelompokModel records successfully ',
	COUNT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOKS_FAIL = '[ENTITY] Fetch number of BpjsPcarePesertaKegiatanKelompokModel records failed',

	IMPORT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOKS = '[ENTITY] Import BpjsPcarePesertaKegiatanKelompokModels',
	IMPORT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOKS_OK = '[ENTITY] Import BpjsPcarePesertaKegiatanKelompokModels successfully',
	IMPORT_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOKS_FAIL = '[ENTITY] Import BpjsPcarePesertaKegiatanKelompokModels fail',


	INITIALISE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcarePesertaKegiatanKelompokModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcarePesertaKegiatanKelompokAction implements Action {
	readonly className: string = 'BpjsPcarePesertaKegiatanKelompokModel';

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

export class BpjsPcarePesertaKegiatanKelompokAction extends BaseBpjsPcarePesertaKegiatanKelompokAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcarePesertaKegiatanKelompokAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcarePesertaKegiatanKelompokAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcarePesertaKegiatanKelompokModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcarePesertaKegiatanKelompokAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcarePesertaKegiatanKelompokAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcarePesertaKegiatanKelompokAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcarePesertaKegiatanKelompokAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcarePesertaKegiatanKelompokAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcarePesertaKegiatanKelompokAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcarePesertaKegiatanKelompokAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcarePesertaKegiatanKelompokAction here] end
}

export class BpjsPcarePesertaKegiatanKelompokActionOK extends BaseBpjsPcarePesertaKegiatanKelompokAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcarePesertaKegiatanKelompokActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcarePesertaKegiatanKelompokActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcarePesertaKegiatanKelompokModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcarePesertaKegiatanKelompokActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcarePesertaKegiatanKelompokActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcarePesertaKegiatanKelompokModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcarePesertaKegiatanKelompokActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcarePesertaKegiatanKelompokActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcarePesertaKegiatanKelompokActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcarePesertaKegiatanKelompokActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcarePesertaKegiatanKelompokActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcarePesertaKegiatanKelompokActionOK here] end
}

export class BpjsPcarePesertaKegiatanKelompokActionFail extends BaseBpjsPcarePesertaKegiatanKelompokAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcarePesertaKegiatanKelompokActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcarePesertaKegiatanKelompokActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcarePesertaKegiatanKelompokModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcarePesertaKegiatanKelompokActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcarePesertaKegiatanKelompokActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcarePesertaKegiatanKelompokActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcarePesertaKegiatanKelompokActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcarePesertaKegiatanKelompokActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcarePesertaKegiatanKelompokActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcarePesertaKegiatanKelompokActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcarePesertaKegiatanKelompokActionFail here] end
}

export function isBpjsPcarePesertaKegiatanKelompokModelAction(e: any): e is BaseBpjsPcarePesertaKegiatanKelompokAction {
	return Object.values(BpjsPcarePesertaKegiatanKelompokModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
