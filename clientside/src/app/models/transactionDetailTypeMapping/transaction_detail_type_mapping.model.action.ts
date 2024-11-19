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
import {TransactionDetailTypeMappingModel} from './transaction_detail_type_mapping.model';
import {TransactionDetailTypeMappingModelAudit} from './transaction_detail_type_mapping.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Transaction Detail Type Mapping model actions to be dispatched by NgRx.
 */
export enum TransactionDetailTypeMappingModelActionTypes {
	CREATE_TRANSACTION_DETAIL_TYPE_MAPPING = '[ENTITY] Create TransactionDetailTypeMappingModel',
	CREATE_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Create TransactionDetailTypeMappingModel successfully',
	CREATE_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Create TransactionDetailTypeMappingModel failed',

	CREATE_ALL_TRANSACTION_DETAIL_TYPE_MAPPING = '[ENTITY] Create All TransactionDetailTypeMappingModel',
	CREATE_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Create All TransactionDetailTypeMappingModel successfully',
	CREATE_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Create All TransactionDetailTypeMappingModel failed',

	DELETE_TRANSACTION_DETAIL_TYPE_MAPPING = '[ENTITY] Delete TransactionDetailTypeMappingModel',
	DELETE_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Delete TransactionDetailTypeMappingModel successfully',
	DELETE_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Delete TransactionDetailTypeMappingModel failed',


	DELETE_TRANSACTION_DETAIL_TYPE_MAPPING_EXCLUDING_IDS = '[ENTITY] Delete TransactionDetailTypeMappingModels Excluding Ids',
	DELETE_TRANSACTION_DETAIL_TYPE_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Delete TransactionDetailTypeMappingModels Excluding Ids successfully',
	DELETE_TRANSACTION_DETAIL_TYPE_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TransactionDetailTypeMappingModels Excluding Ids failed',

	DELETE_ALL_TRANSACTION_DETAIL_TYPE_MAPPING = '[ENTITY] Delete all TransactionDetailTypeMappingModels',
	DELETE_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Delete all TransactionDetailTypeMappingModels successfully',
	DELETE_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Delete all TransactionDetailTypeMappingModels failed',

	UPDATE_TRANSACTION_DETAIL_TYPE_MAPPING = '[ENTITY] Update TransactionDetailTypeMappingModel',
	UPDATE_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Update TransactionDetailTypeMappingModel successfully',
	UPDATE_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Update TransactionDetailTypeMappingModel failed',

	UPDATE_ALL_TRANSACTION_DETAIL_TYPE_MAPPING = '[ENTITY] Update all TransactionDetailTypeMappingModel',
	UPDATE_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Update all TransactionDetailTypeMappingModel successfully',
	UPDATE_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Update all TransactionDetailTypeMappingModel failed',

	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING= '[ENTITY] Fetch TransactionDetailTypeMappingModel',
	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Fetch TransactionDetailTypeMappingModel successfully',
	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Fetch TransactionDetailTypeMappingModel failed',

	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_AUDIT= '[ENTITY] Fetch TransactionDetailTypeMappingModel audit',
	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_AUDIT_OK = '[ENTITY] Fetch TransactionDetailTypeMappingModel audit successfully',
	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_AUDIT_FAIL = '[ENTITY] Fetch TransactionDetailTypeMappingModel audit failed',

	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TransactionDetailTypeMappingModel audits by entity id',
	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TransactionDetailTypeMappingModel audits by entity id successfully',
	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TransactionDetailTypeMappingModel audits by entity id failed',

	FETCH_ALL_TRANSACTION_DETAIL_TYPE_MAPPING = '[ENTITY] Fetch all TransactionDetailTypeMappingModel',
	FETCH_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Fetch all TransactionDetailTypeMappingModel successfully',
	FETCH_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Fetch all TransactionDetailTypeMappingModel failed',

	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_WITH_QUERY = '[ENTITY] Fetch TransactionDetailTypeMappingModel with query',
	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch TransactionDetailTypeMappingModel with query successfully',
	FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch TransactionDetailTypeMappingModel with query failed',

	FETCH_LAST_TRANSACTION_DETAIL_TYPE_MAPPING_WITH_QUERY = '[ENTITY] Fetch last TransactionDetailTypeMappingModel with query',
	FETCH_LAST_TRANSACTION_DETAIL_TYPE_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch last TransactionDetailTypeMappingModel with query successfully',
	FETCH_LAST_TRANSACTION_DETAIL_TYPE_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch last TransactionDetailTypeMappingModel with query failed',

