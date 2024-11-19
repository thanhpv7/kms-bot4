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
import {NhisGDRGModel} from './nhis_gdrg.model';
import {NhisGDRGModelAudit} from './nhis_gdrg.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of NHIS GDRG model actions to be dispatched by NgRx.
 */
export enum NhisGDRGModelActionTypes {
	CREATE_NHIS_GDRG = '[ENTITY] Create NhisGDRGModel',
	CREATE_NHIS_GDRG_OK = '[ENTITY] Create NhisGDRGModel successfully',
	CREATE_NHIS_GDRG_FAIL = '[ENTITY] Create NhisGDRGModel failed',

	CREATE_ALL_NHIS_GDRG = '[ENTITY] Create All NhisGDRGModel',
	CREATE_ALL_NHIS_GDRG_OK = '[ENTITY] Create All NhisGDRGModel successfully',
	CREATE_ALL_NHIS_GDRG_FAIL = '[ENTITY] Create All NhisGDRGModel failed',

	DELETE_NHIS_GDRG = '[ENTITY] Delete NhisGDRGModel',
	DELETE_NHIS_GDRG_OK = '[ENTITY] Delete NhisGDRGModel successfully',
	DELETE_NHIS_GDRG_FAIL = '[ENTITY] Delete NhisGDRGModel failed',


	DELETE_NHIS_GDRG_EXCLUDING_IDS = '[ENTITY] Delete NhisGDRGModels Excluding Ids',
	DELETE_NHIS_GDRG_EXCLUDING_IDS_OK = '[ENTITY] Delete NhisGDRGModels Excluding Ids successfully',
	DELETE_NHIS_GDRG_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NhisGDRGModels Excluding Ids failed',

	DELETE_ALL_NHIS_GDRG = '[ENTITY] Delete all NhisGDRGModels',
	DELETE_ALL_NHIS_GDRG_OK = '[ENTITY] Delete all NhisGDRGModels successfully',
	DELETE_ALL_NHIS_GDRG_FAIL = '[ENTITY] Delete all NhisGDRGModels failed',

	UPDATE_NHIS_GDRG = '[ENTITY] Update NhisGDRGModel',
	UPDATE_NHIS_GDRG_OK = '[ENTITY] Update NhisGDRGModel successfully',
	UPDATE_NHIS_GDRG_FAIL = '[ENTITY] Update NhisGDRGModel failed',

	UPDATE_ALL_NHIS_GDRG = '[ENTITY] Update all NhisGDRGModel',
	UPDATE_ALL_NHIS_GDRG_OK = '[ENTITY] Update all NhisGDRGModel successfully',
	UPDATE_ALL_NHIS_GDRG_FAIL = '[ENTITY] Update all NhisGDRGModel failed',

	FETCH_NHIS_GDRG= '[ENTITY] Fetch NhisGDRGModel',
	FETCH_NHIS_GDRG_OK = '[ENTITY] Fetch NhisGDRGModel successfully',
	FETCH_NHIS_GDRG_FAIL = '[ENTITY] Fetch NhisGDRGModel failed',

	FETCH_NHIS_GDRG_AUDIT= '[ENTITY] Fetch NhisGDRGModel audit',
	FETCH_NHIS_GDRG_AUDIT_OK = '[ENTITY] Fetch NhisGDRGModel audit successfully',
	FETCH_NHIS_GDRG_AUDIT_FAIL = '[ENTITY] Fetch NhisGDRGModel audit failed',

	FETCH_NHIS_GDRG_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NhisGDRGModel audits by entity id',
	FETCH_NHIS_GDRG_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NhisGDRGModel audits by entity id successfully',
	FETCH_NHIS_GDRG_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NhisGDRGModel audits by entity id failed',

	FETCH_ALL_NHIS_GDRG = '[ENTITY] Fetch all NhisGDRGModel',
	FETCH_ALL_NHIS_GDRG_OK = '[ENTITY] Fetch all NhisGDRGModel successfully',
	FETCH_ALL_NHIS_GDRG_FAIL = '[ENTITY] Fetch all NhisGDRGModel failed',

	FETCH_NHIS_GDRG_WITH_QUERY = '[ENTITY] Fetch NhisGDRGModel with query',
	FETCH_NHIS_GDRG_WITH_QUERY_OK = '[ENTITY] Fetch NhisGDRGModel with query successfully',
	FETCH_NHIS_GDRG_WITH_QUERY_FAIL = '[ENTITY] Fetch NhisGDRGModel with query failed',

