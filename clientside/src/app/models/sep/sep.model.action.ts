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
import {SepModel} from './sep.model';
import {SepModelAudit} from './sep.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of SEP model actions to be dispatched by NgRx.
 */
export enum SepModelActionTypes {
	CREATE_SEP = '[ENTITY] Create SepModel',
	CREATE_SEP_OK = '[ENTITY] Create SepModel successfully',
	CREATE_SEP_FAIL = '[ENTITY] Create SepModel failed',

	CREATE_ALL_SEP = '[ENTITY] Create All SepModel',
	CREATE_ALL_SEP_OK = '[ENTITY] Create All SepModel successfully',
	CREATE_ALL_SEP_FAIL = '[ENTITY] Create All SepModel failed',

	DELETE_SEP = '[ENTITY] Delete SepModel',
	DELETE_SEP_OK = '[ENTITY] Delete SepModel successfully',
	DELETE_SEP_FAIL = '[ENTITY] Delete SepModel failed',


	DELETE_SEP_EXCLUDING_IDS = '[ENTITY] Delete SepModels Excluding Ids',
	DELETE_SEP_EXCLUDING_IDS_OK = '[ENTITY] Delete SepModels Excluding Ids successfully',
	DELETE_SEP_EXCLUDING_IDS_FAIL = '[ENTITY] Delete SepModels Excluding Ids failed',

	DELETE_ALL_SEP = '[ENTITY] Delete all SepModels',
	DELETE_ALL_SEP_OK = '[ENTITY] Delete all SepModels successfully',
	DELETE_ALL_SEP_FAIL = '[ENTITY] Delete all SepModels failed',

	UPDATE_SEP = '[ENTITY] Update SepModel',
	UPDATE_SEP_OK = '[ENTITY] Update SepModel successfully',
	UPDATE_SEP_FAIL = '[ENTITY] Update SepModel failed',

	UPDATE_ALL_SEP = '[ENTITY] Update all SepModel',
	UPDATE_ALL_SEP_OK = '[ENTITY] Update all SepModel successfully',
	UPDATE_ALL_SEP_FAIL = '[ENTITY] Update all SepModel failed',

	FETCH_SEP= '[ENTITY] Fetch SepModel',
	FETCH_SEP_OK = '[ENTITY] Fetch SepModel successfully',
	FETCH_SEP_FAIL = '[ENTITY] Fetch SepModel failed',

	FETCH_SEP_AUDIT= '[ENTITY] Fetch SepModel audit',
	FETCH_SEP_AUDIT_OK = '[ENTITY] Fetch SepModel audit successfully',
	FETCH_SEP_AUDIT_FAIL = '[ENTITY] Fetch SepModel audit failed',

	FETCH_SEP_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch SepModel audits by entity id',
	FETCH_SEP_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch SepModel audits by entity id successfully',
	FETCH_SEP_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch SepModel audits by entity id failed',

	FETCH_ALL_SEP = '[ENTITY] Fetch all SepModel',
	FETCH_ALL_SEP_OK = '[ENTITY] Fetch all SepModel successfully',
	FETCH_ALL_SEP_FAIL = '[ENTITY] Fetch all SepModel failed',

	FETCH_SEP_WITH_QUERY = '[ENTITY] Fetch SepModel with query',
	FETCH_SEP_WITH_QUERY_OK = '[ENTITY] Fetch SepModel with query successfully',
	FETCH_SEP_WITH_QUERY_FAIL = '[ENTITY] Fetch SepModel with query failed',

	FETCH_LAST_SEP_WITH_QUERY = '[ENTITY] Fetch last SepModel with query',
	FETCH_LAST_SEP_WITH_QUERY_OK = '[ENTITY] Fetch last SepModel with query successfully',
	FETCH_LAST_SEP_WITH_QUERY_FAIL = '[ENTITY] Fetch last SepModel with query failed',

	EXPORT_SEP = '[ENTITY] Export SepModel',
	EXPORT_SEP_OK = '[ENTITY] Export SepModel successfully',
	EXPORT_SEP_FAIL = '[ENTITY] Export SepModel failed',

	EXPORT_ALL_SEP = '[ENTITY] Export All SepModels',
	EXPORT_ALL_SEP_OK = '[ENTITY] Export All SepModels successfully',
	EXPORT_ALL_SEP_FAIL = '[ENTITY] Export All SepModels failed',

	EXPORT_SEP_EXCLUDING_IDS = '[ENTITY] Export SepModels excluding Ids',
	EXPORT_SEP_EXCLUDING_IDS_OK = '[ENTITY] Export SepModel excluding Ids successfully',
	EXPORT_SEP_EXCLUDING_IDS_FAIL = '[ENTITY] Export SepModel excluding Ids failed',

	COUNT_SEPS = '[ENTITY] Fetch number of SepModel records',
	COUNT_SEPS_OK = '[ENTITY] Fetch number of SepModel records successfully ',
	COUNT_SEPS_FAIL = '[ENTITY] Fetch number of SepModel records failed',

	IMPORT_SEPS = '[ENTITY] Import SepModels',
	IMPORT_SEPS_OK = '[ENTITY] Import SepModels successfully',
	IMPORT_SEPS_FAIL = '[ENTITY] Import SepModels fail',


	INITIALISE_SEP_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of SepModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseSepAction implements Action {
	readonly className: string = 'SepModel';

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

export class SepAction extends BaseSepAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SepAction here] off begin
	// % protected region % [Add any additional class fields for SepAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SepModel>,
		// % protected region % [Add any additional constructor parameters for SepAction here] off begin
		// % protected region % [Add any additional constructor parameters for SepAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SepAction here] off begin
			// % protected region % [Add any additional constructor arguments for SepAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SepAction here] off begin
		// % protected region % [Add any additional constructor logic for SepAction here] end
	}

	// % protected region % [Add any additional class methods for SepAction here] off begin
	// % protected region % [Add any additional class methods for SepAction here] end
}

export class SepActionOK extends BaseSepAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SepActionOK here] off begin
	// % protected region % [Add any additional class fields for SepActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SepModel>,
		// % protected region % [Add any additional constructor parameters for SepActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for SepActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: SepModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SepActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for SepActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SepActionOK here] off begin
		// % protected region % [Add any additional constructor logic for SepActionOK here] end
	}

	// % protected region % [Add any additional class methods for SepActionOK here] off begin
	// % protected region % [Add any additional class methods for SepActionOK here] end
}

export class SepActionFail extends BaseSepAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SepActionFail here] off begin
	// % protected region % [Add any additional class fields for SepActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<SepModel>,
		// % protected region % [Add any additional constructor parameters for SepActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for SepActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SepActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for SepActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SepActionFail here] off begin
		// % protected region % [Add any additional constructor logic for SepActionFail here] end
	}

	// % protected region % [Add any additional class methods for SepActionFail here] off begin
	// % protected region % [Add any additional class methods for SepActionFail here] end
}

export function isSepModelAction(e: any): e is BaseSepAction {
	return Object.values(SepModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
