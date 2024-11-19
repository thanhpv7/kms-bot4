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
import {BpjsPcareKunjunganRujukanModel} from './bpjs_pcare_kunjungan_rujukan.model';
import {BpjsPcareKunjunganRujukanModelAudit} from './bpjs_pcare_kunjungan_rujukan.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Bpjs Pcare Kunjungan Rujukan model actions to be dispatched by NgRx.
 */
export enum BpjsPcareKunjunganRujukanModelActionTypes {
	CREATE_BPJS_PCARE_KUNJUNGAN_RUJUKAN = '[ENTITY] Create BpjsPcareKunjunganRujukanModel',
	CREATE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Create BpjsPcareKunjunganRujukanModel successfully',
	CREATE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Create BpjsPcareKunjunganRujukanModel failed',

	CREATE_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN = '[ENTITY] Create All BpjsPcareKunjunganRujukanModel',
	CREATE_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Create All BpjsPcareKunjunganRujukanModel successfully',
	CREATE_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Create All BpjsPcareKunjunganRujukanModel failed',

	DELETE_BPJS_PCARE_KUNJUNGAN_RUJUKAN = '[ENTITY] Delete BpjsPcareKunjunganRujukanModel',
	DELETE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Delete BpjsPcareKunjunganRujukanModel successfully',
	DELETE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Delete BpjsPcareKunjunganRujukanModel failed',


	DELETE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcareKunjunganRujukanModels Excluding Ids',
	DELETE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcareKunjunganRujukanModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcareKunjunganRujukanModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN = '[ENTITY] Delete all BpjsPcareKunjunganRujukanModels',
	DELETE_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Delete all BpjsPcareKunjunganRujukanModels successfully',
	DELETE_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Delete all BpjsPcareKunjunganRujukanModels failed',

	UPDATE_BPJS_PCARE_KUNJUNGAN_RUJUKAN = '[ENTITY] Update BpjsPcareKunjunganRujukanModel',
	UPDATE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Update BpjsPcareKunjunganRujukanModel successfully',
	UPDATE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Update BpjsPcareKunjunganRujukanModel failed',

	UPDATE_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN = '[ENTITY] Update all BpjsPcareKunjunganRujukanModel',
	UPDATE_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Update all BpjsPcareKunjunganRujukanModel successfully',
	UPDATE_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Update all BpjsPcareKunjunganRujukanModel failed',

	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN= '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel',
	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel successfully',
	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel failed',

	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_AUDIT= '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel audit',
	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_AUDIT_OK = '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel audit successfully',
	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel audit failed',

	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel audits by entity id',
	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel audits by entity id successfully',
	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN = '[ENTITY] Fetch all BpjsPcareKunjunganRujukanModel',
	FETCH_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Fetch all BpjsPcareKunjunganRujukanModel successfully',
	FETCH_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Fetch all BpjsPcareKunjunganRujukanModel failed',

	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_WITH_QUERY = '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel with query',
	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel with query successfully',
	FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcareKunjunganRujukanModel with query failed',

	FETCH_LAST_BPJS_PCARE_KUNJUNGAN_RUJUKAN_WITH_QUERY = '[ENTITY] Fetch last BpjsPcareKunjunganRujukanModel with query',
	FETCH_LAST_BPJS_PCARE_KUNJUNGAN_RUJUKAN_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcareKunjunganRujukanModel with query successfully',
	FETCH_LAST_BPJS_PCARE_KUNJUNGAN_RUJUKAN_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcareKunjunganRujukanModel with query failed',

	EXPORT_BPJS_PCARE_KUNJUNGAN_RUJUKAN = '[ENTITY] Export BpjsPcareKunjunganRujukanModel',
	EXPORT_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Export BpjsPcareKunjunganRujukanModel successfully',
	EXPORT_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Export BpjsPcareKunjunganRujukanModel failed',

	EXPORT_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN = '[ENTITY] Export All BpjsPcareKunjunganRujukanModels',
	EXPORT_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_OK = '[ENTITY] Export All BpjsPcareKunjunganRujukanModels successfully',
	EXPORT_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN_FAIL = '[ENTITY] Export All BpjsPcareKunjunganRujukanModels failed',

	EXPORT_BPJS_PCARE_KUNJUNGAN_RUJUKAN_EXCLUDING_IDS = '[ENTITY] Export BpjsPcareKunjunganRujukanModels excluding Ids',
	EXPORT_BPJS_PCARE_KUNJUNGAN_RUJUKAN_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcareKunjunganRujukanModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_KUNJUNGAN_RUJUKAN_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcareKunjunganRujukanModel excluding Ids failed',

	COUNT_BPJS_PCARE_KUNJUNGAN_RUJUKANS = '[ENTITY] Fetch number of BpjsPcareKunjunganRujukanModel records',
	COUNT_BPJS_PCARE_KUNJUNGAN_RUJUKANS_OK = '[ENTITY] Fetch number of BpjsPcareKunjunganRujukanModel records successfully ',
	COUNT_BPJS_PCARE_KUNJUNGAN_RUJUKANS_FAIL = '[ENTITY] Fetch number of BpjsPcareKunjunganRujukanModel records failed',

	IMPORT_BPJS_PCARE_KUNJUNGAN_RUJUKANS = '[ENTITY] Import BpjsPcareKunjunganRujukanModels',
	IMPORT_BPJS_PCARE_KUNJUNGAN_RUJUKANS_OK = '[ENTITY] Import BpjsPcareKunjunganRujukanModels successfully',
	IMPORT_BPJS_PCARE_KUNJUNGAN_RUJUKANS_FAIL = '[ENTITY] Import BpjsPcareKunjunganRujukanModels fail',


	INITIALISE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcareKunjunganRujukanModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcareKunjunganRujukanAction implements Action {
	readonly className: string = 'BpjsPcareKunjunganRujukanModel';

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

export class BpjsPcareKunjunganRujukanAction extends BaseBpjsPcareKunjunganRujukanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareKunjunganRujukanAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareKunjunganRujukanAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareKunjunganRujukanModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareKunjunganRujukanAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareKunjunganRujukanAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareKunjunganRujukanAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareKunjunganRujukanAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareKunjunganRujukanAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareKunjunganRujukanAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareKunjunganRujukanAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareKunjunganRujukanAction here] end
}

export class BpjsPcareKunjunganRujukanActionOK extends BaseBpjsPcareKunjunganRujukanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareKunjunganRujukanActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareKunjunganRujukanActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareKunjunganRujukanModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareKunjunganRujukanActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareKunjunganRujukanActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcareKunjunganRujukanModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareKunjunganRujukanActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareKunjunganRujukanActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareKunjunganRujukanActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareKunjunganRujukanActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareKunjunganRujukanActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareKunjunganRujukanActionOK here] end
}

export class BpjsPcareKunjunganRujukanActionFail extends BaseBpjsPcareKunjunganRujukanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareKunjunganRujukanActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareKunjunganRujukanActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcareKunjunganRujukanModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareKunjunganRujukanActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareKunjunganRujukanActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareKunjunganRujukanActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareKunjunganRujukanActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareKunjunganRujukanActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareKunjunganRujukanActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareKunjunganRujukanActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareKunjunganRujukanActionFail here] end
}

export function isBpjsPcareKunjunganRujukanModelAction(e: any): e is BaseBpjsPcareKunjunganRujukanAction {
	return Object.values(BpjsPcareKunjunganRujukanModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