	FETCH_LAST_NHIS_GDRG_WITH_QUERY = '[ENTITY] Fetch last NhisGDRGModel with query',
	FETCH_LAST_NHIS_GDRG_WITH_QUERY_OK = '[ENTITY] Fetch last NhisGDRGModel with query successfully',
	FETCH_LAST_NHIS_GDRG_WITH_QUERY_FAIL = '[ENTITY] Fetch last NhisGDRGModel with query failed',

	EXPORT_NHIS_GDRG = '[ENTITY] Export NhisGDRGModel',
	EXPORT_NHIS_GDRG_OK = '[ENTITY] Export NhisGDRGModel successfully',
	EXPORT_NHIS_GDRG_FAIL = '[ENTITY] Export NhisGDRGModel failed',

	EXPORT_ALL_NHIS_GDRG = '[ENTITY] Export All NhisGDRGModels',
	EXPORT_ALL_NHIS_GDRG_OK = '[ENTITY] Export All NhisGDRGModels successfully',
	EXPORT_ALL_NHIS_GDRG_FAIL = '[ENTITY] Export All NhisGDRGModels failed',

	EXPORT_NHIS_GDRG_EXCLUDING_IDS = '[ENTITY] Export NhisGDRGModels excluding Ids',
	EXPORT_NHIS_GDRG_EXCLUDING_IDS_OK = '[ENTITY] Export NhisGDRGModel excluding Ids successfully',
	EXPORT_NHIS_GDRG_EXCLUDING_IDS_FAIL = '[ENTITY] Export NhisGDRGModel excluding Ids failed',

	COUNT_NHIS_GDRGS = '[ENTITY] Fetch number of NhisGDRGModel records',
	COUNT_NHIS_GDRGS_OK = '[ENTITY] Fetch number of NhisGDRGModel records successfully ',
	COUNT_NHIS_GDRGS_FAIL = '[ENTITY] Fetch number of NhisGDRGModel records failed',

	IMPORT_NHIS_GDRGS = '[ENTITY] Import NhisGDRGModels',
	IMPORT_NHIS_GDRGS_OK = '[ENTITY] Import NhisGDRGModels successfully',
	IMPORT_NHIS_GDRGS_FAIL = '[ENTITY] Import NhisGDRGModels fail',


	INITIALISE_NHIS_GDRG_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NhisGDRGModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNhisGDRGAction implements Action {
	readonly className: string = 'NhisGDRGModel';

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

export class NhisGDRGAction extends BaseNhisGDRGAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisGDRGAction here] off begin
	// % protected region % [Add any additional class fields for NhisGDRGAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisGDRGModel>,
		// % protected region % [Add any additional constructor parameters for NhisGDRGAction here] off begin
		// % protected region % [Add any additional constructor parameters for NhisGDRGAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisGDRGAction here] off begin
			// % protected region % [Add any additional constructor arguments for NhisGDRGAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisGDRGAction here] off begin
		// % protected region % [Add any additional constructor logic for NhisGDRGAction here] end
	}

	// % protected region % [Add any additional class methods for NhisGDRGAction here] off begin
	// % protected region % [Add any additional class methods for NhisGDRGAction here] end
}

export class NhisGDRGActionOK extends BaseNhisGDRGAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisGDRGActionOK here] off begin
	// % protected region % [Add any additional class fields for NhisGDRGActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisGDRGModel>,
		// % protected region % [Add any additional constructor parameters for NhisGDRGActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NhisGDRGActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NhisGDRGModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisGDRGActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NhisGDRGActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisGDRGActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NhisGDRGActionOK here] end
	}

	// % protected region % [Add any additional class methods for NhisGDRGActionOK here] off begin
	// % protected region % [Add any additional class methods for NhisGDRGActionOK here] end
}

export class NhisGDRGActionFail extends BaseNhisGDRGAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisGDRGActionFail here] off begin
	// % protected region % [Add any additional class fields for NhisGDRGActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NhisGDRGModel>,
		// % protected region % [Add any additional constructor parameters for NhisGDRGActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NhisGDRGActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisGDRGActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NhisGDRGActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisGDRGActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NhisGDRGActionFail here] end
	}

	// % protected region % [Add any additional class methods for NhisGDRGActionFail here] off begin
	// % protected region % [Add any additional class methods for NhisGDRGActionFail here] end
}

export function isNhisGDRGModelAction(e: any): e is BaseNhisGDRGAction {
	return Object.values(NhisGDRGModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
