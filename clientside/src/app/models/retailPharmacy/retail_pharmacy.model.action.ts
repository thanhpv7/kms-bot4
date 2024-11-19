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
import {RetailPharmacyModel} from './retail_pharmacy.model';
import {RetailPharmacyModelAudit} from './retail_pharmacy.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Retail Pharmacy model actions to be dispatched by NgRx.
 */
export enum RetailPharmacyModelActionTypes {
	CREATE_RETAIL_PHARMACY = '[ENTITY] Create RetailPharmacyModel',
	CREATE_RETAIL_PHARMACY_OK = '[ENTITY] Create RetailPharmacyModel successfully',
	CREATE_RETAIL_PHARMACY_FAIL = '[ENTITY] Create RetailPharmacyModel failed',

	CREATE_ALL_RETAIL_PHARMACY = '[ENTITY] Create All RetailPharmacyModel',
	CREATE_ALL_RETAIL_PHARMACY_OK = '[ENTITY] Create All RetailPharmacyModel successfully',
	CREATE_ALL_RETAIL_PHARMACY_FAIL = '[ENTITY] Create All RetailPharmacyModel failed',

	DELETE_RETAIL_PHARMACY = '[ENTITY] Delete RetailPharmacyModel',
	DELETE_RETAIL_PHARMACY_OK = '[ENTITY] Delete RetailPharmacyModel successfully',
	DELETE_RETAIL_PHARMACY_FAIL = '[ENTITY] Delete RetailPharmacyModel failed',


	DELETE_RETAIL_PHARMACY_EXCLUDING_IDS = '[ENTITY] Delete RetailPharmacyModels Excluding Ids',
	DELETE_RETAIL_PHARMACY_EXCLUDING_IDS_OK = '[ENTITY] Delete RetailPharmacyModels Excluding Ids successfully',
	DELETE_RETAIL_PHARMACY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete RetailPharmacyModels Excluding Ids failed',

	DELETE_ALL_RETAIL_PHARMACY = '[ENTITY] Delete all RetailPharmacyModels',
	DELETE_ALL_RETAIL_PHARMACY_OK = '[ENTITY] Delete all RetailPharmacyModels successfully',
	DELETE_ALL_RETAIL_PHARMACY_FAIL = '[ENTITY] Delete all RetailPharmacyModels failed',

	UPDATE_RETAIL_PHARMACY = '[ENTITY] Update RetailPharmacyModel',
	UPDATE_RETAIL_PHARMACY_OK = '[ENTITY] Update RetailPharmacyModel successfully',
	UPDATE_RETAIL_PHARMACY_FAIL = '[ENTITY] Update RetailPharmacyModel failed',

	UPDATE_ALL_RETAIL_PHARMACY = '[ENTITY] Update all RetailPharmacyModel',
	UPDATE_ALL_RETAIL_PHARMACY_OK = '[ENTITY] Update all RetailPharmacyModel successfully',
	UPDATE_ALL_RETAIL_PHARMACY_FAIL = '[ENTITY] Update all RetailPharmacyModel failed',

	FETCH_RETAIL_PHARMACY= '[ENTITY] Fetch RetailPharmacyModel',
	FETCH_RETAIL_PHARMACY_OK = '[ENTITY] Fetch RetailPharmacyModel successfully',
	FETCH_RETAIL_PHARMACY_FAIL = '[ENTITY] Fetch RetailPharmacyModel failed',

	FETCH_RETAIL_PHARMACY_AUDIT= '[ENTITY] Fetch RetailPharmacyModel audit',
	FETCH_RETAIL_PHARMACY_AUDIT_OK = '[ENTITY] Fetch RetailPharmacyModel audit successfully',
	FETCH_RETAIL_PHARMACY_AUDIT_FAIL = '[ENTITY] Fetch RetailPharmacyModel audit failed',

	FETCH_RETAIL_PHARMACY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch RetailPharmacyModel audits by entity id',
	FETCH_RETAIL_PHARMACY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch RetailPharmacyModel audits by entity id successfully',
	FETCH_RETAIL_PHARMACY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch RetailPharmacyModel audits by entity id failed',

	FETCH_ALL_RETAIL_PHARMACY = '[ENTITY] Fetch all RetailPharmacyModel',
	FETCH_ALL_RETAIL_PHARMACY_OK = '[ENTITY] Fetch all RetailPharmacyModel successfully',
	FETCH_ALL_RETAIL_PHARMACY_FAIL = '[ENTITY] Fetch all RetailPharmacyModel failed',

	FETCH_RETAIL_PHARMACY_WITH_QUERY = '[ENTITY] Fetch RetailPharmacyModel with query',
	FETCH_RETAIL_PHARMACY_WITH_QUERY_OK = '[ENTITY] Fetch RetailPharmacyModel with query successfully',
	FETCH_RETAIL_PHARMACY_WITH_QUERY_FAIL = '[ENTITY] Fetch RetailPharmacyModel with query failed',

