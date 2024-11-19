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
import {PurchaseRequisitionModel} from './purchase_requisition.model';
import {PurchaseRequisitionModelAudit} from './purchase_requisition.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Purchase Requisition model actions to be dispatched by NgRx.
 */
export enum PurchaseRequisitionModelActionTypes {
	CREATE_PURCHASE_REQUISITION = '[ENTITY] Create PurchaseRequisitionModel',
	CREATE_PURCHASE_REQUISITION_OK = '[ENTITY] Create PurchaseRequisitionModel successfully',
	CREATE_PURCHASE_REQUISITION_FAIL = '[ENTITY] Create PurchaseRequisitionModel failed',

	CREATE_ALL_PURCHASE_REQUISITION = '[ENTITY] Create All PurchaseRequisitionModel',
	CREATE_ALL_PURCHASE_REQUISITION_OK = '[ENTITY] Create All PurchaseRequisitionModel successfully',
	CREATE_ALL_PURCHASE_REQUISITION_FAIL = '[ENTITY] Create All PurchaseRequisitionModel failed',

	DELETE_PURCHASE_REQUISITION = '[ENTITY] Delete PurchaseRequisitionModel',
	DELETE_PURCHASE_REQUISITION_OK = '[ENTITY] Delete PurchaseRequisitionModel successfully',
	DELETE_PURCHASE_REQUISITION_FAIL = '[ENTITY] Delete PurchaseRequisitionModel failed',


	DELETE_PURCHASE_REQUISITION_EXCLUDING_IDS = '[ENTITY] Delete PurchaseRequisitionModels Excluding Ids',
	DELETE_PURCHASE_REQUISITION_EXCLUDING_IDS_OK = '[ENTITY] Delete PurchaseRequisitionModels Excluding Ids successfully',
	DELETE_PURCHASE_REQUISITION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PurchaseRequisitionModels Excluding Ids failed',

	DELETE_ALL_PURCHASE_REQUISITION = '[ENTITY] Delete all PurchaseRequisitionModels',
	DELETE_ALL_PURCHASE_REQUISITION_OK = '[ENTITY] Delete all PurchaseRequisitionModels successfully',
	DELETE_ALL_PURCHASE_REQUISITION_FAIL = '[ENTITY] Delete all PurchaseRequisitionModels failed',

	UPDATE_PURCHASE_REQUISITION = '[ENTITY] Update PurchaseRequisitionModel',
	UPDATE_PURCHASE_REQUISITION_OK = '[ENTITY] Update PurchaseRequisitionModel successfully',
	UPDATE_PURCHASE_REQUISITION_FAIL = '[ENTITY] Update PurchaseRequisitionModel failed',

	UPDATE_ALL_PURCHASE_REQUISITION = '[ENTITY] Update all PurchaseRequisitionModel',
	UPDATE_ALL_PURCHASE_REQUISITION_OK = '[ENTITY] Update all PurchaseRequisitionModel successfully',
	UPDATE_ALL_PURCHASE_REQUISITION_FAIL = '[ENTITY] Update all PurchaseRequisitionModel failed',

	FETCH_PURCHASE_REQUISITION= '[ENTITY] Fetch PurchaseRequisitionModel',
	FETCH_PURCHASE_REQUISITION_OK = '[ENTITY] Fetch PurchaseRequisitionModel successfully',
	FETCH_PURCHASE_REQUISITION_FAIL = '[ENTITY] Fetch PurchaseRequisitionModel failed',

	FETCH_PURCHASE_REQUISITION_AUDIT= '[ENTITY] Fetch PurchaseRequisitionModel audit',
	FETCH_PURCHASE_REQUISITION_AUDIT_OK = '[ENTITY] Fetch PurchaseRequisitionModel audit successfully',
	FETCH_PURCHASE_REQUISITION_AUDIT_FAIL = '[ENTITY] Fetch PurchaseRequisitionModel audit failed',

	FETCH_PURCHASE_REQUISITION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PurchaseRequisitionModel audits by entity id',
	FETCH_PURCHASE_REQUISITION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PurchaseRequisitionModel audits by entity id successfully',
	FETCH_PURCHASE_REQUISITION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PurchaseRequisitionModel audits by entity id failed',

	FETCH_ALL_PURCHASE_REQUISITION = '[ENTITY] Fetch all PurchaseRequisitionModel',
	FETCH_ALL_PURCHASE_REQUISITION_OK = '[ENTITY] Fetch all PurchaseRequisitionModel successfully',
	FETCH_ALL_PURCHASE_REQUISITION_FAIL = '[ENTITY] Fetch all PurchaseRequisitionModel failed',

