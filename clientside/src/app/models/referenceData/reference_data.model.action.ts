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
import {ReferenceDataModel} from './reference_data.model';
import {ReferenceDataModelAudit} from './reference_data.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Reference Data model actions to be dispatched by NgRx.
 */
export enum ReferenceDataModelActionTypes {
	CREATE_REFERENCE_DATA = '[ENTITY] Create ReferenceDataModel',
	CREATE_REFERENCE_DATA_OK = '[ENTITY] Create ReferenceDataModel successfully',
	CREATE_REFERENCE_DATA_FAIL = '[ENTITY] Create ReferenceDataModel failed',

	CREATE_ALL_REFERENCE_DATA = '[ENTITY] Create All ReferenceDataModel',
	CREATE_ALL_REFERENCE_DATA_OK = '[ENTITY] Create All ReferenceDataModel successfully',
	CREATE_ALL_REFERENCE_DATA_FAIL = '[ENTITY] Create All ReferenceDataModel failed',

	DELETE_REFERENCE_DATA = '[ENTITY] Delete ReferenceDataModel',
	DELETE_REFERENCE_DATA_OK = '[ENTITY] Delete ReferenceDataModel successfully',
	DELETE_REFERENCE_DATA_FAIL = '[ENTITY] Delete ReferenceDataModel failed',


	DELETE_REFERENCE_DATA_EXCLUDING_IDS = '[ENTITY] Delete ReferenceDataModels Excluding Ids',
	DELETE_REFERENCE_DATA_EXCLUDING_IDS_OK = '[ENTITY] Delete ReferenceDataModels Excluding Ids successfully',
	DELETE_REFERENCE_DATA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ReferenceDataModels Excluding Ids failed',

	DELETE_ALL_REFERENCE_DATA = '[ENTITY] Delete all ReferenceDataModels',
	DELETE_ALL_REFERENCE_DATA_OK = '[ENTITY] Delete all ReferenceDataModels successfully',
	DELETE_ALL_REFERENCE_DATA_FAIL = '[ENTITY] Delete all ReferenceDataModels failed',

	UPDATE_REFERENCE_DATA = '[ENTITY] Update ReferenceDataModel',
	UPDATE_REFERENCE_DATA_OK = '[ENTITY] Update ReferenceDataModel successfully',
	UPDATE_REFERENCE_DATA_FAIL = '[ENTITY] Update ReferenceDataModel failed',

	UPDATE_ALL_REFERENCE_DATA = '[ENTITY] Update all ReferenceDataModel',
	UPDATE_ALL_REFERENCE_DATA_OK = '[ENTITY] Update all ReferenceDataModel successfully',
	UPDATE_ALL_REFERENCE_DATA_FAIL = '[ENTITY] Update all ReferenceDataModel failed',

	FETCH_REFERENCE_DATA= '[ENTITY] Fetch ReferenceDataModel',
	FETCH_REFERENCE_DATA_OK = '[ENTITY] Fetch ReferenceDataModel successfully',
	FETCH_REFERENCE_DATA_FAIL = '[ENTITY] Fetch ReferenceDataModel failed',

	FETCH_REFERENCE_DATA_AUDIT= '[ENTITY] Fetch ReferenceDataModel audit',
	FETCH_REFERENCE_DATA_AUDIT_OK = '[ENTITY] Fetch ReferenceDataModel audit successfully',
	FETCH_REFERENCE_DATA_AUDIT_FAIL = '[ENTITY] Fetch ReferenceDataModel audit failed',

	FETCH_REFERENCE_DATA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ReferenceDataModel audits by entity id',
	FETCH_REFERENCE_DATA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ReferenceDataModel audits by entity id successfully',
	FETCH_REFERENCE_DATA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ReferenceDataModel audits by entity id failed',

	FETCH_ALL_REFERENCE_DATA = '[ENTITY] Fetch all ReferenceDataModel',
	FETCH_ALL_REFERENCE_DATA_OK = '[ENTITY] Fetch all ReferenceDataModel successfully',
	FETCH_ALL_REFERENCE_DATA_FAIL = '[ENTITY] Fetch all ReferenceDataModel failed',

	FETCH_REFERENCE_DATA_WITH_QUERY = '[ENTITY] Fetch ReferenceDataModel with query',
	FETCH_REFERENCE_DATA_WITH_QUERY_OK = '[ENTITY] Fetch ReferenceDataModel with query successfully',
	FETCH_REFERENCE_DATA_WITH_QUERY_FAIL = '[ENTITY] Fetch ReferenceDataModel with query failed',

