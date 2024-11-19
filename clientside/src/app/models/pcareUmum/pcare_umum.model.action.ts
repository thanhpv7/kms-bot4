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
import {PcareUmumModel} from './pcare_umum.model';
import {PcareUmumModelAudit} from './pcare_umum.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Umum model actions to be dispatched by NgRx.
 */
export enum PcareUmumModelActionTypes {
	CREATE_PCARE_UMUM = '[ENTITY] Create PcareUmumModel',
	CREATE_PCARE_UMUM_OK = '[ENTITY] Create PcareUmumModel successfully',
	CREATE_PCARE_UMUM_FAIL = '[ENTITY] Create PcareUmumModel failed',

	CREATE_ALL_PCARE_UMUM = '[ENTITY] Create All PcareUmumModel',
	CREATE_ALL_PCARE_UMUM_OK = '[ENTITY] Create All PcareUmumModel successfully',
	CREATE_ALL_PCARE_UMUM_FAIL = '[ENTITY] Create All PcareUmumModel failed',

	DELETE_PCARE_UMUM = '[ENTITY] Delete PcareUmumModel',
	DELETE_PCARE_UMUM_OK = '[ENTITY] Delete PcareUmumModel successfully',
	DELETE_PCARE_UMUM_FAIL = '[ENTITY] Delete PcareUmumModel failed',


	DELETE_PCARE_UMUM_EXCLUDING_IDS = '[ENTITY] Delete PcareUmumModels Excluding Ids',
	DELETE_PCARE_UMUM_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareUmumModels Excluding Ids successfully',
	DELETE_PCARE_UMUM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareUmumModels Excluding Ids failed',

	DELETE_ALL_PCARE_UMUM = '[ENTITY] Delete all PcareUmumModels',
	DELETE_ALL_PCARE_UMUM_OK = '[ENTITY] Delete all PcareUmumModels successfully',
	DELETE_ALL_PCARE_UMUM_FAIL = '[ENTITY] Delete all PcareUmumModels failed',

	UPDATE_PCARE_UMUM = '[ENTITY] Update PcareUmumModel',
	UPDATE_PCARE_UMUM_OK = '[ENTITY] Update PcareUmumModel successfully',
	UPDATE_PCARE_UMUM_FAIL = '[ENTITY] Update PcareUmumModel failed',

	UPDATE_ALL_PCARE_UMUM = '[ENTITY] Update all PcareUmumModel',
	UPDATE_ALL_PCARE_UMUM_OK = '[ENTITY] Update all PcareUmumModel successfully',
	UPDATE_ALL_PCARE_UMUM_FAIL = '[ENTITY] Update all PcareUmumModel failed',

	FETCH_PCARE_UMUM= '[ENTITY] Fetch PcareUmumModel',
	FETCH_PCARE_UMUM_OK = '[ENTITY] Fetch PcareUmumModel successfully',
	FETCH_PCARE_UMUM_FAIL = '[ENTITY] Fetch PcareUmumModel failed',

	FETCH_PCARE_UMUM_AUDIT= '[ENTITY] Fetch PcareUmumModel audit',
	FETCH_PCARE_UMUM_AUDIT_OK = '[ENTITY] Fetch PcareUmumModel audit successfully',
	FETCH_PCARE_UMUM_AUDIT_FAIL = '[ENTITY] Fetch PcareUmumModel audit failed',

	FETCH_PCARE_UMUM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareUmumModel audits by entity id',
	FETCH_PCARE_UMUM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareUmumModel audits by entity id successfully',
	FETCH_PCARE_UMUM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareUmumModel audits by entity id failed',

	FETCH_ALL_PCARE_UMUM = '[ENTITY] Fetch all PcareUmumModel',
	FETCH_ALL_PCARE_UMUM_OK = '[ENTITY] Fetch all PcareUmumModel successfully',
	FETCH_ALL_PCARE_UMUM_FAIL = '[ENTITY] Fetch all PcareUmumModel failed',

