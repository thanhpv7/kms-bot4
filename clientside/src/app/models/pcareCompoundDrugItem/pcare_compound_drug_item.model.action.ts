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
import {PcareCompoundDrugItemModel} from './pcare_compound_drug_item.model';
import {PcareCompoundDrugItemModelAudit} from './pcare_compound_drug_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Compound Drug Item model actions to be dispatched by NgRx.
 */
export enum PcareCompoundDrugItemModelActionTypes {
	CREATE_PCARE_COMPOUND_DRUG_ITEM = '[ENTITY] Create PcareCompoundDrugItemModel',
	CREATE_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Create PcareCompoundDrugItemModel successfully',
	CREATE_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Create PcareCompoundDrugItemModel failed',

	CREATE_ALL_PCARE_COMPOUND_DRUG_ITEM = '[ENTITY] Create All PcareCompoundDrugItemModel',
	CREATE_ALL_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Create All PcareCompoundDrugItemModel successfully',
	CREATE_ALL_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Create All PcareCompoundDrugItemModel failed',

	DELETE_PCARE_COMPOUND_DRUG_ITEM = '[ENTITY] Delete PcareCompoundDrugItemModel',
	DELETE_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Delete PcareCompoundDrugItemModel successfully',
	DELETE_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Delete PcareCompoundDrugItemModel failed',


	DELETE_PCARE_COMPOUND_DRUG_ITEM_EXCLUDING_IDS = '[ENTITY] Delete PcareCompoundDrugItemModels Excluding Ids',
	DELETE_PCARE_COMPOUND_DRUG_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareCompoundDrugItemModels Excluding Ids successfully',
	DELETE_PCARE_COMPOUND_DRUG_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareCompoundDrugItemModels Excluding Ids failed',

	DELETE_ALL_PCARE_COMPOUND_DRUG_ITEM = '[ENTITY] Delete all PcareCompoundDrugItemModels',
	DELETE_ALL_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Delete all PcareCompoundDrugItemModels successfully',
	DELETE_ALL_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Delete all PcareCompoundDrugItemModels failed',

	UPDATE_PCARE_COMPOUND_DRUG_ITEM = '[ENTITY] Update PcareCompoundDrugItemModel',
	UPDATE_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Update PcareCompoundDrugItemModel successfully',
	UPDATE_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Update PcareCompoundDrugItemModel failed',

	UPDATE_ALL_PCARE_COMPOUND_DRUG_ITEM = '[ENTITY] Update all PcareCompoundDrugItemModel',
	UPDATE_ALL_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Update all PcareCompoundDrugItemModel successfully',
	UPDATE_ALL_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Update all PcareCompoundDrugItemModel failed',

	FETCH_PCARE_COMPOUND_DRUG_ITEM= '[ENTITY] Fetch PcareCompoundDrugItemModel',
	FETCH_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Fetch PcareCompoundDrugItemModel successfully',
	FETCH_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Fetch PcareCompoundDrugItemModel failed',

	FETCH_PCARE_COMPOUND_DRUG_ITEM_AUDIT= '[ENTITY] Fetch PcareCompoundDrugItemModel audit',
	FETCH_PCARE_COMPOUND_DRUG_ITEM_AUDIT_OK = '[ENTITY] Fetch PcareCompoundDrugItemModel audit successfully',
	FETCH_PCARE_COMPOUND_DRUG_ITEM_AUDIT_FAIL = '[ENTITY] Fetch PcareCompoundDrugItemModel audit failed',

	FETCH_PCARE_COMPOUND_DRUG_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareCompoundDrugItemModel audits by entity id',
	FETCH_PCARE_COMPOUND_DRUG_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareCompoundDrugItemModel audits by entity id successfully',
	FETCH_PCARE_COMPOUND_DRUG_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareCompoundDrugItemModel audits by entity id failed',

	FETCH_ALL_PCARE_COMPOUND_DRUG_ITEM = '[ENTITY] Fetch all PcareCompoundDrugItemModel',
	FETCH_ALL_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Fetch all PcareCompoundDrugItemModel successfully',
	FETCH_ALL_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Fetch all PcareCompoundDrugItemModel failed',