	FETCH_LAST_REFERENCE_DATA_WITH_QUERY = '[ENTITY] Fetch last ReferenceDataModel with query',
	FETCH_LAST_REFERENCE_DATA_WITH_QUERY_OK = '[ENTITY] Fetch last ReferenceDataModel with query successfully',
	FETCH_LAST_REFERENCE_DATA_WITH_QUERY_FAIL = '[ENTITY] Fetch last ReferenceDataModel with query failed',

	EXPORT_REFERENCE_DATA = '[ENTITY] Export ReferenceDataModel',
	EXPORT_REFERENCE_DATA_OK = '[ENTITY] Export ReferenceDataModel successfully',
	EXPORT_REFERENCE_DATA_FAIL = '[ENTITY] Export ReferenceDataModel failed',

	EXPORT_ALL_REFERENCE_DATA = '[ENTITY] Export All ReferenceDataModels',
	EXPORT_ALL_REFERENCE_DATA_OK = '[ENTITY] Export All ReferenceDataModels successfully',
	EXPORT_ALL_REFERENCE_DATA_FAIL = '[ENTITY] Export All ReferenceDataModels failed',

	EXPORT_REFERENCE_DATA_EXCLUDING_IDS = '[ENTITY] Export ReferenceDataModels excluding Ids',
	EXPORT_REFERENCE_DATA_EXCLUDING_IDS_OK = '[ENTITY] Export ReferenceDataModel excluding Ids successfully',
	EXPORT_REFERENCE_DATA_EXCLUDING_IDS_FAIL = '[ENTITY] Export ReferenceDataModel excluding Ids failed',

	COUNT_REFERENCE_DATAS = '[ENTITY] Fetch number of ReferenceDataModel records',
	COUNT_REFERENCE_DATAS_OK = '[ENTITY] Fetch number of ReferenceDataModel records successfully ',
	COUNT_REFERENCE_DATAS_FAIL = '[ENTITY] Fetch number of ReferenceDataModel records failed',

	IMPORT_REFERENCE_DATAS = '[ENTITY] Import ReferenceDataModels',
	IMPORT_REFERENCE_DATAS_OK = '[ENTITY] Import ReferenceDataModels successfully',
	IMPORT_REFERENCE_DATAS_FAIL = '[ENTITY] Import ReferenceDataModels fail',


	INITIALISE_REFERENCE_DATA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ReferenceDataModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseReferenceDataAction implements Action {
	readonly className: string = 'ReferenceDataModel';

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

export class ReferenceDataAction extends BaseReferenceDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReferenceDataAction here] off begin
	// % protected region % [Add any additional class fields for ReferenceDataAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ReferenceDataModel>,
		// % protected region % [Add any additional constructor parameters for ReferenceDataAction here] off begin
		// % protected region % [Add any additional constructor parameters for ReferenceDataAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReferenceDataAction here] off begin
			// % protected region % [Add any additional constructor arguments for ReferenceDataAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReferenceDataAction here] off begin
		// % protected region % [Add any additional constructor logic for ReferenceDataAction here] end
	}

	// % protected region % [Add any additional class methods for ReferenceDataAction here] off begin
	// % protected region % [Add any additional class methods for ReferenceDataAction here] end
}

export class ReferenceDataActionOK extends BaseReferenceDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReferenceDataActionOK here] off begin
	// % protected region % [Add any additional class fields for ReferenceDataActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ReferenceDataModel>,
		// % protected region % [Add any additional constructor parameters for ReferenceDataActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ReferenceDataActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ReferenceDataModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReferenceDataActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ReferenceDataActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReferenceDataActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ReferenceDataActionOK here] end
	}

	// % protected region % [Add any additional class methods for ReferenceDataActionOK here] off begin
	// % protected region % [Add any additional class methods for ReferenceDataActionOK here] end
}

export class ReferenceDataActionFail extends BaseReferenceDataAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ReferenceDataActionFail here] off begin
	// % protected region % [Add any additional class fields for ReferenceDataActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ReferenceDataModel>,
		// % protected region % [Add any additional constructor parameters for ReferenceDataActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ReferenceDataActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ReferenceDataActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ReferenceDataActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ReferenceDataActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ReferenceDataActionFail here] end
	}

	// % protected region % [Add any additional class methods for ReferenceDataActionFail here] off begin
	// % protected region % [Add any additional class methods for ReferenceDataActionFail here] end
}

export function isReferenceDataModelAction(e: any): e is BaseReferenceDataAction {
	return Object.values(ReferenceDataModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
