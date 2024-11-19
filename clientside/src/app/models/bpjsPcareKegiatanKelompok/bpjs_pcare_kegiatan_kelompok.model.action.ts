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
import {BpjsPcareKegiatanKelompokModel} from './bpjs_pcare_kegiatan_kelompok.model';
import {BpjsPcareKegiatanKelompokModelAudit} from './bpjs_pcare_kegiatan_kelompok.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Pcare Kegiatan Kelompok model actions to be dispatched by NgRx.
 */
export enum BpjsPcareKegiatanKelompokModelActionTypes {
	CREATE_BPJS_PCARE_KEGIATAN_KELOMPOK = '[ENTITY] Create BpjsPcareKegiatanKelompokModel',
	CREATE_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Create BpjsPcareKegiatanKelompokModel successfully',
	CREATE_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Create BpjsPcareKegiatanKelompokModel failed',

	CREATE_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK = '[ENTITY] Create All BpjsPcareKegiatanKelompokModel',
	CREATE_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Create All BpjsPcareKegiatanKelompokModel successfully',
	CREATE_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Create All BpjsPcareKegiatanKelompokModel failed',

	DELETE_BPJS_PCARE_KEGIATAN_KELOMPOK = '[ENTITY] Delete BpjsPcareKegiatanKelompokModel',
	DELETE_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Delete BpjsPcareKegiatanKelompokModel successfully',
	DELETE_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Delete BpjsPcareKegiatanKelompokModel failed',


	DELETE_BPJS_PCARE_KEGIATAN_KELOMPOK_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcareKegiatanKelompokModels Excluding Ids',
	DELETE_BPJS_PCARE_KEGIATAN_KELOMPOK_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcareKegiatanKelompokModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_KEGIATAN_KELOMPOK_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcareKegiatanKelompokModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK = '[ENTITY] Delete all BpjsPcareKegiatanKelompokModels',
	DELETE_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Delete all BpjsPcareKegiatanKelompokModels successfully',
	DELETE_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Delete all BpjsPcareKegiatanKelompokModels failed',

	UPDATE_BPJS_PCARE_KEGIATAN_KELOMPOK = '[ENTITY] Update BpjsPcareKegiatanKelompokModel',
	UPDATE_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Update BpjsPcareKegiatanKelompokModel successfully',
	UPDATE_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Update BpjsPcareKegiatanKelompokModel failed',

	UPDATE_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK = '[ENTITY] Update all BpjsPcareKegiatanKelompokModel',
	UPDATE_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Update all BpjsPcareKegiatanKelompokModel successfully',
	UPDATE_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Update all BpjsPcareKegiatanKelompokModel failed',

	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK= '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel',
	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel successfully',
	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel failed',

	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_AUDIT= '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel audit',
	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_AUDIT_OK = '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel audit successfully',
	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel audit failed',

	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel audits by entity id',
	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel audits by entity id successfully',
	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK = '[ENTITY] Fetch all BpjsPcareKegiatanKelompokModel',
	FETCH_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Fetch all BpjsPcareKegiatanKelompokModel successfully',
	FETCH_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Fetch all BpjsPcareKegiatanKelompokModel failed',

	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_WITH_QUERY = '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel with query',
	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel with query successfully',
	FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcareKegiatanKelompokModel with query failed',

	FETCH_LAST_BPJS_PCARE_KEGIATAN_KELOMPOK_WITH_QUERY = '[ENTITY] Fetch last BpjsPcareKegiatanKelompokModel with query',
	FETCH_LAST_BPJS_PCARE_KEGIATAN_KELOMPOK_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcareKegiatanKelompokModel with query successfully',
	FETCH_LAST_BPJS_PCARE_KEGIATAN_KELOMPOK_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcareKegiatanKelompokModel with query failed',

