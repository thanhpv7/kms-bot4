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
import {PrescriptionItemModel} from './prescription_item.model';
import {PrescriptionItemModelAudit} from './prescription_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Prescription Item model actions to be dispatched by NgRx.
 */
export enum PrescriptionItemModelActionTypes {
	CREATE_PRESCRIPTION_ITEM = '[ENTITY] Create PrescriptionItemModel',
	CREATE_PRESCRIPTION_ITEM_OK = '[ENTITY] Create PrescriptionItemModel successfully',
	CREATE_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Create PrescriptionItemModel failed',

	CREATE_ALL_PRESCRIPTION_ITEM = '[ENTITY] Create All PrescriptionItemModel',
	CREATE_ALL_PRESCRIPTION_ITEM_OK = '[ENTITY] Create All PrescriptionItemModel successfully',
	CREATE_ALL_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Create All PrescriptionItemModel failed',

	DELETE_PRESCRIPTION_ITEM = '[ENTITY] Delete PrescriptionItemModel',
	DELETE_PRESCRIPTION_ITEM_OK = '[ENTITY] Delete PrescriptionItemModel successfully',
	DELETE_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Delete PrescriptionItemModel failed',


	DELETE_PRESCRIPTION_ITEM_EXCLUDING_IDS = '[ENTITY] Delete PrescriptionItemModels Excluding Ids',
	DELETE_PRESCRIPTION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete PrescriptionItemModels Excluding Ids successfully',
	DELETE_PRESCRIPTION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PrescriptionItemModels Excluding Ids failed',

	DELETE_ALL_PRESCRIPTION_ITEM = '[ENTITY] Delete all PrescriptionItemModels',
	DELETE_ALL_PRESCRIPTION_ITEM_OK = '[ENTITY] Delete all PrescriptionItemModels successfully',
	DELETE_ALL_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Delete all PrescriptionItemModels failed',

	UPDATE_PRESCRIPTION_ITEM = '[ENTITY] Update PrescriptionItemModel',
	UPDATE_PRESCRIPTION_ITEM_OK = '[ENTITY] Update PrescriptionItemModel successfully',
	UPDATE_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Update PrescriptionItemModel failed',

	UPDATE_ALL_PRESCRIPTION_ITEM = '[ENTITY] Update all PrescriptionItemModel',
	UPDATE_ALL_PRESCRIPTION_ITEM_OK = '[ENTITY] Update all PrescriptionItemModel successfully',
	UPDATE_ALL_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Update all PrescriptionItemModel failed',

	FETCH_PRESCRIPTION_ITEM= '[ENTITY] Fetch PrescriptionItemModel',
	FETCH_PRESCRIPTION_ITEM_OK = '[ENTITY] Fetch PrescriptionItemModel successfully',
	FETCH_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Fetch PrescriptionItemModel failed',

	FETCH_PRESCRIPTION_ITEM_AUDIT= '[ENTITY] Fetch PrescriptionItemModel audit',
	FETCH_PRESCRIPTION_ITEM_AUDIT_OK = '[ENTITY] Fetch PrescriptionItemModel audit successfully',
	FETCH_PRESCRIPTION_ITEM_AUDIT_FAIL = '[ENTITY] Fetch PrescriptionItemModel audit failed',

	FETCH_PRESCRIPTION_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PrescriptionItemModel audits by entity id',
	FETCH_PRESCRIPTION_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PrescriptionItemModel audits by entity id successfully',
	FETCH_PRESCRIPTION_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PrescriptionItemModel audits by entity id failed',

	FETCH_ALL_PRESCRIPTION_ITEM = '[ENTITY] Fetch all PrescriptionItemModel',
	FETCH_ALL_PRESCRIPTION_ITEM_OK = '[ENTITY] Fetch all PrescriptionItemModel successfully',
	FETCH_ALL_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Fetch all PrescriptionItemModel failed',

	FETCH_PRESCRIPTION_ITEM_WITH_QUERY = '[ENTITY] Fetch PrescriptionItemModel with query',
	FETCH_PRESCRIPTION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch PrescriptionItemModel with query successfully',
	FETCH_PRESCRIPTION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch PrescriptionItemModel with query failed',

