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
import {CompoundPrescriptionItemModel} from './compound_prescription_item.model';
import {CompoundPrescriptionItemModelAudit} from './compound_prescription_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Compound Prescription Item model actions to be dispatched by NgRx.
 */
export enum CompoundPrescriptionItemModelActionTypes {
	CREATE_COMPOUND_PRESCRIPTION_ITEM = '[ENTITY] Create CompoundPrescriptionItemModel',
	CREATE_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Create CompoundPrescriptionItemModel successfully',
	CREATE_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Create CompoundPrescriptionItemModel failed',

	CREATE_ALL_COMPOUND_PRESCRIPTION_ITEM = '[ENTITY] Create All CompoundPrescriptionItemModel',
	CREATE_ALL_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Create All CompoundPrescriptionItemModel successfully',
	CREATE_ALL_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Create All CompoundPrescriptionItemModel failed',

	DELETE_COMPOUND_PRESCRIPTION_ITEM = '[ENTITY] Delete CompoundPrescriptionItemModel',
	DELETE_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Delete CompoundPrescriptionItemModel successfully',
	DELETE_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Delete CompoundPrescriptionItemModel failed',


	DELETE_COMPOUND_PRESCRIPTION_ITEM_EXCLUDING_IDS = '[ENTITY] Delete CompoundPrescriptionItemModels Excluding Ids',
	DELETE_COMPOUND_PRESCRIPTION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete CompoundPrescriptionItemModels Excluding Ids successfully',
	DELETE_COMPOUND_PRESCRIPTION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CompoundPrescriptionItemModels Excluding Ids failed',

	DELETE_ALL_COMPOUND_PRESCRIPTION_ITEM = '[ENTITY] Delete all CompoundPrescriptionItemModels',
	DELETE_ALL_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Delete all CompoundPrescriptionItemModels successfully',
	DELETE_ALL_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Delete all CompoundPrescriptionItemModels failed',

	UPDATE_COMPOUND_PRESCRIPTION_ITEM = '[ENTITY] Update CompoundPrescriptionItemModel',
	UPDATE_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Update CompoundPrescriptionItemModel successfully',
	UPDATE_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Update CompoundPrescriptionItemModel failed',

	UPDATE_ALL_COMPOUND_PRESCRIPTION_ITEM = '[ENTITY] Update all CompoundPrescriptionItemModel',
	UPDATE_ALL_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Update all CompoundPrescriptionItemModel successfully',
	UPDATE_ALL_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Update all CompoundPrescriptionItemModel failed',

	FETCH_COMPOUND_PRESCRIPTION_ITEM= '[ENTITY] Fetch CompoundPrescriptionItemModel',
	FETCH_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Fetch CompoundPrescriptionItemModel successfully',
	FETCH_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Fetch CompoundPrescriptionItemModel failed',

	FETCH_COMPOUND_PRESCRIPTION_ITEM_AUDIT= '[ENTITY] Fetch CompoundPrescriptionItemModel audit',
	FETCH_COMPOUND_PRESCRIPTION_ITEM_AUDIT_OK = '[ENTITY] Fetch CompoundPrescriptionItemModel audit successfully',
	FETCH_COMPOUND_PRESCRIPTION_ITEM_AUDIT_FAIL = '[ENTITY] Fetch CompoundPrescriptionItemModel audit failed',

	FETCH_COMPOUND_PRESCRIPTION_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CompoundPrescriptionItemModel audits by entity id',
	FETCH_COMPOUND_PRESCRIPTION_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CompoundPrescriptionItemModel audits by entity id successfully',
	FETCH_COMPOUND_PRESCRIPTION_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CompoundPrescriptionItemModel audits by entity id failed',

	FETCH_ALL_COMPOUND_PRESCRIPTION_ITEM = '[ENTITY] Fetch all CompoundPrescriptionItemModel',
	FETCH_ALL_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Fetch all CompoundPrescriptionItemModel successfully',
	FETCH_ALL_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Fetch all CompoundPrescriptionItemModel failed',

	FETCH_COMPOUND_PRESCRIPTION_ITEM_WITH_QUERY = '[ENTITY] Fetch CompoundPrescriptionItemModel with query',
	FETCH_COMPOUND_PRESCRIPTION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch CompoundPrescriptionItemModel with query successfully',
	FETCH_COMPOUND_PRESCRIPTION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch CompoundPrescriptionItemModel with query failed',

