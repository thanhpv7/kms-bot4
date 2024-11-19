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
import {BpjsSEPInternalDataModel} from './bpjs_sep_internal_data.model';
import {BpjsSEPInternalDataModelAudit} from './bpjs_sep_internal_data.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS SEP Internal Data model actions to be dispatched by NgRx.
 */
export enum BpjsSEPInternalDataModelActionTypes {
	CREATE_BPJS_SEP_INTERNAL_DATA = '[ENTITY] Create BpjsSEPInternalDataModel',
	CREATE_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Create BpjsSEPInternalDataModel successfully',
	CREATE_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Create BpjsSEPInternalDataModel failed',

	CREATE_ALL_BPJS_SEP_INTERNAL_DATA = '[ENTITY] Create All BpjsSEPInternalDataModel',
	CREATE_ALL_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Create All BpjsSEPInternalDataModel successfully',
	CREATE_ALL_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Create All BpjsSEPInternalDataModel failed',

	DELETE_BPJS_SEP_INTERNAL_DATA = '[ENTITY] Delete BpjsSEPInternalDataModel',
	DELETE_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Delete BpjsSEPInternalDataModel successfully',
	DELETE_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Delete BpjsSEPInternalDataModel failed',


	DELETE_BPJS_SEP_INTERNAL_DATA_EXCLUDING_IDS = '[ENTITY] Delete BpjsSEPInternalDataModels Excluding Ids',
	DELETE_BPJS_SEP_INTERNAL_DATA_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsSEPInternalDataModels Excluding Ids successfully',
	DELETE_BPJS_SEP_INTERNAL_DATA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsSEPInternalDataModels Excluding Ids failed',

	DELETE_ALL_BPJS_SEP_INTERNAL_DATA = '[ENTITY] Delete all BpjsSEPInternalDataModels',
	DELETE_ALL_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Delete all BpjsSEPInternalDataModels successfully',
	DELETE_ALL_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Delete all BpjsSEPInternalDataModels failed',

	UPDATE_BPJS_SEP_INTERNAL_DATA = '[ENTITY] Update BpjsSEPInternalDataModel',
	UPDATE_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Update BpjsSEPInternalDataModel successfully',
	UPDATE_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Update BpjsSEPInternalDataModel failed',

	UPDATE_ALL_BPJS_SEP_INTERNAL_DATA = '[ENTITY] Update all BpjsSEPInternalDataModel',
	UPDATE_ALL_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Update all BpjsSEPInternalDataModel successfully',
	UPDATE_ALL_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Update all BpjsSEPInternalDataModel failed',

	FETCH_BPJS_SEP_INTERNAL_DATA= '[ENTITY] Fetch BpjsSEPInternalDataModel',
	FETCH_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Fetch BpjsSEPInternalDataModel successfully',
	FETCH_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Fetch BpjsSEPInternalDataModel failed',

	FETCH_BPJS_SEP_INTERNAL_DATA_AUDIT= '[ENTITY] Fetch BpjsSEPInternalDataModel audit',
	FETCH_BPJS_SEP_INTERNAL_DATA_AUDIT_OK = '[ENTITY] Fetch BpjsSEPInternalDataModel audit successfully',
	FETCH_BPJS_SEP_INTERNAL_DATA_AUDIT_FAIL = '[ENTITY] Fetch BpjsSEPInternalDataModel audit failed',

	FETCH_BPJS_SEP_INTERNAL_DATA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsSEPInternalDataModel audits by entity id',
	FETCH_BPJS_SEP_INTERNAL_DATA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsSEPInternalDataModel audits by entity id successfully',
	FETCH_BPJS_SEP_INTERNAL_DATA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsSEPInternalDataModel audits by entity id failed',

	FETCH_ALL_BPJS_SEP_INTERNAL_DATA = '[ENTITY] Fetch all BpjsSEPInternalDataModel',
	FETCH_ALL_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Fetch all BpjsSEPInternalDataModel successfully',
	FETCH_ALL_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Fetch all BpjsSEPInternalDataModel failed',

