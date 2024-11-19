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
import {MerchantSurchargeAndFeeModel} from './merchant_surcharge_and_fee.model';
import {MerchantSurchargeAndFeeModelAudit} from './merchant_surcharge_and_fee.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Merchant Surcharge and Fee model actions to be dispatched by NgRx.
 */
export enum MerchantSurchargeAndFeeModelActionTypes {
	CREATE_MERCHANT_SURCHARGE_AND_FEE = '[ENTITY] Create MerchantSurchargeAndFeeModel',
	CREATE_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Create MerchantSurchargeAndFeeModel successfully',
	CREATE_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Create MerchantSurchargeAndFeeModel failed',

	CREATE_ALL_MERCHANT_SURCHARGE_AND_FEE = '[ENTITY] Create All MerchantSurchargeAndFeeModel',
	CREATE_ALL_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Create All MerchantSurchargeAndFeeModel successfully',
	CREATE_ALL_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Create All MerchantSurchargeAndFeeModel failed',

	DELETE_MERCHANT_SURCHARGE_AND_FEE = '[ENTITY] Delete MerchantSurchargeAndFeeModel',
	DELETE_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Delete MerchantSurchargeAndFeeModel successfully',
	DELETE_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Delete MerchantSurchargeAndFeeModel failed',


	DELETE_MERCHANT_SURCHARGE_AND_FEE_EXCLUDING_IDS = '[ENTITY] Delete MerchantSurchargeAndFeeModels Excluding Ids',
	DELETE_MERCHANT_SURCHARGE_AND_FEE_EXCLUDING_IDS_OK = '[ENTITY] Delete MerchantSurchargeAndFeeModels Excluding Ids successfully',
	DELETE_MERCHANT_SURCHARGE_AND_FEE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MerchantSurchargeAndFeeModels Excluding Ids failed',

	DELETE_ALL_MERCHANT_SURCHARGE_AND_FEE = '[ENTITY] Delete all MerchantSurchargeAndFeeModels',
	DELETE_ALL_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Delete all MerchantSurchargeAndFeeModels successfully',
	DELETE_ALL_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Delete all MerchantSurchargeAndFeeModels failed',

	UPDATE_MERCHANT_SURCHARGE_AND_FEE = '[ENTITY] Update MerchantSurchargeAndFeeModel',
	UPDATE_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Update MerchantSurchargeAndFeeModel successfully',
	UPDATE_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Update MerchantSurchargeAndFeeModel failed',

	UPDATE_ALL_MERCHANT_SURCHARGE_AND_FEE = '[ENTITY] Update all MerchantSurchargeAndFeeModel',
	UPDATE_ALL_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Update all MerchantSurchargeAndFeeModel successfully',
	UPDATE_ALL_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Update all MerchantSurchargeAndFeeModel failed',

	FETCH_MERCHANT_SURCHARGE_AND_FEE= '[ENTITY] Fetch MerchantSurchargeAndFeeModel',
	FETCH_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Fetch MerchantSurchargeAndFeeModel successfully',
	FETCH_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Fetch MerchantSurchargeAndFeeModel failed',

	FETCH_MERCHANT_SURCHARGE_AND_FEE_AUDIT= '[ENTITY] Fetch MerchantSurchargeAndFeeModel audit',
	FETCH_MERCHANT_SURCHARGE_AND_FEE_AUDIT_OK = '[ENTITY] Fetch MerchantSurchargeAndFeeModel audit successfully',
	FETCH_MERCHANT_SURCHARGE_AND_FEE_AUDIT_FAIL = '[ENTITY] Fetch MerchantSurchargeAndFeeModel audit failed',

	FETCH_MERCHANT_SURCHARGE_AND_FEE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MerchantSurchargeAndFeeModel audits by entity id',
	FETCH_MERCHANT_SURCHARGE_AND_FEE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MerchantSurchargeAndFeeModel audits by entity id successfully',
	FETCH_MERCHANT_SURCHARGE_AND_FEE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MerchantSurchargeAndFeeModel audits by entity id failed',

	FETCH_ALL_MERCHANT_SURCHARGE_AND_FEE = '[ENTITY] Fetch all MerchantSurchargeAndFeeModel',
	FETCH_ALL_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Fetch all MerchantSurchargeAndFeeModel successfully',
	FETCH_ALL_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Fetch all MerchantSurchargeAndFeeModel failed',

	FETCH_MERCHANT_SURCHARGE_AND_FEE_WITH_QUERY = '[ENTITY] Fetch MerchantSurchargeAndFeeModel with query',
	FETCH_MERCHANT_SURCHARGE_AND_FEE_WITH_QUERY_OK = '[ENTITY] Fetch MerchantSurchargeAndFeeModel with query successfully',
	FETCH_MERCHANT_SURCHARGE_AND_FEE_WITH_QUERY_FAIL = '[ENTITY] Fetch MerchantSurchargeAndFeeModel with query failed',

	FETCH_LAST_MERCHANT_SURCHARGE_AND_FEE_WITH_QUERY = '[ENTITY] Fetch last MerchantSurchargeAndFeeModel with query',
	FETCH_LAST_MERCHANT_SURCHARGE_AND_FEE_WITH_QUERY_OK = '[ENTITY] Fetch last MerchantSurchargeAndFeeModel with query successfully',
	FETCH_LAST_MERCHANT_SURCHARGE_AND_FEE_WITH_QUERY_FAIL = '[ENTITY] Fetch last MerchantSurchargeAndFeeModel with query failed',

