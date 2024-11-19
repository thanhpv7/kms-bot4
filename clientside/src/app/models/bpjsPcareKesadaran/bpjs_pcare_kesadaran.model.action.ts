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
import {BpjsPcareKesadaranModel} from './bpjs_pcare_kesadaran.model';
import {BpjsPcareKesadaranModelAudit} from './bpjs_pcare_kesadaran.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Pcare Kesadaran model actions to be dispatched by NgRx.
 */
export enum BpjsPcareKesadaranModelActionTypes {
	CREATE_BPJS_PCARE_KESADARAN = '[ENTITY] Create BpjsPcareKesadaranModel',
	CREATE_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Create BpjsPcareKesadaranModel successfully',
	CREATE_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Create BpjsPcareKesadaranModel failed',

	CREATE_ALL_BPJS_PCARE_KESADARAN = '[ENTITY] Create All BpjsPcareKesadaranModel',
	CREATE_ALL_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Create All BpjsPcareKesadaranModel successfully',
	CREATE_ALL_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Create All BpjsPcareKesadaranModel failed',

	DELETE_BPJS_PCARE_KESADARAN = '[ENTITY] Delete BpjsPcareKesadaranModel',
	DELETE_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Delete BpjsPcareKesadaranModel successfully',
	DELETE_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Delete BpjsPcareKesadaranModel failed',


	DELETE_BPJS_PCARE_KESADARAN_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcareKesadaranModels Excluding Ids',
	DELETE_BPJS_PCARE_KESADARAN_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcareKesadaranModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_KESADARAN_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcareKesadaranModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_KESADARAN = '[ENTITY] Delete all BpjsPcareKesadaranModels',
	DELETE_ALL_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Delete all BpjsPcareKesadaranModels successfully',
	DELETE_ALL_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Delete all BpjsPcareKesadaranModels failed',

	UPDATE_BPJS_PCARE_KESADARAN = '[ENTITY] Update BpjsPcareKesadaranModel',
	UPDATE_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Update BpjsPcareKesadaranModel successfully',
	UPDATE_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Update BpjsPcareKesadaranModel failed',

	UPDATE_ALL_BPJS_PCARE_KESADARAN = '[ENTITY] Update all BpjsPcareKesadaranModel',
	UPDATE_ALL_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Update all BpjsPcareKesadaranModel successfully',
	UPDATE_ALL_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Update all BpjsPcareKesadaranModel failed',

	FETCH_BPJS_PCARE_KESADARAN= '[ENTITY] Fetch BpjsPcareKesadaranModel',
	FETCH_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Fetch BpjsPcareKesadaranModel successfully',
	FETCH_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Fetch BpjsPcareKesadaranModel failed',

	FETCH_BPJS_PCARE_KESADARAN_AUDIT= '[ENTITY] Fetch BpjsPcareKesadaranModel audit',
	FETCH_BPJS_PCARE_KESADARAN_AUDIT_OK = '[ENTITY] Fetch BpjsPcareKesadaranModel audit successfully',
	FETCH_BPJS_PCARE_KESADARAN_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcareKesadaranModel audit failed',

	FETCH_BPJS_PCARE_KESADARAN_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcareKesadaranModel audits by entity id',
	FETCH_BPJS_PCARE_KESADARAN_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcareKesadaranModel audits by entity id successfully',
	FETCH_BPJS_PCARE_KESADARAN_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcareKesadaranModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_KESADARAN = '[ENTITY] Fetch all BpjsPcareKesadaranModel',
	FETCH_ALL_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Fetch all BpjsPcareKesadaranModel successfully',
	FETCH_ALL_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Fetch all BpjsPcareKesadaranModel failed',

	FETCH_BPJS_PCARE_KESADARAN_WITH_QUERY = '[ENTITY] Fetch BpjsPcareKesadaranModel with query',
	FETCH_BPJS_PCARE_KESADARAN_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcareKesadaranModel with query successfully',
	FETCH_BPJS_PCARE_KESADARAN_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcareKesadaranModel with query failed',

	FETCH_LAST_BPJS_PCARE_KESADARAN_WITH_QUERY = '[ENTITY] Fetch last BpjsPcareKesadaranModel with query',
	FETCH_LAST_BPJS_PCARE_KESADARAN_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcareKesadaranModel with query successfully',
	FETCH_LAST_BPJS_PCARE_KESADARAN_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcareKesadaranModel with query failed',

	EXPORT_BPJS_PCARE_KESADARAN = '[ENTITY] Export BpjsPcareKesadaranModel',
	EXPORT_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Export BpjsPcareKesadaranModel successfully',
	EXPORT_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Export BpjsPcareKesadaranModel failed',

	EXPORT_ALL_BPJS_PCARE_KESADARAN = '[ENTITY] Export All BpjsPcareKesadaranModels',
	EXPORT_ALL_BPJS_PCARE_KESADARAN_OK = '[ENTITY] Export All BpjsPcareKesadaranModels successfully',
	EXPORT_ALL_BPJS_PCARE_KESADARAN_FAIL = '[ENTITY] Export All BpjsPcareKesadaranModels failed',

	EXPORT_BPJS_PCARE_KESADARAN_EXCLUDING_IDS = '[ENTITY] Export BpjsPcareKesadaranModels excluding Ids',
	EXPORT_BPJS_PCARE_KESADARAN_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcareKesadaranModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_KESADARAN_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcareKesadaranModel excluding Ids failed',

	COUNT_BPJS_PCARE_KESADARANS = '[ENTITY] Fetch number of BpjsPcareKesadaranModel records',
	COUNT_BPJS_PCARE_KESADARANS_OK = '[ENTITY] Fetch number of BpjsPcareKesadaranModel records successfully ',
	COUNT_BPJS_PCARE_KESADARANS_FAIL = '[ENTITY] Fetch number of BpjsPcareKesadaranModel records failed',

	IMPORT_BPJS_PCARE_KESADARANS = '[ENTITY] Import BpjsPcareKesadaranModels',
	IMPORT_BPJS_PCARE_KESADARANS_OK = '[ENTITY] Import BpjsPcareKesadaranModels successfully',
	IMPORT_BPJS_PCARE_KESADARANS_FAIL = '[ENTITY] Import BpjsPcareKesadaranModels fail',


	INITIALISE_BPJS_PCARE_KESADARAN_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcareKesadaranModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcareKesadaranAction implements Action {
	readonly className: string = 'BpjsPcareKesadaranModel';

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

export class BpjsPcareKesadaranAction extends BaseBpjsPcareKesadaranAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareKesadaranAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareKesadaranAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareKesadaranModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareKesadaranAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareKesadaranAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareKesadaranAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareKesadaranAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareKesadaranAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareKesadaranAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareKesadaranAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareKesadaranAction here] end
}

export class BpjsPcareKesadaranActionOK extends BaseBpjsPcareKesadaranAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareKesadaranActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareKesadaranActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareKesadaranModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareKesadaranActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareKesadaranActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcareKesadaranModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareKesadaranActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareKesadaranActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareKesadaranActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareKesadaranActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareKesadaranActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareKesadaranActionOK here] end
}

export class BpjsPcareKesadaranActionFail extends BaseBpjsPcareKesadaranAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareKesadaranActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareKesadaranActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcareKesadaranModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareKesadaranActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareKesadaranActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareKesadaranActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareKesadaranActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareKesadaranActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareKesadaranActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareKesadaranActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareKesadaranActionFail here] end
}

export function isBpjsPcareKesadaranModelAction(e: any): e is BaseBpjsPcareKesadaranAction {
	return Object.values(BpjsPcareKesadaranModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