	FETCH_PCARE_COMPOUND_DRUG_ITEM_WITH_QUERY = '[ENTITY] Fetch PcareCompoundDrugItemModel with query',
	FETCH_PCARE_COMPOUND_DRUG_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch PcareCompoundDrugItemModel with query successfully',
	FETCH_PCARE_COMPOUND_DRUG_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareCompoundDrugItemModel with query failed',

	FETCH_LAST_PCARE_COMPOUND_DRUG_ITEM_WITH_QUERY = '[ENTITY] Fetch last PcareCompoundDrugItemModel with query',
	FETCH_LAST_PCARE_COMPOUND_DRUG_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last PcareCompoundDrugItemModel with query successfully',
	FETCH_LAST_PCARE_COMPOUND_DRUG_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareCompoundDrugItemModel with query failed',

	EXPORT_PCARE_COMPOUND_DRUG_ITEM = '[ENTITY] Export PcareCompoundDrugItemModel',
	EXPORT_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Export PcareCompoundDrugItemModel successfully',
	EXPORT_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Export PcareCompoundDrugItemModel failed',

	EXPORT_ALL_PCARE_COMPOUND_DRUG_ITEM = '[ENTITY] Export All PcareCompoundDrugItemModels',
	EXPORT_ALL_PCARE_COMPOUND_DRUG_ITEM_OK = '[ENTITY] Export All PcareCompoundDrugItemModels successfully',
	EXPORT_ALL_PCARE_COMPOUND_DRUG_ITEM_FAIL = '[ENTITY] Export All PcareCompoundDrugItemModels failed',

	EXPORT_PCARE_COMPOUND_DRUG_ITEM_EXCLUDING_IDS = '[ENTITY] Export PcareCompoundDrugItemModels excluding Ids',
	EXPORT_PCARE_COMPOUND_DRUG_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export PcareCompoundDrugItemModel excluding Ids successfully',
	EXPORT_PCARE_COMPOUND_DRUG_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareCompoundDrugItemModel excluding Ids failed',

	COUNT_PCARE_COMPOUND_DRUG_ITEMS = '[ENTITY] Fetch number of PcareCompoundDrugItemModel records',
	COUNT_PCARE_COMPOUND_DRUG_ITEMS_OK = '[ENTITY] Fetch number of PcareCompoundDrugItemModel records successfully ',
	COUNT_PCARE_COMPOUND_DRUG_ITEMS_FAIL = '[ENTITY] Fetch number of PcareCompoundDrugItemModel records failed',

	IMPORT_PCARE_COMPOUND_DRUG_ITEMS = '[ENTITY] Import PcareCompoundDrugItemModels',
	IMPORT_PCARE_COMPOUND_DRUG_ITEMS_OK = '[ENTITY] Import PcareCompoundDrugItemModels successfully',
	IMPORT_PCARE_COMPOUND_DRUG_ITEMS_FAIL = '[ENTITY] Import PcareCompoundDrugItemModels fail',


	INITIALISE_PCARE_COMPOUND_DRUG_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareCompoundDrugItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareCompoundDrugItemAction implements Action {
	readonly className: string = 'PcareCompoundDrugItemModel';

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

export class PcareCompoundDrugItemAction extends BasePcareCompoundDrugItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareCompoundDrugItemAction here] off begin
	// % protected region % [Add any additional class fields for PcareCompoundDrugItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareCompoundDrugItemModel>,
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugItemAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugItemAction here] end
	}

	// % protected region % [Add any additional class methods for PcareCompoundDrugItemAction here] off begin
	// % protected region % [Add any additional class methods for PcareCompoundDrugItemAction here] end
}

export class PcareCompoundDrugItemActionOK extends BasePcareCompoundDrugItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareCompoundDrugItemActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareCompoundDrugItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareCompoundDrugItemModel>,
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareCompoundDrugItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareCompoundDrugItemActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareCompoundDrugItemActionOK here] end
}

export class PcareCompoundDrugItemActionFail extends BasePcareCompoundDrugItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareCompoundDrugItemActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareCompoundDrugItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareCompoundDrugItemModel>,
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareCompoundDrugItemActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareCompoundDrugItemActionFail here] end
}

export function isPcareCompoundDrugItemModelAction(e: any): e is BasePcareCompoundDrugItemAction {
	return Object.values(PcareCompoundDrugItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
