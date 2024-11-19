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
import {SupplierBankAccountModel} from './supplier_bank_account.model';
import {SupplierBankAccountModelAudit} from './supplier_bank_account.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Supplier Bank Account model actions to be dispatched by NgRx.
 */
export enum SupplierBankAccountModelActionTypes {
	CREATE_SUPPLIER_BANK_ACCOUNT = '[ENTITY] Create SupplierBankAccountModel',
	CREATE_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Create SupplierBankAccountModel successfully',
	CREATE_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Create SupplierBankAccountModel failed',

	CREATE_ALL_SUPPLIER_BANK_ACCOUNT = '[ENTITY] Create All SupplierBankAccountModel',
	CREATE_ALL_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Create All SupplierBankAccountModel successfully',
	CREATE_ALL_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Create All SupplierBankAccountModel failed',

	DELETE_SUPPLIER_BANK_ACCOUNT = '[ENTITY] Delete SupplierBankAccountModel',
	DELETE_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Delete SupplierBankAccountModel successfully',
	DELETE_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Delete SupplierBankAccountModel failed',


	DELETE_SUPPLIER_BANK_ACCOUNT_EXCLUDING_IDS = '[ENTITY] Delete SupplierBankAccountModels Excluding Ids',
	DELETE_SUPPLIER_BANK_ACCOUNT_EXCLUDING_IDS_OK = '[ENTITY] Delete SupplierBankAccountModels Excluding Ids successfully',
	DELETE_SUPPLIER_BANK_ACCOUNT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete SupplierBankAccountModels Excluding Ids failed',

	DELETE_ALL_SUPPLIER_BANK_ACCOUNT = '[ENTITY] Delete all SupplierBankAccountModels',
	DELETE_ALL_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Delete all SupplierBankAccountModels successfully',
	DELETE_ALL_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Delete all SupplierBankAccountModels failed',

	UPDATE_SUPPLIER_BANK_ACCOUNT = '[ENTITY] Update SupplierBankAccountModel',
	UPDATE_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Update SupplierBankAccountModel successfully',
	UPDATE_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Update SupplierBankAccountModel failed',

	UPDATE_ALL_SUPPLIER_BANK_ACCOUNT = '[ENTITY] Update all SupplierBankAccountModel',
	UPDATE_ALL_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Update all SupplierBankAccountModel successfully',
	UPDATE_ALL_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Update all SupplierBankAccountModel failed',

	FETCH_SUPPLIER_BANK_ACCOUNT= '[ENTITY] Fetch SupplierBankAccountModel',
	FETCH_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Fetch SupplierBankAccountModel successfully',
	FETCH_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Fetch SupplierBankAccountModel failed',

	FETCH_SUPPLIER_BANK_ACCOUNT_AUDIT= '[ENTITY] Fetch SupplierBankAccountModel audit',
	FETCH_SUPPLIER_BANK_ACCOUNT_AUDIT_OK = '[ENTITY] Fetch SupplierBankAccountModel audit successfully',
	FETCH_SUPPLIER_BANK_ACCOUNT_AUDIT_FAIL = '[ENTITY] Fetch SupplierBankAccountModel audit failed',

	FETCH_SUPPLIER_BANK_ACCOUNT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch SupplierBankAccountModel audits by entity id',
	FETCH_SUPPLIER_BANK_ACCOUNT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch SupplierBankAccountModel audits by entity id successfully',
	FETCH_SUPPLIER_BANK_ACCOUNT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch SupplierBankAccountModel audits by entity id failed',

	FETCH_ALL_SUPPLIER_BANK_ACCOUNT = '[ENTITY] Fetch all SupplierBankAccountModel',
	FETCH_ALL_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Fetch all SupplierBankAccountModel successfully',
	FETCH_ALL_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Fetch all SupplierBankAccountModel failed',

	FETCH_SUPPLIER_BANK_ACCOUNT_WITH_QUERY = '[ENTITY] Fetch SupplierBankAccountModel with query',
	FETCH_SUPPLIER_BANK_ACCOUNT_WITH_QUERY_OK = '[ENTITY] Fetch SupplierBankAccountModel with query successfully',
	FETCH_SUPPLIER_BANK_ACCOUNT_WITH_QUERY_FAIL = '[ENTITY] Fetch SupplierBankAccountModel with query failed',

	FETCH_LAST_SUPPLIER_BANK_ACCOUNT_WITH_QUERY = '[ENTITY] Fetch last SupplierBankAccountModel with query',
	FETCH_LAST_SUPPLIER_BANK_ACCOUNT_WITH_QUERY_OK = '[ENTITY] Fetch last SupplierBankAccountModel with query successfully',
	FETCH_LAST_SUPPLIER_BANK_ACCOUNT_WITH_QUERY_FAIL = '[ENTITY] Fetch last SupplierBankAccountModel with query failed',