	FETCH_PCARE_UMUM_WITH_QUERY = '[ENTITY] Fetch PcareUmumModel with query',
	FETCH_PCARE_UMUM_WITH_QUERY_OK = '[ENTITY] Fetch PcareUmumModel with query successfully',
	FETCH_PCARE_UMUM_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareUmumModel with query failed',

	FETCH_LAST_PCARE_UMUM_WITH_QUERY = '[ENTITY] Fetch last PcareUmumModel with query',
	FETCH_LAST_PCARE_UMUM_WITH_QUERY_OK = '[ENTITY] Fetch last PcareUmumModel with query successfully',
	FETCH_LAST_PCARE_UMUM_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareUmumModel with query failed',

	EXPORT_PCARE_UMUM = '[ENTITY] Export PcareUmumModel',
	EXPORT_PCARE_UMUM_OK = '[ENTITY] Export PcareUmumModel successfully',
	EXPORT_PCARE_UMUM_FAIL = '[ENTITY] Export PcareUmumModel failed',

	EXPORT_ALL_PCARE_UMUM = '[ENTITY] Export All PcareUmumModels',
	EXPORT_ALL_PCARE_UMUM_OK = '[ENTITY] Export All PcareUmumModels successfully',
	EXPORT_ALL_PCARE_UMUM_FAIL = '[ENTITY] Export All PcareUmumModels failed',

	EXPORT_PCARE_UMUM_EXCLUDING_IDS = '[ENTITY] Export PcareUmumModels excluding Ids',
	EXPORT_PCARE_UMUM_EXCLUDING_IDS_OK = '[ENTITY] Export PcareUmumModel excluding Ids successfully',
	EXPORT_PCARE_UMUM_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareUmumModel excluding Ids failed',

	COUNT_PCARE_UMUMS = '[ENTITY] Fetch number of PcareUmumModel records',
	COUNT_PCARE_UMUMS_OK = '[ENTITY] Fetch number of PcareUmumModel records successfully ',
	COUNT_PCARE_UMUMS_FAIL = '[ENTITY] Fetch number of PcareUmumModel records failed',

	IMPORT_PCARE_UMUMS = '[ENTITY] Import PcareUmumModels',
	IMPORT_PCARE_UMUMS_OK = '[ENTITY] Import PcareUmumModels successfully',
	IMPORT_PCARE_UMUMS_FAIL = '[ENTITY] Import PcareUmumModels fail',


	INITIALISE_PCARE_UMUM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareUmumModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareUmumAction implements Action {
	readonly className: string = 'PcareUmumModel';

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

export class PcareUmumAction extends BasePcareUmumAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareUmumAction here] off begin
	// % protected region % [Add any additional class fields for PcareUmumAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareUmumModel>,
		// % protected region % [Add any additional constructor parameters for PcareUmumAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareUmumAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareUmumAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareUmumAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareUmumAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareUmumAction here] end
	}

	// % protected region % [Add any additional class methods for PcareUmumAction here] off begin
	// % protected region % [Add any additional class methods for PcareUmumAction here] end
}

export class PcareUmumActionOK extends BasePcareUmumAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareUmumActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareUmumActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareUmumModel>,
		// % protected region % [Add any additional constructor parameters for PcareUmumActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareUmumActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareUmumModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareUmumActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareUmumActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareUmumActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareUmumActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareUmumActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareUmumActionOK here] end
}

export class PcareUmumActionFail extends BasePcareUmumAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareUmumActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareUmumActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareUmumModel>,
		// % protected region % [Add any additional constructor parameters for PcareUmumActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareUmumActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareUmumActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareUmumActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareUmumActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareUmumActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareUmumActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareUmumActionFail here] end
}

export function isPcareUmumModelAction(e: any): e is BasePcareUmumAction {
	return Object.values(PcareUmumModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