	FETCH_BPJS_SEP_INTERNAL_DATA_WITH_QUERY = '[ENTITY] Fetch BpjsSEPInternalDataModel with query',
	FETCH_BPJS_SEP_INTERNAL_DATA_WITH_QUERY_OK = '[ENTITY] Fetch BpjsSEPInternalDataModel with query successfully',
	FETCH_BPJS_SEP_INTERNAL_DATA_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsSEPInternalDataModel with query failed',

	FETCH_LAST_BPJS_SEP_INTERNAL_DATA_WITH_QUERY = '[ENTITY] Fetch last BpjsSEPInternalDataModel with query',
	FETCH_LAST_BPJS_SEP_INTERNAL_DATA_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsSEPInternalDataModel with query successfully',
	FETCH_LAST_BPJS_SEP_INTERNAL_DATA_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsSEPInternalDataModel with query failed',

	EXPORT_BPJS_SEP_INTERNAL_DATA = '[ENTITY] Export BpjsSEPInternalDataModel',
	EXPORT_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Export BpjsSEPInternalDataModel successfully',
	EXPORT_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Export BpjsSEPInternalDataModel failed',

	EXPORT_ALL_BPJS_SEP_INTERNAL_DATA = '[ENTITY] Export All BpjsSEPInternalDataModels',
	EXPORT_ALL_BPJS_SEP_INTERNAL_DATA_OK = '[ENTITY] Export All BpjsSEPInternalDataModels successfully',
	EXPORT_ALL_BPJS_SEP_INTERNAL_DATA_FAIL = '[ENTITY] Export All BpjsSEPInternalDataModels failed',

	EXPORT_BPJS_SEP_INTERNAL_DATA_EXCLUDING_IDS = '[ENTITY] Export BpjsSEPInternalDataModels excluding Ids',
	EXPORT_BPJS_SEP_INTERNAL_DATA_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsSEPInternalDataModel excluding Ids successfully',
	EXPORT_BPJS_SEP_INTERNAL_DATA_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsSEPInternalDataModel excluding Ids failed',

	COUNT_BPJS_SEP_INTERNAL_DATAS = '[ENTITY] Fetch number of BpjsSEPInternalDataModel records',
	COUNT_BPJS_SEP_INTERNAL_DATAS_OK = '[ENTITY] Fetch number of BpjsSEPInternalDataModel records successfully ',
	COUNT_BPJS_SEP_INTERNAL_DATAS_FAIL = '[ENTITY] Fetch number of BpjsSEPInternalDataModel records failed',

	IMPORT_BPJS_SEP_INTERNAL_DATAS = '[ENTITY] Import BpjsSEPInternalDataModels',
	IMPORT_BPJS_SEP_INTERNAL_DATAS_OK = '[ENTITY] Import BpjsSEPInternalDataModels successfully',
	IMPORT_BPJS_SEP_INTERNAL_DATAS_FAIL = '[ENTITY] Import BpjsSEPInternalDataModels fail',


	INITIALISE_BPJS_SEP_INTERNAL_DATA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsSEPInternalDataModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsSEPInternalDataAction implements Action {
	readonly className: string = 'BpjsSEPInternalDataModel';

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

export class BpjsSEPInternalDataAction extends BaseBpjsSEPInternalDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPInternalDataAction here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPInternalDataAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSEPInternalDataModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPInternalDataAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPInternalDataAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPInternalDataAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPInternalDataAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPInternalDataAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPInternalDataAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPInternalDataAction here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPInternalDataAction here] end
}

export class BpjsSEPInternalDataActionOK extends BaseBpjsSEPInternalDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPInternalDataActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPInternalDataActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSEPInternalDataModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPInternalDataActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPInternalDataActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsSEPInternalDataModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPInternalDataActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPInternalDataActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPInternalDataActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPInternalDataActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPInternalDataActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPInternalDataActionOK here] end
}

export class BpjsSEPInternalDataActionFail extends BaseBpjsSEPInternalDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPInternalDataActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPInternalDataActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsSEPInternalDataModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPInternalDataActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPInternalDataActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPInternalDataActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPInternalDataActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPInternalDataActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPInternalDataActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPInternalDataActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPInternalDataActionFail here] end
}

export function isBpjsSEPInternalDataModelAction(e: any): e is BaseBpjsSEPInternalDataAction {
	return Object.values(BpjsSEPInternalDataModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
