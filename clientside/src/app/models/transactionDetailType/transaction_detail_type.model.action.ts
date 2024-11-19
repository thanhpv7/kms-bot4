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
import {TransactionDetailTypeModel} from './transaction_detail_type.model';
import {TransactionDetailTypeModelAudit} from './transaction_detail_type.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Transaction Detail Type model actions to be dispatched by NgRx.
 */
export enum TransactionDetailTypeModelActionTypes {
	CREATE_TRANSACTION_DETAIL_TYPE = '[ENTITY] Create TransactionDetailTypeModel',
	CREATE_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Create TransactionDetailTypeModel successfully',
	CREATE_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Create TransactionDetailTypeModel failed',

	CREATE_ALL_TRANSACTION_DETAIL_TYPE = '[ENTITY] Create All TransactionDetailTypeModel',
	CREATE_ALL_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Create All TransactionDetailTypeModel successfully',
	CREATE_ALL_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Create All TransactionDetailTypeModel failed',

	DELETE_TRANSACTION_DETAIL_TYPE = '[ENTITY] Delete TransactionDetailTypeModel',
	DELETE_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Delete TransactionDetailTypeModel successfully',
	DELETE_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Delete TransactionDetailTypeModel failed',


	DELETE_TRANSACTION_DETAIL_TYPE_EXCLUDING_IDS = '[ENTITY] Delete TransactionDetailTypeModels Excluding Ids',
	DELETE_TRANSACTION_DETAIL_TYPE_EXCLUDING_IDS_OK = '[ENTITY] Delete TransactionDetailTypeModels Excluding Ids successfully',
	DELETE_TRANSACTION_DETAIL_TYPE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TransactionDetailTypeModels Excluding Ids failed',

	DELETE_ALL_TRANSACTION_DETAIL_TYPE = '[ENTITY] Delete all TransactionDetailTypeModels',
	DELETE_ALL_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Delete all TransactionDetailTypeModels successfully',
	DELETE_ALL_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Delete all TransactionDetailTypeModels failed',

	UPDATE_TRANSACTION_DETAIL_TYPE = '[ENTITY] Update TransactionDetailTypeModel',
	UPDATE_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Update TransactionDetailTypeModel successfully',
	UPDATE_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Update TransactionDetailTypeModel failed',

	UPDATE_ALL_TRANSACTION_DETAIL_TYPE = '[ENTITY] Update all TransactionDetailTypeModel',
	UPDATE_ALL_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Update all TransactionDetailTypeModel successfully',
	UPDATE_ALL_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Update all TransactionDetailTypeModel failed',

	FETCH_TRANSACTION_DETAIL_TYPE= '[ENTITY] Fetch TransactionDetailTypeModel',
	FETCH_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Fetch TransactionDetailTypeModel successfully',
	FETCH_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Fetch TransactionDetailTypeModel failed',

	FETCH_TRANSACTION_DETAIL_TYPE_AUDIT= '[ENTITY] Fetch TransactionDetailTypeModel audit',
	FETCH_TRANSACTION_DETAIL_TYPE_AUDIT_OK = '[ENTITY] Fetch TransactionDetailTypeModel audit successfully',
	FETCH_TRANSACTION_DETAIL_TYPE_AUDIT_FAIL = '[ENTITY] Fetch TransactionDetailTypeModel audit failed',

	FETCH_TRANSACTION_DETAIL_TYPE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TransactionDetailTypeModel audits by entity id',
	FETCH_TRANSACTION_DETAIL_TYPE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TransactionDetailTypeModel audits by entity id successfully',
	FETCH_TRANSACTION_DETAIL_TYPE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TransactionDetailTypeModel audits by entity id failed',

	FETCH_ALL_TRANSACTION_DETAIL_TYPE = '[ENTITY] Fetch all TransactionDetailTypeModel',
	FETCH_ALL_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Fetch all TransactionDetailTypeModel successfully',
	FETCH_ALL_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Fetch all TransactionDetailTypeModel failed',

	FETCH_TRANSACTION_DETAIL_TYPE_WITH_QUERY = '[ENTITY] Fetch TransactionDetailTypeModel with query',
	FETCH_TRANSACTION_DETAIL_TYPE_WITH_QUERY_OK = '[ENTITY] Fetch TransactionDetailTypeModel with query successfully',
	FETCH_TRANSACTION_DETAIL_TYPE_WITH_QUERY_FAIL = '[ENTITY] Fetch TransactionDetailTypeModel with query failed',