	EXPORT_BPJS_PCARE_KEGIATAN_KELOMPOK = '[ENTITY] Export BpjsPcareKegiatanKelompokModel',
	EXPORT_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Export BpjsPcareKegiatanKelompokModel successfully',
	EXPORT_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Export BpjsPcareKegiatanKelompokModel failed',

	EXPORT_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK = '[ENTITY] Export All BpjsPcareKegiatanKelompokModels',
	EXPORT_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_OK = '[ENTITY] Export All BpjsPcareKegiatanKelompokModels successfully',
	EXPORT_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK_FAIL = '[ENTITY] Export All BpjsPcareKegiatanKelompokModels failed',

	EXPORT_BPJS_PCARE_KEGIATAN_KELOMPOK_EXCLUDING_IDS = '[ENTITY] Export BpjsPcareKegiatanKelompokModels excluding Ids',
	EXPORT_BPJS_PCARE_KEGIATAN_KELOMPOK_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcareKegiatanKelompokModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_KEGIATAN_KELOMPOK_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcareKegiatanKelompokModel excluding Ids failed',

	COUNT_BPJS_PCARE_KEGIATAN_KELOMPOKS = '[ENTITY] Fetch number of BpjsPcareKegiatanKelompokModel records',
	COUNT_BPJS_PCARE_KEGIATAN_KELOMPOKS_OK = '[ENTITY] Fetch number of BpjsPcareKegiatanKelompokModel records successfully ',
	COUNT_BPJS_PCARE_KEGIATAN_KELOMPOKS_FAIL = '[ENTITY] Fetch number of BpjsPcareKegiatanKelompokModel records failed',

	IMPORT_BPJS_PCARE_KEGIATAN_KELOMPOKS = '[ENTITY] Import BpjsPcareKegiatanKelompokModels',
	IMPORT_BPJS_PCARE_KEGIATAN_KELOMPOKS_OK = '[ENTITY] Import BpjsPcareKegiatanKelompokModels successfully',
	IMPORT_BPJS_PCARE_KEGIATAN_KELOMPOKS_FAIL = '[ENTITY] Import BpjsPcareKegiatanKelompokModels fail',


	INITIALISE_BPJS_PCARE_KEGIATAN_KELOMPOK_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcareKegiatanKelompokModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcareKegiatanKelompokAction implements Action {
	readonly className: string = 'BpjsPcareKegiatanKelompokModel';

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

export class BpjsPcareKegiatanKelompokAction extends BaseBpjsPcareKegiatanKelompokAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareKegiatanKelompokAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareKegiatanKelompokAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareKegiatanKelompokModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareKegiatanKelompokAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareKegiatanKelompokAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareKegiatanKelompokAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareKegiatanKelompokAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareKegiatanKelompokAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareKegiatanKelompokAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareKegiatanKelompokAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareKegiatanKelompokAction here] end
}

export class BpjsPcareKegiatanKelompokActionOK extends BaseBpjsPcareKegiatanKelompokAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareKegiatanKelompokActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareKegiatanKelompokActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareKegiatanKelompokModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareKegiatanKelompokActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareKegiatanKelompokActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcareKegiatanKelompokModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareKegiatanKelompokActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareKegiatanKelompokActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareKegiatanKelompokActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareKegiatanKelompokActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareKegiatanKelompokActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareKegiatanKelompokActionOK here] end
}

export class BpjsPcareKegiatanKelompokActionFail extends BaseBpjsPcareKegiatanKelompokAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareKegiatanKelompokActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareKegiatanKelompokActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcareKegiatanKelompokModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareKegiatanKelompokActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareKegiatanKelompokActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareKegiatanKelompokActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareKegiatanKelompokActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareKegiatanKelompokActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareKegiatanKelompokActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareKegiatanKelompokActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareKegiatanKelompokActionFail here] end
}

export function isBpjsPcareKegiatanKelompokModelAction(e: any): e is BaseBpjsPcareKegiatanKelompokAction {
	return Object.values(BpjsPcareKegiatanKelompokModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
