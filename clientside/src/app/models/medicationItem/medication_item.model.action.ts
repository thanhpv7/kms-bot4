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
import {MedicationItemModel} from './medication_item.model';
import {MedicationItemModelAudit} from './medication_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medication Item model actions to be dispatched by NgRx.
 */
export enum MedicationItemModelActionTypes {
	CREATE_MEDICATION_ITEM = '[ENTITY] Create MedicationItemModel',
	CREATE_MEDICATION_ITEM_OK = '[ENTITY] Create MedicationItemModel successfully',
	CREATE_MEDICATION_ITEM_FAIL = '[ENTITY] Create MedicationItemModel failed',

	CREATE_ALL_MEDICATION_ITEM = '[ENTITY] Create All MedicationItemModel',
	CREATE_ALL_MEDICATION_ITEM_OK = '[ENTITY] Create All MedicationItemModel successfully',
	CREATE_ALL_MEDICATION_ITEM_FAIL = '[ENTITY] Create All MedicationItemModel failed',

	DELETE_MEDICATION_ITEM = '[ENTITY] Delete MedicationItemModel',
	DELETE_MEDICATION_ITEM_OK = '[ENTITY] Delete MedicationItemModel successfully',
	DELETE_MEDICATION_ITEM_FAIL = '[ENTITY] Delete MedicationItemModel failed',


	DELETE_MEDICATION_ITEM_EXCLUDING_IDS = '[ENTITY] Delete MedicationItemModels Excluding Ids',
	DELETE_MEDICATION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicationItemModels Excluding Ids successfully',
	DELETE_MEDICATION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicationItemModels Excluding Ids failed',

	DELETE_ALL_MEDICATION_ITEM = '[ENTITY] Delete all MedicationItemModels',
	DELETE_ALL_MEDICATION_ITEM_OK = '[ENTITY] Delete all MedicationItemModels successfully',
	DELETE_ALL_MEDICATION_ITEM_FAIL = '[ENTITY] Delete all MedicationItemModels failed',

	UPDATE_MEDICATION_ITEM = '[ENTITY] Update MedicationItemModel',
	UPDATE_MEDICATION_ITEM_OK = '[ENTITY] Update MedicationItemModel successfully',
	UPDATE_MEDICATION_ITEM_FAIL = '[ENTITY] Update MedicationItemModel failed',

	UPDATE_ALL_MEDICATION_ITEM = '[ENTITY] Update all MedicationItemModel',
	UPDATE_ALL_MEDICATION_ITEM_OK = '[ENTITY] Update all MedicationItemModel successfully',
	UPDATE_ALL_MEDICATION_ITEM_FAIL = '[ENTITY] Update all MedicationItemModel failed',

	FETCH_MEDICATION_ITEM= '[ENTITY] Fetch MedicationItemModel',
	FETCH_MEDICATION_ITEM_OK = '[ENTITY] Fetch MedicationItemModel successfully',
	FETCH_MEDICATION_ITEM_FAIL = '[ENTITY] Fetch MedicationItemModel failed',

	FETCH_MEDICATION_ITEM_AUDIT= '[ENTITY] Fetch MedicationItemModel audit',
	FETCH_MEDICATION_ITEM_AUDIT_OK = '[ENTITY] Fetch MedicationItemModel audit successfully',
	FETCH_MEDICATION_ITEM_AUDIT_FAIL = '[ENTITY] Fetch MedicationItemModel audit failed',

	FETCH_MEDICATION_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicationItemModel audits by entity id',
	FETCH_MEDICATION_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicationItemModel audits by entity id successfully',
	FETCH_MEDICATION_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicationItemModel audits by entity id failed',

	FETCH_ALL_MEDICATION_ITEM = '[ENTITY] Fetch all MedicationItemModel',
	FETCH_ALL_MEDICATION_ITEM_OK = '[ENTITY] Fetch all MedicationItemModel successfully',
	FETCH_ALL_MEDICATION_ITEM_FAIL = '[ENTITY] Fetch all MedicationItemModel failed',

	FETCH_MEDICATION_ITEM_WITH_QUERY = '[ENTITY] Fetch MedicationItemModel with query',
	FETCH_MEDICATION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch MedicationItemModel with query successfully',
	FETCH_MEDICATION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicationItemModel with query failed',

	FETCH_LAST_MEDICATION_ITEM_WITH_QUERY = '[ENTITY] Fetch last MedicationItemModel with query',
	FETCH_LAST_MEDICATION_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last MedicationItemModel with query successfully',
	FETCH_LAST_MEDICATION_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicationItemModel with query failed',

	EXPORT_MEDICATION_ITEM = '[ENTITY] Export MedicationItemModel',
	EXPORT_MEDICATION_ITEM_OK = '[ENTITY] Export MedicationItemModel successfully',
	EXPORT_MEDICATION_ITEM_FAIL = '[ENTITY] Export MedicationItemModel failed',

	EXPORT_ALL_MEDICATION_ITEM = '[ENTITY] Export All MedicationItemModels',
	EXPORT_ALL_MEDICATION_ITEM_OK = '[ENTITY] Export All MedicationItemModels successfully',
	EXPORT_ALL_MEDICATION_ITEM_FAIL = '[ENTITY] Export All MedicationItemModels failed',

	EXPORT_MEDICATION_ITEM_EXCLUDING_IDS = '[ENTITY] Export MedicationItemModels excluding Ids',
	EXPORT_MEDICATION_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export MedicationItemModel excluding Ids successfully',
	EXPORT_MEDICATION_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicationItemModel excluding Ids failed',

	COUNT_MEDICATION_ITEMS = '[ENTITY] Fetch number of MedicationItemModel records',
	COUNT_MEDICATION_ITEMS_OK = '[ENTITY] Fetch number of MedicationItemModel records successfully ',
	COUNT_MEDICATION_ITEMS_FAIL = '[ENTITY] Fetch number of MedicationItemModel records failed',

	IMPORT_MEDICATION_ITEMS = '[ENTITY] Import MedicationItemModels',
	IMPORT_MEDICATION_ITEMS_OK = '[ENTITY] Import MedicationItemModels successfully',
	IMPORT_MEDICATION_ITEMS_FAIL = '[ENTITY] Import MedicationItemModels fail',


	INITIALISE_MEDICATION_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicationItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicationItemAction implements Action {
	readonly className: string = 'MedicationItemModel';

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

export class MedicationItemAction extends BaseMedicationItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationItemAction here] off begin
	// % protected region % [Add any additional class fields for MedicationItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicationItemModel>,
		// % protected region % [Add any additional constructor parameters for MedicationItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationItemAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicationItemAction here] end
	}

	// % protected region % [Add any additional class methods for MedicationItemAction here] off begin
	// % protected region % [Add any additional class methods for MedicationItemAction here] end
}

export class MedicationItemActionOK extends BaseMedicationItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationItemActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicationItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicationItemModel>,
		// % protected region % [Add any additional constructor parameters for MedicationItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicationItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicationItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicationItemActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicationItemActionOK here] end
}

export class MedicationItemActionFail extends BaseMedicationItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationItemActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicationItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicationItemModel>,
		// % protected region % [Add any additional constructor parameters for MedicationItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicationItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicationItemActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicationItemActionFail here] end
}

export function isMedicationItemModelAction(e: any): e is BaseMedicationItemAction {
	return Object.values(MedicationItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