	FETCH_LAST_PRESCRIPTION_ITEM_WITH_QUERY = '[ENTITY] Fetch last PrescriptionItemModel with query',
	FETCH_LAST_PRESCRIPTION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last PrescriptionItemModel with query successfully',
	FETCH_LAST_PRESCRIPTION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last PrescriptionItemModel with query failed',

	EXPORT_PRESCRIPTION_ITEM = '[ENTITY] Export PrescriptionItemModel',
	EXPORT_PRESCRIPTION_ITEM_OK = '[ENTITY] Export PrescriptionItemModel successfully',
	EXPORT_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Export PrescriptionItemModel failed',

	EXPORT_ALL_PRESCRIPTION_ITEM = '[ENTITY] Export All PrescriptionItemModels',
	EXPORT_ALL_PRESCRIPTION_ITEM_OK = '[ENTITY] Export All PrescriptionItemModels successfully',
	EXPORT_ALL_PRESCRIPTION_ITEM_FAIL = '[ENTITY] Export All PrescriptionItemModels failed',

	EXPORT_PRESCRIPTION_ITEM_EXCLUDING_IDS = '[ENTITY] Export PrescriptionItemModels excluding Ids',
	EXPORT_PRESCRIPTION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export PrescriptionItemModel excluding Ids successfully',
	EXPORT_PRESCRIPTION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export PrescriptionItemModel excluding Ids failed',

	COUNT_PRESCRIPTION_ITEMS = '[ENTITY] Fetch number of PrescriptionItemModel records',
	COUNT_PRESCRIPTION_ITEMS_OK = '[ENTITY] Fetch number of PrescriptionItemModel records successfully ',
	COUNT_PRESCRIPTION_ITEMS_FAIL = '[ENTITY] Fetch number of PrescriptionItemModel records failed',

	IMPORT_PRESCRIPTION_ITEMS = '[ENTITY] Import PrescriptionItemModels',
	IMPORT_PRESCRIPTION_ITEMS_OK = '[ENTITY] Import PrescriptionItemModels successfully',
	IMPORT_PRESCRIPTION_ITEMS_FAIL = '[ENTITY] Import PrescriptionItemModels fail',


	INITIALISE_PRESCRIPTION_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PrescriptionItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePrescriptionItemAction implements Action {
	readonly className: string = 'PrescriptionItemModel';

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

export class PrescriptionItemAction extends BasePrescriptionItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrescriptionItemAction here] off begin
	// % protected region % [Add any additional class fields for PrescriptionItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PrescriptionItemModel>,
		// % protected region % [Add any additional constructor parameters for PrescriptionItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for PrescriptionItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrescriptionItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for PrescriptionItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrescriptionItemAction here] off begin
		// % protected region % [Add any additional constructor logic for PrescriptionItemAction here] end
	}

	// % protected region % [Add any additional class methods for PrescriptionItemAction here] off begin
	// % protected region % [Add any additional class methods for PrescriptionItemAction here] end
}

export class PrescriptionItemActionOK extends BasePrescriptionItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrescriptionItemActionOK here] off begin
	// % protected region % [Add any additional class fields for PrescriptionItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PrescriptionItemModel>,
		// % protected region % [Add any additional constructor parameters for PrescriptionItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PrescriptionItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PrescriptionItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrescriptionItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PrescriptionItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrescriptionItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PrescriptionItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for PrescriptionItemActionOK here] off begin
	// % protected region % [Add any additional class methods for PrescriptionItemActionOK here] end
}

export class PrescriptionItemActionFail extends BasePrescriptionItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrescriptionItemActionFail here] off begin
	// % protected region % [Add any additional class fields for PrescriptionItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PrescriptionItemModel>,
		// % protected region % [Add any additional constructor parameters for PrescriptionItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PrescriptionItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrescriptionItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PrescriptionItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrescriptionItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PrescriptionItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for PrescriptionItemActionFail here] off begin
	// % protected region % [Add any additional class methods for PrescriptionItemActionFail here] end
}

export function isPrescriptionItemModelAction(e: any): e is BasePrescriptionItemAction {
	return Object.values(PrescriptionItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