	EXPORT_MERCHANT_SURCHARGE_AND_FEE = '[ENTITY] Export MerchantSurchargeAndFeeModel',
	EXPORT_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Export MerchantSurchargeAndFeeModel successfully',
	EXPORT_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Export MerchantSurchargeAndFeeModel failed',

	EXPORT_ALL_MERCHANT_SURCHARGE_AND_FEE = '[ENTITY] Export All MerchantSurchargeAndFeeModels',
	EXPORT_ALL_MERCHANT_SURCHARGE_AND_FEE_OK = '[ENTITY] Export All MerchantSurchargeAndFeeModels successfully',
	EXPORT_ALL_MERCHANT_SURCHARGE_AND_FEE_FAIL = '[ENTITY] Export All MerchantSurchargeAndFeeModels failed',

	EXPORT_MERCHANT_SURCHARGE_AND_FEE_EXCLUDING_IDS = '[ENTITY] Export MerchantSurchargeAndFeeModels excluding Ids',
	EXPORT_MERCHANT_SURCHARGE_AND_FEE_EXCLUDING_IDS_OK = '[ENTITY] Export MerchantSurchargeAndFeeModel excluding Ids successfully',
	EXPORT_MERCHANT_SURCHARGE_AND_FEE_EXCLUDING_IDS_FAIL = '[ENTITY] Export MerchantSurchargeAndFeeModel excluding Ids failed',

	COUNT_MERCHANT_SURCHARGE_AND_FEES = '[ENTITY] Fetch number of MerchantSurchargeAndFeeModel records',
	COUNT_MERCHANT_SURCHARGE_AND_FEES_OK = '[ENTITY] Fetch number of MerchantSurchargeAndFeeModel records successfully ',
	COUNT_MERCHANT_SURCHARGE_AND_FEES_FAIL = '[ENTITY] Fetch number of MerchantSurchargeAndFeeModel records failed',

	IMPORT_MERCHANT_SURCHARGE_AND_FEES = '[ENTITY] Import MerchantSurchargeAndFeeModels',
	IMPORT_MERCHANT_SURCHARGE_AND_FEES_OK = '[ENTITY] Import MerchantSurchargeAndFeeModels successfully',
	IMPORT_MERCHANT_SURCHARGE_AND_FEES_FAIL = '[ENTITY] Import MerchantSurchargeAndFeeModels fail',


	INITIALISE_MERCHANT_SURCHARGE_AND_FEE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MerchantSurchargeAndFeeModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMerchantSurchargeAndFeeAction implements Action {
	readonly className: string = 'MerchantSurchargeAndFeeModel';

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

export class MerchantSurchargeAndFeeAction extends BaseMerchantSurchargeAndFeeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MerchantSurchargeAndFeeAction here] off begin
	// % protected region % [Add any additional class fields for MerchantSurchargeAndFeeAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MerchantSurchargeAndFeeModel>,
		// % protected region % [Add any additional constructor parameters for MerchantSurchargeAndFeeAction here] off begin
		// % protected region % [Add any additional constructor parameters for MerchantSurchargeAndFeeAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MerchantSurchargeAndFeeAction here] off begin
			// % protected region % [Add any additional constructor arguments for MerchantSurchargeAndFeeAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MerchantSurchargeAndFeeAction here] off begin
		// % protected region % [Add any additional constructor logic for MerchantSurchargeAndFeeAction here] end
	}

	// % protected region % [Add any additional class methods for MerchantSurchargeAndFeeAction here] off begin
	// % protected region % [Add any additional class methods for MerchantSurchargeAndFeeAction here] end
}

export class MerchantSurchargeAndFeeActionOK extends BaseMerchantSurchargeAndFeeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MerchantSurchargeAndFeeActionOK here] off begin
	// % protected region % [Add any additional class fields for MerchantSurchargeAndFeeActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MerchantSurchargeAndFeeModel>,
		// % protected region % [Add any additional constructor parameters for MerchantSurchargeAndFeeActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MerchantSurchargeAndFeeActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MerchantSurchargeAndFeeModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MerchantSurchargeAndFeeActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MerchantSurchargeAndFeeActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MerchantSurchargeAndFeeActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MerchantSurchargeAndFeeActionOK here] end
	}

	// % protected region % [Add any additional class methods for MerchantSurchargeAndFeeActionOK here] off begin
	// % protected region % [Add any additional class methods for MerchantSurchargeAndFeeActionOK here] end
}

export class MerchantSurchargeAndFeeActionFail extends BaseMerchantSurchargeAndFeeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MerchantSurchargeAndFeeActionFail here] off begin
	// % protected region % [Add any additional class fields for MerchantSurchargeAndFeeActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MerchantSurchargeAndFeeModel>,
		// % protected region % [Add any additional constructor parameters for MerchantSurchargeAndFeeActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MerchantSurchargeAndFeeActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MerchantSurchargeAndFeeActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MerchantSurchargeAndFeeActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MerchantSurchargeAndFeeActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MerchantSurchargeAndFeeActionFail here] end
	}

	// % protected region % [Add any additional class methods for MerchantSurchargeAndFeeActionFail here] off begin
	// % protected region % [Add any additional class methods for MerchantSurchargeAndFeeActionFail here] end
}

export function isMerchantSurchargeAndFeeModelAction(e: any): e is BaseMerchantSurchargeAndFeeAction {
	return Object.values(MerchantSurchargeAndFeeModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