	FETCH_LAST_COMPOUND_PRESCRIPTION_ITEM_WITH_QUERY = '[ENTITY] Fetch last CompoundPrescriptionItemModel with query',
	FETCH_LAST_COMPOUND_PRESCRIPTION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last CompoundPrescriptionItemModel with query successfully',
	FETCH_LAST_COMPOUND_PRESCRIPTION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last CompoundPrescriptionItemModel with query failed',

	EXPORT_COMPOUND_PRESCRIPTION_ITEM = '[ENTITY] Export CompoundPrescriptionItemModel',
	EXPORT_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Export CompoundPrescriptionItemModel successfully',
	EXPORT_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Export CompoundPrescriptionItemModel failed',

	EXPORT_ALL_COMPOUND_PRESCRIPTION_ITEM = '[ENTITY] Export All CompoundPrescriptionItemModels',
	EXPORT_ALL_COMPOUND_PRESCRIPTION_ITEM_OK = '[ENTITY] Export All CompoundPrescriptionItemModels successfully',
	EXPORT_ALL_COMPOUND_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Export All CompoundPrescriptionItemModels failed',

	EXPORT_COMPOUND_PRESCRIPTION_ITEM_EXCLUDING_IDS = '[ENTITY] Export CompoundPrescriptionItemModels excluding Ids',
	EXPORT_COMPOUND_PRESCRIPTION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export CompoundPrescriptionItemModel excluding Ids successfully',
	EXPORT_COMPOUND_PRESCRIPTION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export CompoundPrescriptionItemModel excluding Ids failed',

	COUNT_COMPOUND_PRESCRIPTION_ITEMS = '[ENTITY] Fetch number of CompoundPrescriptionItemModel records',
	COUNT_COMPOUND_PRESCRIPTION_ITEMS_OK = '[ENTITY] Fetch number of CompoundPrescriptionItemModel records successfully ',
	COUNT_COMPOUND_PRESCRIPTION_ITEMS_FAIL = '[ENTITY] Fetch number of CompoundPrescriptionItemModel records failed',

	IMPORT_COMPOUND_PRESCRIPTION_ITEMS = '[ENTITY] Import CompoundPrescriptionItemModels',
	IMPORT_COMPOUND_PRESCRIPTION_ITEMS_OK = '[ENTITY] Import CompoundPrescriptionItemModels successfully',
	IMPORT_COMPOUND_PRESCRIPTION_ITEMS_FAIL = '[ENTITY] Import CompoundPrescriptionItemModels fail',


	INITIALISE_COMPOUND_PRESCRIPTION_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CompoundPrescriptionItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCompoundPrescriptionItemAction implements Action {
	readonly className: string = 'CompoundPrescriptionItemModel';

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

export class CompoundPrescriptionItemAction extends BaseCompoundPrescriptionItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CompoundPrescriptionItemAction here] off begin
	// % protected region % [Add any additional class fields for CompoundPrescriptionItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CompoundPrescriptionItemModel>,
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionItemAction here] off begin
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionItemAction here] end
	}

	// % protected region % [Add any additional class methods for CompoundPrescriptionItemAction here] off begin
	// % protected region % [Add any additional class methods for CompoundPrescriptionItemAction here] end
}

export class CompoundPrescriptionItemActionOK extends BaseCompoundPrescriptionItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CompoundPrescriptionItemActionOK here] off begin
	// % protected region % [Add any additional class fields for CompoundPrescriptionItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CompoundPrescriptionItemModel>,
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CompoundPrescriptionItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for CompoundPrescriptionItemActionOK here] off begin
	// % protected region % [Add any additional class methods for CompoundPrescriptionItemActionOK here] end
}

export class CompoundPrescriptionItemActionFail extends BaseCompoundPrescriptionItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CompoundPrescriptionItemActionFail here] off begin
	// % protected region % [Add any additional class fields for CompoundPrescriptionItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CompoundPrescriptionItemModel>,
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for CompoundPrescriptionItemActionFail here] off begin
	// % protected region % [Add any additional class methods for CompoundPrescriptionItemActionFail here] end
}

export function isCompoundPrescriptionItemModelAction(e: any): e is BaseCompoundPrescriptionItemAction {
	return Object.values(CompoundPrescriptionItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