	FETCH_PURCHASE_REQUISITION_WITH_QUERY = '[ENTITY] Fetch PurchaseRequisitionModel with query',
	FETCH_PURCHASE_REQUISITION_WITH_QUERY_OK = '[ENTITY] Fetch PurchaseRequisitionModel with query successfully',
	FETCH_PURCHASE_REQUISITION_WITH_QUERY_FAIL = '[ENTITY] Fetch PurchaseRequisitionModel with query failed',

	FETCH_LAST_PURCHASE_REQUISITION_WITH_QUERY = '[ENTITY] Fetch last PurchaseRequisitionModel with query',
	FETCH_LAST_PURCHASE_REQUISITION_WITH_QUERY_OK = '[ENTITY] Fetch last PurchaseRequisitionModel with query successfully',
	FETCH_LAST_PURCHASE_REQUISITION_WITH_QUERY_FAIL = '[ENTITY] Fetch last PurchaseRequisitionModel with query failed',

	EXPORT_PURCHASE_REQUISITION = '[ENTITY] Export PurchaseRequisitionModel',
	EXPORT_PURCHASE_REQUISITION_OK = '[ENTITY] Export PurchaseRequisitionModel successfully',
	EXPORT_PURCHASE_REQUISITION_FAIL = '[ENTITY] Export PurchaseRequisitionModel failed',

	EXPORT_ALL_PURCHASE_REQUISITION = '[ENTITY] Export All PurchaseRequisitionModels',
	EXPORT_ALL_PURCHASE_REQUISITION_OK = '[ENTITY] Export All PurchaseRequisitionModels successfully',
	EXPORT_ALL_PURCHASE_REQUISITION_FAIL = '[ENTITY] Export All PurchaseRequisitionModels failed',

	EXPORT_PURCHASE_REQUISITION_EXCLUDING_IDS = '[ENTITY] Export PurchaseRequisitionModels excluding Ids',
	EXPORT_PURCHASE_REQUISITION_EXCLUDING_IDS_OK = '[ENTITY] Export PurchaseRequisitionModel excluding Ids successfully',
	EXPORT_PURCHASE_REQUISITION_EXCLUDING_IDS_FAIL = '[ENTITY] Export PurchaseRequisitionModel excluding Ids failed',

	COUNT_PURCHASE_REQUISITIONS = '[ENTITY] Fetch number of PurchaseRequisitionModel records',
	COUNT_PURCHASE_REQUISITIONS_OK = '[ENTITY] Fetch number of PurchaseRequisitionModel records successfully ',
	COUNT_PURCHASE_REQUISITIONS_FAIL = '[ENTITY] Fetch number of PurchaseRequisitionModel records failed',

	IMPORT_PURCHASE_REQUISITIONS = '[ENTITY] Import PurchaseRequisitionModels',
	IMPORT_PURCHASE_REQUISITIONS_OK = '[ENTITY] Import PurchaseRequisitionModels successfully',
	IMPORT_PURCHASE_REQUISITIONS_FAIL = '[ENTITY] Import PurchaseRequisitionModels fail',


	INITIALISE_PURCHASE_REQUISITION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PurchaseRequisitionModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePurchaseRequisitionAction implements Action {
	readonly className: string = 'PurchaseRequisitionModel';

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

export class PurchaseRequisitionAction extends BasePurchaseRequisitionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseRequisitionAction here] off begin
	// % protected region % [Add any additional class fields for PurchaseRequisitionAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchaseRequisitionModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionAction here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionAction here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionAction here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionAction here] end
	}

	// % protected region % [Add any additional class methods for PurchaseRequisitionAction here] off begin
	// % protected region % [Add any additional class methods for PurchaseRequisitionAction here] end
}

export class PurchaseRequisitionActionOK extends BasePurchaseRequisitionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseRequisitionActionOK here] off begin
	// % protected region % [Add any additional class fields for PurchaseRequisitionActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PurchaseRequisitionModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PurchaseRequisitionModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionActionOK here] end
	}

	// % protected region % [Add any additional class methods for PurchaseRequisitionActionOK here] off begin
	// % protected region % [Add any additional class methods for PurchaseRequisitionActionOK here] end
}

export class PurchaseRequisitionActionFail extends BasePurchaseRequisitionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PurchaseRequisitionActionFail here] off begin
	// % protected region % [Add any additional class fields for PurchaseRequisitionActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PurchaseRequisitionModel>,
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PurchaseRequisitionActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PurchaseRequisitionActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PurchaseRequisitionActionFail here] end
	}

	// % protected region % [Add any additional class methods for PurchaseRequisitionActionFail here] off begin
	// % protected region % [Add any additional class methods for PurchaseRequisitionActionFail here] end
}

export function isPurchaseRequisitionModelAction(e: any): e is BasePurchaseRequisitionAction {
	return Object.values(PurchaseRequisitionModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
