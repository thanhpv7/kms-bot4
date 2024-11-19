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
import {PcareDokterModel} from './pcare_dokter.model';
import {PcareDokterModelAudit} from './pcare_dokter.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Dokter model actions to be dispatched by NgRx.
 */
export enum PcareDokterModelActionTypes {
	CREATE_PCARE_DOKTER = '[ENTITY] Create PcareDokterModel',
	CREATE_PCARE_DOKTER_OK = '[ENTITY] Create PcareDokterModel successfully',
	CREATE_PCARE_DOKTER_FAIL = '[ENTITY] Create PcareDokterModel failed',

	CREATE_ALL_PCARE_DOKTER = '[ENTITY] Create All PcareDokterModel',
	CREATE_ALL_PCARE_DOKTER_OK = '[ENTITY] Create All PcareDokterModel successfully',
	CREATE_ALL_PCARE_DOKTER_FAIL = '[ENTITY] Create All PcareDokterModel failed',

	DELETE_PCARE_DOKTER = '[ENTITY] Delete PcareDokterModel',
	DELETE_PCARE_DOKTER_OK = '[ENTITY] Delete PcareDokterModel successfully',
	DELETE_PCARE_DOKTER_FAIL = '[ENTITY] Delete PcareDokterModel failed',


	DELETE_PCARE_DOKTER_EXCLUDING_IDS = '[ENTITY] Delete PcareDokterModels Excluding Ids',
	DELETE_PCARE_DOKTER_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareDokterModels Excluding Ids successfully',
	DELETE_PCARE_DOKTER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareDokterModels Excluding Ids failed',

	DELETE_ALL_PCARE_DOKTER = '[ENTITY] Delete all PcareDokterModels',
	DELETE_ALL_PCARE_DOKTER_OK = '[ENTITY] Delete all PcareDokterModels successfully',
	DELETE_ALL_PCARE_DOKTER_FAIL = '[ENTITY] Delete all PcareDokterModels failed',

	UPDATE_PCARE_DOKTER = '[ENTITY] Update PcareDokterModel',
	UPDATE_PCARE_DOKTER_OK = '[ENTITY] Update PcareDokterModel successfully',
	UPDATE_PCARE_DOKTER_FAIL = '[ENTITY] Update PcareDokterModel failed',

	UPDATE_ALL_PCARE_DOKTER = '[ENTITY] Update all PcareDokterModel',
	UPDATE_ALL_PCARE_DOKTER_OK = '[ENTITY] Update all PcareDokterModel successfully',
	UPDATE_ALL_PCARE_DOKTER_FAIL = '[ENTITY] Update all PcareDokterModel failed',

	FETCH_PCARE_DOKTER= '[ENTITY] Fetch PcareDokterModel',
	FETCH_PCARE_DOKTER_OK = '[ENTITY] Fetch PcareDokterModel successfully',
	FETCH_PCARE_DOKTER_FAIL = '[ENTITY] Fetch PcareDokterModel failed',

	FETCH_PCARE_DOKTER_AUDIT= '[ENTITY] Fetch PcareDokterModel audit',
	FETCH_PCARE_DOKTER_AUDIT_OK = '[ENTITY] Fetch PcareDokterModel audit successfully',
	FETCH_PCARE_DOKTER_AUDIT_FAIL = '[ENTITY] Fetch PcareDokterModel audit failed',

	FETCH_PCARE_DOKTER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareDokterModel audits by entity id',
	FETCH_PCARE_DOKTER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareDokterModel audits by entity id successfully',
	FETCH_PCARE_DOKTER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareDokterModel audits by entity id failed',

	FETCH_ALL_PCARE_DOKTER = '[ENTITY] Fetch all PcareDokterModel',
	FETCH_ALL_PCARE_DOKTER_OK = '[ENTITY] Fetch all PcareDokterModel successfully',
	FETCH_ALL_PCARE_DOKTER_FAIL = '[ENTITY] Fetch all PcareDokterModel failed',