	EXPORT_TRANSACTION_DETAIL_TYPE_MAPPING = '[ENTITY] Export TransactionDetailTypeMappingModel',
	EXPORT_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Export TransactionDetailTypeMappingModel successfully',
	EXPORT_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Export TransactionDetailTypeMappingModel failed',

	EXPORT_ALL_TRANSACTION_DETAIL_TYPE_MAPPING = '[ENTITY] Export All TransactionDetailTypeMappingModels',
	EXPORT_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_OK = '[ENTITY] Export All TransactionDetailTypeMappingModels successfully',
	EXPORT_ALL_TRANSACTION_DETAIL_TYPE_MAPPING_FAIL = '[ENTITY] Export All TransactionDetailTypeMappingModels failed',

	EXPORT_TRANSACTION_DETAIL_TYPE_MAPPING_EXCLUDING_IDS = '[ENTITY] Export TransactionDetailTypeMappingModels excluding Ids',
	EXPORT_TRANSACTION_DETAIL_TYPE_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Export TransactionDetailTypeMappingModel excluding Ids successfully',
	EXPORT_TRANSACTION_DETAIL_TYPE_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Export TransactionDetailTypeMappingModel excluding Ids failed',

	COUNT_TRANSACTION_DETAIL_TYPE_MAPPINGS = '[ENTITY] Fetch number of TransactionDetailTypeMappingModel records',
	COUNT_TRANSACTION_DETAIL_TYPE_MAPPINGS_OK = '[ENTITY] Fetch number of TransactionDetailTypeMappingModel records successfully ',
	COUNT_TRANSACTION_DETAIL_TYPE_MAPPINGS_FAIL = '[ENTITY] Fetch number of TransactionDetailTypeMappingModel records failed',

	IMPORT_TRANSACTION_DETAIL_TYPE_MAPPINGS = '[ENTITY] Import TransactionDetailTypeMappingModels',
	IMPORT_TRANSACTION_DETAIL_TYPE_MAPPINGS_OK = '[ENTITY] Import TransactionDetailTypeMappingModels successfully',
	IMPORT_TRANSACTION_DETAIL_TYPE_MAPPINGS_FAIL = '[ENTITY] Import TransactionDetailTypeMappingModels fail',


	INITIALISE_TRANSACTION_DETAIL_TYPE_MAPPING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TransactionDetailTypeMappingModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTransactionDetailTypeMappingAction implements Action {
	readonly className: string = 'TransactionDetailTypeMappingModel';

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

export class TransactionDetailTypeMappingAction extends BaseTransactionDetailTypeMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransactionDetailTypeMappingAction here] off begin
	// % protected region % [Add any additional class fields for TransactionDetailTypeMappingAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TransactionDetailTypeMappingModel>,
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeMappingAction here] off begin
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeMappingAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeMappingAction here] off begin
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeMappingAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeMappingAction here] off begin
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeMappingAction here] end
	}

	// % protected region % [Add any additional class methods for TransactionDetailTypeMappingAction here] off begin
	// % protected region % [Add any additional class methods for TransactionDetailTypeMappingAction here] end
}

export class TransactionDetailTypeMappingActionOK extends BaseTransactionDetailTypeMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransactionDetailTypeMappingActionOK here] off begin
	// % protected region % [Add any additional class fields for TransactionDetailTypeMappingActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TransactionDetailTypeMappingModel>,
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeMappingActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeMappingActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TransactionDetailTypeMappingModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeMappingActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeMappingActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeMappingActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeMappingActionOK here] end
	}

	// % protected region % [Add any additional class methods for TransactionDetailTypeMappingActionOK here] off begin
	// % protected region % [Add any additional class methods for TransactionDetailTypeMappingActionOK here] end
}

export class TransactionDetailTypeMappingActionFail extends BaseTransactionDetailTypeMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TransactionDetailTypeMappingActionFail here] off begin
	// % protected region % [Add any additional class fields for TransactionDetailTypeMappingActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TransactionDetailTypeMappingModel>,
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeMappingActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TransactionDetailTypeMappingActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeMappingActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TransactionDetailTypeMappingActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeMappingActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TransactionDetailTypeMappingActionFail here] end
	}

	// % protected region % [Add any additional class methods for TransactionDetailTypeMappingActionFail here] off begin
	// % protected region % [Add any additional class methods for TransactionDetailTypeMappingActionFail here] end
}

export function isTransactionDetailTypeMappingModelAction(e: any): e is BaseTransactionDetailTypeMappingAction {
	return Object.values(TransactionDetailTypeMappingModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