	EXPORT_SUPPLIER_BANK_ACCOUNT = '[ENTITY] Export SupplierBankAccountModel',
	EXPORT_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Export SupplierBankAccountModel successfully',
	EXPORT_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Export SupplierBankAccountModel failed',

	EXPORT_ALL_SUPPLIER_BANK_ACCOUNT = '[ENTITY] Export All SupplierBankAccountModels',
	EXPORT_ALL_SUPPLIER_BANK_ACCOUNT_OK = '[ENTITY] Export All SupplierBankAccountModels successfully',
	EXPORT_ALL_SUPPLIER_BANK_ACCOUNT_FAIL = '[ENTITY] Export All SupplierBankAccountModels failed',

	EXPORT_SUPPLIER_BANK_ACCOUNT_EXCLUDING_IDS = '[ENTITY] Export SupplierBankAccountModels excluding Ids',
	EXPORT_SUPPLIER_BANK_ACCOUNT_EXCLUDING_IDS_OK = '[ENTITY] Export SupplierBankAccountModel excluding Ids successfully',
	EXPORT_SUPPLIER_BANK_ACCOUNT_EXCLUDING_IDS_FAIL = '[ENTITY] Export SupplierBankAccountModel excluding Ids failed',

	COUNT_SUPPLIER_BANK_ACCOUNTS = '[ENTITY] Fetch number of SupplierBankAccountModel records',
	COUNT_SUPPLIER_BANK_ACCOUNTS_OK = '[ENTITY] Fetch number of SupplierBankAccountModel records successfully ',
	COUNT_SUPPLIER_BANK_ACCOUNTS_FAIL = '[ENTITY] Fetch number of SupplierBankAccountModel records failed',

	IMPORT_SUPPLIER_BANK_ACCOUNTS = '[ENTITY] Import SupplierBankAccountModels',
	IMPORT_SUPPLIER_BANK_ACCOUNTS_OK = '[ENTITY] Import SupplierBankAccountModels successfully',
	IMPORT_SUPPLIER_BANK_ACCOUNTS_FAIL = '[ENTITY] Import SupplierBankAccountModels fail',


	INITIALISE_SUPPLIER_BANK_ACCOUNT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of SupplierBankAccountModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseSupplierBankAccountAction implements Action {
	readonly className: string = 'SupplierBankAccountModel';

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

export class SupplierBankAccountAction extends BaseSupplierBankAccountAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierBankAccountAction here] off begin
	// % protected region % [Add any additional class fields for SupplierBankAccountAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SupplierBankAccountModel>,
		// % protected region % [Add any additional constructor parameters for SupplierBankAccountAction here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierBankAccountAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierBankAccountAction here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierBankAccountAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierBankAccountAction here] off begin
		// % protected region % [Add any additional constructor logic for SupplierBankAccountAction here] end
	}

	// % protected region % [Add any additional class methods for SupplierBankAccountAction here] off begin
	// % protected region % [Add any additional class methods for SupplierBankAccountAction here] end
}

export class SupplierBankAccountActionOK extends BaseSupplierBankAccountAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierBankAccountActionOK here] off begin
	// % protected region % [Add any additional class fields for SupplierBankAccountActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SupplierBankAccountModel>,
		// % protected region % [Add any additional constructor parameters for SupplierBankAccountActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierBankAccountActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: SupplierBankAccountModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierBankAccountActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierBankAccountActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierBankAccountActionOK here] off begin
		// % protected region % [Add any additional constructor logic for SupplierBankAccountActionOK here] end
	}

	// % protected region % [Add any additional class methods for SupplierBankAccountActionOK here] off begin
	// % protected region % [Add any additional class methods for SupplierBankAccountActionOK here] end
}

export class SupplierBankAccountActionFail extends BaseSupplierBankAccountAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SupplierBankAccountActionFail here] off begin
	// % protected region % [Add any additional class fields for SupplierBankAccountActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<SupplierBankAccountModel>,
		// % protected region % [Add any additional constructor parameters for SupplierBankAccountActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for SupplierBankAccountActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SupplierBankAccountActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for SupplierBankAccountActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SupplierBankAccountActionFail here] off begin
		// % protected region % [Add any additional constructor logic for SupplierBankAccountActionFail here] end
	}

	// % protected region % [Add any additional class methods for SupplierBankAccountActionFail here] off begin
	// % protected region % [Add any additional class methods for SupplierBankAccountActionFail here] end
}

export function isSupplierBankAccountModelAction(e: any): e is BaseSupplierBankAccountAction {
	return Object.values(SupplierBankAccountModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