	FETCH_PCARE_DOKTER_WITH_QUERY = '[ENTITY] Fetch PcareDokterModel with query',
	FETCH_PCARE_DOKTER_WITH_QUERY_OK = '[ENTITY] Fetch PcareDokterModel with query successfully',
	FETCH_PCARE_DOKTER_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareDokterModel with query failed',

	FETCH_LAST_PCARE_DOKTER_WITH_QUERY = '[ENTITY] Fetch last PcareDokterModel with query',
	FETCH_LAST_PCARE_DOKTER_WITH_QUERY_OK = '[ENTITY] Fetch last PcareDokterModel with query successfully',
	FETCH_LAST_PCARE_DOKTER_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareDokterModel with query failed',

	EXPORT_PCARE_DOKTER = '[ENTITY] Export PcareDokterModel',
	EXPORT_PCARE_DOKTER_OK = '[ENTITY] Export PcareDokterModel successfully',
	EXPORT_PCARE_DOKTER_FAIL = '[ENTITY] Export PcareDokterModel failed',

	EXPORT_ALL_PCARE_DOKTER = '[ENTITY] Export All PcareDokterModels',
	EXPORT_ALL_PCARE_DOKTER_OK = '[ENTITY] Export All PcareDokterModels successfully',
	EXPORT_ALL_PCARE_DOKTER_FAIL = '[ENTITY] Export All PcareDokterModels failed',

	EXPORT_PCARE_DOKTER_EXCLUDING_IDS = '[ENTITY] Export PcareDokterModels excluding Ids',
	EXPORT_PCARE_DOKTER_EXCLUDING_IDS_OK = '[ENTITY] Export PcareDokterModel excluding Ids successfully',
	EXPORT_PCARE_DOKTER_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareDokterModel excluding Ids failed',

	COUNT_PCARE_DOKTERS = '[ENTITY] Fetch number of PcareDokterModel records',
	COUNT_PCARE_DOKTERS_OK = '[ENTITY] Fetch number of PcareDokterModel records successfully ',
	COUNT_PCARE_DOKTERS_FAIL = '[ENTITY] Fetch number of PcareDokterModel records failed',

	IMPORT_PCARE_DOKTERS = '[ENTITY] Import PcareDokterModels',
	IMPORT_PCARE_DOKTERS_OK = '[ENTITY] Import PcareDokterModels successfully',
	IMPORT_PCARE_DOKTERS_FAIL = '[ENTITY] Import PcareDokterModels fail',


	INITIALISE_PCARE_DOKTER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareDokterModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareDokterAction implements Action {
	readonly className: string = 'PcareDokterModel';

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

export class PcareDokterAction extends BasePcareDokterAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareDokterAction here] off begin
	// % protected region % [Add any additional class fields for PcareDokterAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareDokterModel>,
		// % protected region % [Add any additional constructor parameters for PcareDokterAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareDokterAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareDokterAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareDokterAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareDokterAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareDokterAction here] end
	}

	// % protected region % [Add any additional class methods for PcareDokterAction here] off begin
	// % protected region % [Add any additional class methods for PcareDokterAction here] end
}

export class PcareDokterActionOK extends BasePcareDokterAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareDokterActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareDokterActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareDokterModel>,
		// % protected region % [Add any additional constructor parameters for PcareDokterActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareDokterActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareDokterModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareDokterActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareDokterActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareDokterActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareDokterActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareDokterActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareDokterActionOK here] end
}

export class PcareDokterActionFail extends BasePcareDokterAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareDokterActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareDokterActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareDokterModel>,
		// % protected region % [Add any additional constructor parameters for PcareDokterActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareDokterActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareDokterActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareDokterActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareDokterActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareDokterActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareDokterActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareDokterActionFail here] end
}

export function isPcareDokterModelAction(e: any): e is BasePcareDokterAction {
	return Object.values(PcareDokterModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
