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
import {MerchantModel} from './merchant.model';
import {MerchantModelAudit} from './merchant.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Merchant model actions to be dispatched by NgRx.
 */
export enum MerchantModelActionTypes {
	CREATE_MERCHANT = '[ENTITY] Create MerchantModel',
	CREATE_MERCHANT_OK = '[ENTITY] Create MerchantModel successfully',
	CREATE_MERCHANT_FAIL = '[ENTITY] Create MerchantModel failed',

	CREATE_ALL_MERCHANT = '[ENTITY] Create All MerchantModel',
	CREATE_ALL_MERCHANT_OK = '[ENTITY] Create All MerchantModel successfully',
	CREATE_ALL_MERCHANT_FAIL = '[ENTITY] Create All MerchantModel failed',

	DELETE_MERCHANT = '[ENTITY] Delete MerchantModel',
	DELETE_MERCHANT_OK = '[ENTITY] Delete MerchantModel successfully',
	DELETE_MERCHANT_FAIL = '[ENTITY] Delete MerchantModel failed',


	DELETE_MERCHANT_EXCLUDING_IDS = '[ENTITY] Delete MerchantModels Excluding Ids',
	DELETE_MERCHANT_EXCLUDING_IDS_OK = '[ENTITY] Delete MerchantModels Excluding Ids successfully',
	DELETE_MERCHANT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MerchantModels Excluding Ids failed',

	DELETE_ALL_MERCHANT = '[ENTITY] Delete all MerchantModels',
	DELETE_ALL_MERCHANT_OK = '[ENTITY] Delete all MerchantModels successfully',
	DELETE_ALL_MERCHANT_FAIL = '[ENTITY] Delete all MerchantModels failed',

	UPDATE_MERCHANT = '[ENTITY] Update MerchantModel',
	UPDATE_MERCHANT_OK = '[ENTITY] Update MerchantModel successfully',
	UPDATE_MERCHANT_FAIL = '[ENTITY] Update MerchantModel failed',

	UPDATE_ALL_MERCHANT = '[ENTITY] Update all MerchantModel',
	UPDATE_ALL_MERCHANT_OK = '[ENTITY] Update all MerchantModel successfully',
	UPDATE_ALL_MERCHANT_FAIL = '[ENTITY] Update all MerchantModel failed',

	FETCH_MERCHANT= '[ENTITY] Fetch MerchantModel',
	FETCH_MERCHANT_OK = '[ENTITY] Fetch MerchantModel successfully',
	FETCH_MERCHANT_FAIL = '[ENTITY] Fetch MerchantModel failed',

	FETCH_MERCHANT_AUDIT= '[ENTITY] Fetch MerchantModel audit',
	FETCH_MERCHANT_AUDIT_OK = '[ENTITY] Fetch MerchantModel audit successfully',
	FETCH_MERCHANT_AUDIT_FAIL = '[ENTITY] Fetch MerchantModel audit failed',

	FETCH_MERCHANT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MerchantModel audits by entity id',
	FETCH_MERCHANT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MerchantModel audits by entity id successfully',
	FETCH_MERCHANT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MerchantModel audits by entity id failed',

	FETCH_ALL_MERCHANT = '[ENTITY] Fetch all MerchantModel',
	FETCH_ALL_MERCHANT_OK = '[ENTITY] Fetch all MerchantModel successfully',
	FETCH_ALL_MERCHANT_FAIL = '[ENTITY] Fetch all MerchantModel failed',

	FETCH_MERCHANT_WITH_QUERY = '[ENTITY] Fetch MerchantModel with query',
	FETCH_MERCHANT_WITH_QUERY_OK = '[ENTITY] Fetch MerchantModel with query successfully',
	FETCH_MERCHANT_WITH_QUERY_FAIL = '[ENTITY] Fetch MerchantModel with query failed',

	FETCH_LAST_MERCHANT_WITH_QUERY = '[ENTITY] Fetch last MerchantModel with query',
	FETCH_LAST_MERCHANT_WITH_QUERY_OK = '[ENTITY] Fetch last MerchantModel with query successfully',
	FETCH_LAST_MERCHANT_WITH_QUERY_FAIL = '[ENTITY] Fetch last MerchantModel with query failed',

	EXPORT_MERCHANT = '[ENTITY] Export MerchantModel',
	EXPORT_MERCHANT_OK = '[ENTITY] Export MerchantModel successfully',
	EXPORT_MERCHANT_FAIL = '[ENTITY] Export MerchantModel failed',

	EXPORT_ALL_MERCHANT = '[ENTITY] Export All MerchantModels',
	EXPORT_ALL_MERCHANT_OK = '[ENTITY] Export All MerchantModels successfully',
	EXPORT_ALL_MERCHANT_FAIL = '[ENTITY] Export All MerchantModels failed',

	EXPORT_MERCHANT_EXCLUDING_IDS = '[ENTITY] Export MerchantModels excluding Ids',
	EXPORT_MERCHANT_EXCLUDING_IDS_OK = '[ENTITY] Export MerchantModel excluding Ids successfully',
	EXPORT_MERCHANT_EXCLUDING_IDS_FAIL = '[ENTITY] Export MerchantModel excluding Ids failed',

	COUNT_MERCHANTS = '[ENTITY] Fetch number of MerchantModel records',
	COUNT_MERCHANTS_OK = '[ENTITY] Fetch number of MerchantModel records successfully ',
	COUNT_MERCHANTS_FAIL = '[ENTITY] Fetch number of MerchantModel records failed',

	IMPORT_MERCHANTS = '[ENTITY] Import MerchantModels',
	IMPORT_MERCHANTS_OK = '[ENTITY] Import MerchantModels successfully',
	IMPORT_MERCHANTS_FAIL = '[ENTITY] Import MerchantModels fail',


	INITIALISE_MERCHANT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MerchantModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMerchantAction implements Action {
	readonly className: string = 'MerchantModel';

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

export class MerchantAction extends BaseMerchantAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MerchantAction here] off begin
	// % protected region % [Add any additional class fields for MerchantAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MerchantModel>,
		// % protected region % [Add any additional constructor parameters for MerchantAction here] off begin
		// % protected region % [Add any additional constructor parameters for MerchantAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MerchantAction here] off begin
			// % protected region % [Add any additional constructor arguments for MerchantAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MerchantAction here] off begin
		// % protected region % [Add any additional constructor logic for MerchantAction here] end
	}

	// % protected region % [Add any additional class methods for MerchantAction here] off begin
	// % protected region % [Add any additional class methods for MerchantAction here] end
}

export class MerchantActionOK extends BaseMerchantAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MerchantActionOK here] off begin
	// % protected region % [Add any additional class fields for MerchantActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MerchantModel>,
		// % protected region % [Add any additional constructor parameters for MerchantActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MerchantActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MerchantModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MerchantActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MerchantActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MerchantActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MerchantActionOK here] end
	}

	// % protected region % [Add any additional class methods for MerchantActionOK here] off begin
	// % protected region % [Add any additional class methods for MerchantActionOK here] end
}

export class MerchantActionFail extends BaseMerchantAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MerchantActionFail here] off begin
	// % protected region % [Add any additional class fields for MerchantActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MerchantModel>,
		// % protected region % [Add any additional constructor parameters for MerchantActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MerchantActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MerchantActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MerchantActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MerchantActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MerchantActionFail here] end
	}

	// % protected region % [Add any additional class methods for MerchantActionFail here] off begin
	// % protected region % [Add any additional class methods for MerchantActionFail here] end
}

export function isMerchantModelAction(e: any): e is BaseMerchantAction {
	return Object.values(MerchantModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