	FETCH_LAST_TRANSACTION_DETAIL_TYPE_WITH_QUERY = '[ENTITY] Fetch last TransactionDetailTypeModel with query',
	FETCH_LAST_TRANSACTION_DETAIL_TYPE_WITH_QUERY_OK = '[ENTITY] Fetch last TransactionDetailTypeModel with query successfully',
	FETCH_LAST_TRANSACTION_DETAIL_TYPE_WITH_QUERY_FAIL = '[ENTITY] Fetch last TransactionDetailTypeModel with query failed',

	EXPORT_TRANSACTION_DETAIL_TYPE = '[ENTITY] Export TransactionDetailTypeModel',
	EXPORT_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Export TransactionDetailTypeModel successfully',
	EXPORT_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Export TransactionDetailTypeModel failed',

	EXPORT_ALL_TRANSACTION_DETAIL_TYPE = '[ENTITY] Export All TransactionDetailTypeModels',
	EXPORT_ALL_TRANSACTION_DETAIL_TYPE_OK = '[ENTITY] Export All TransactionDetailTypeModels successfully',
	EXPORT_ALL_TRANSACTION_DETAIL_TYPE_FAIL = '[ENTITY] Export All TransactionDetailTypeModels failed',

	EXPORT_TRANSACTION_DETAIL_TYPE_EXCLUDING_IDS = '[ENTITY] Export TransactionDetailTypeModels excluding Ids',
	EXPORT_TRANSACTION_DETAIL_TYPE_EXCLUDING_IDS_OK = '[ENTITY] Export TransactionDetailTypeModel excluding Ids successfully',
	EXPORT_TRANSACTION_DETAIL_TYPE_EXCLUDING_IDS_FAIL = '[ENTITY] Export TransactionDetailTypeModel excluding Ids failed',

	COUNT_TRANSACTION_DETAIL_TYPES = '[ENTITY] Fetch number of TransactionDetailTypeModel records',
	COUNT_TRANSACTION_DETAIL_TYPES_OK = '[ENTITY] Fetch number of TransactionDetailTypeModel records successfully ',
	COUNT_TRANSACTION_DETAIL_TYPES_FAIL = '[ENTITY] Fetch number of TransactionDetailTypeModel records failed',

	IMPORT_TRANSACTION_DETAIL_TYPES = '[ENTITY] Import TransactionDetailTypeModels',
	IMPORT_TRANSACTION_DETAIL_TYPES_OK = '[ENTITY] Import TransactionDetailTypeModels successfully',
	IMPORT_TRANSACTION_DETAIL_TYPES_FAIL = '[ENTITY] Import TransactionDetailTypeModels fail',


	INITIALISE_TRANSACTION_DETAIL_TYPE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TransactionDetailTypeModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTransactionDetailTypeAction implements Action {
	readonly className: string = 'TransactionDetailTypeModel';

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

export class TransactionDetailTypeAction extends BaseTransactionDetailTypeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransactionDetailTypeAction here] off begin
	// % protected region % [Add any additional class fields for TransactionDetailTypeAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TransactionDetailTypeModel>,
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeAction here] off begin
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeAction here] off begin
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeAction here] off begin
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeAction here] end
	}

	// % protected region % [Add any additional class methods for TransactionDetailTypeAction here] off begin
	// % protected region % [Add any additional class methods for TransactionDetailTypeAction here] end
}

export class TransactionDetailTypeActionOK extends BaseTransactionDetailTypeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransactionDetailTypeActionOK here] off begin
	// % protected region % [Add any additional class fields for TransactionDetailTypeActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TransactionDetailTypeModel>,
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TransactionDetailTypeModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeActionOK here] end
	}

	// % protected region % [Add any additional class methods for TransactionDetailTypeActionOK here] off begin
	// % protected region % [Add any additional class methods for TransactionDetailTypeActionOK here] end
}

export class TransactionDetailTypeActionFail extends BaseTransactionDetailTypeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransactionDetailTypeActionFail here] off begin
	// % protected region % [Add any additional class fields for TransactionDetailTypeActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TransactionDetailTypeModel>,
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeActionFail here] end
	}

	// % protected region % [Add any additional class methods for TransactionDetailTypeActionFail here] off begin
	// % protected region % [Add any additional class methods for TransactionDetailTypeActionFail here] end
}

export function isTransactionDetailTypeModelAction(e: any): e is BaseTransactionDetailTypeAction {
	return Object.values(TransactionDetailTypeModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