	FETCH_LAST_RETAIL_PHARMACY_WITH_QUERY = '[ENTITY] Fetch last RetailPharmacyModel with query',
	FETCH_LAST_RETAIL_PHARMACY_WITH_QUERY_OK = '[ENTITY] Fetch last RetailPharmacyModel with query successfully',
	FETCH_LAST_RETAIL_PHARMACY_WITH_QUERY_FAIL = '[ENTITY] Fetch last RetailPharmacyModel with query failed',

	EXPORT_RETAIL_PHARMACY = '[ENTITY] Export RetailPharmacyModel',
	EXPORT_RETAIL_PHARMACY_OK = '[ENTITY] Export RetailPharmacyModel successfully',
	EXPORT_RETAIL_PHARMACY_FAIL = '[ENTITY] Export RetailPharmacyModel failed',

	EXPORT_ALL_RETAIL_PHARMACY = '[ENTITY] Export All RetailPharmacyModels',
	EXPORT_ALL_RETAIL_PHARMACY_OK = '[ENTITY] Export All RetailPharmacyModels successfully',
	EXPORT_ALL_RETAIL_PHARMACY_FAIL = '[ENTITY] Export All RetailPharmacyModels failed',

	EXPORT_RETAIL_PHARMACY_EXCLUDING_IDS = '[ENTITY] Export RetailPharmacyModels excluding Ids',
	EXPORT_RETAIL_PHARMACY_EXCLUDING_IDS_OK = '[ENTITY] Export RetailPharmacyModel excluding Ids successfully',
	EXPORT_RETAIL_PHARMACY_EXCLUDING_IDS_FAIL = '[ENTITY] Export RetailPharmacyModel excluding Ids failed',

	COUNT_RETAIL_PHARMACYS = '[ENTITY] Fetch number of RetailPharmacyModel records',
	COUNT_RETAIL_PHARMACYS_OK = '[ENTITY] Fetch number of RetailPharmacyModel records successfully ',
	COUNT_RETAIL_PHARMACYS_FAIL = '[ENTITY] Fetch number of RetailPharmacyModel records failed',

	IMPORT_RETAIL_PHARMACYS = '[ENTITY] Import RetailPharmacyModels',
	IMPORT_RETAIL_PHARMACYS_OK = '[ENTITY] Import RetailPharmacyModels successfully',
	IMPORT_RETAIL_PHARMACYS_FAIL = '[ENTITY] Import RetailPharmacyModels fail',


	INITIALISE_RETAIL_PHARMACY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of RetailPharmacyModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseRetailPharmacyAction implements Action {
	readonly className: string = 'RetailPharmacyModel';

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

export class RetailPharmacyAction extends BaseRetailPharmacyAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RetailPharmacyAction here] off begin
	// % protected region % [Add any additional class fields for RetailPharmacyAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RetailPharmacyModel>,
		// % protected region % [Add any additional constructor parameters for RetailPharmacyAction here] off begin
		// % protected region % [Add any additional constructor parameters for RetailPharmacyAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RetailPharmacyAction here] off begin
			// % protected region % [Add any additional constructor arguments for RetailPharmacyAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RetailPharmacyAction here] off begin
		// % protected region % [Add any additional constructor logic for RetailPharmacyAction here] end
	}

	// % protected region % [Add any additional class methods for RetailPharmacyAction here] off begin
	// % protected region % [Add any additional class methods for RetailPharmacyAction here] end
}

export class RetailPharmacyActionOK extends BaseRetailPharmacyAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RetailPharmacyActionOK here] off begin
	// % protected region % [Add any additional class fields for RetailPharmacyActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<RetailPharmacyModel>,
		// % protected region % [Add any additional constructor parameters for RetailPharmacyActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for RetailPharmacyActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: RetailPharmacyModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RetailPharmacyActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for RetailPharmacyActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RetailPharmacyActionOK here] off begin
		// % protected region % [Add any additional constructor logic for RetailPharmacyActionOK here] end
	}

	// % protected region % [Add any additional class methods for RetailPharmacyActionOK here] off begin
	// % protected region % [Add any additional class methods for RetailPharmacyActionOK here] end
}

export class RetailPharmacyActionFail extends BaseRetailPharmacyAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for RetailPharmacyActionFail here] off begin
	// % protected region % [Add any additional class fields for RetailPharmacyActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<RetailPharmacyModel>,
		// % protected region % [Add any additional constructor parameters for RetailPharmacyActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for RetailPharmacyActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for RetailPharmacyActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for RetailPharmacyActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for RetailPharmacyActionFail here] off begin
		// % protected region % [Add any additional constructor logic for RetailPharmacyActionFail here] end
	}

	// % protected region % [Add any additional class methods for RetailPharmacyActionFail here] off begin
	// % protected region % [Add any additional class methods for RetailPharmacyActionFail here] end
}

export function isRetailPharmacyModelAction(e: any): e is BaseRetailPharmacyAction {
	return Object.values(RetailPharmacyModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
