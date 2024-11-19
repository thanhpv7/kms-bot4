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
import {SampleCollectionItemsModel} from './sample_collection_items.model';
import {SampleCollectionItemsModelAudit} from './sample_collection_items.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Sample Collection Items model actions to be dispatched by NgRx.
 */
export enum SampleCollectionItemsModelActionTypes {
	CREATE_SAMPLE_COLLECTION_ITEMS = '[ENTITY] Create SampleCollectionItemsModel',
	CREATE_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Create SampleCollectionItemsModel successfully',
	CREATE_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Create SampleCollectionItemsModel failed',

	CREATE_ALL_SAMPLE_COLLECTION_ITEMS = '[ENTITY] Create All SampleCollectionItemsModel',
	CREATE_ALL_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Create All SampleCollectionItemsModel successfully',
	CREATE_ALL_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Create All SampleCollectionItemsModel failed',

	DELETE_SAMPLE_COLLECTION_ITEMS = '[ENTITY] Delete SampleCollectionItemsModel',
	DELETE_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Delete SampleCollectionItemsModel successfully',
	DELETE_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Delete SampleCollectionItemsModel failed',


	DELETE_SAMPLE_COLLECTION_ITEMS_EXCLUDING_IDS = '[ENTITY] Delete SampleCollectionItemsModels Excluding Ids',
	DELETE_SAMPLE_COLLECTION_ITEMS_EXCLUDING_IDS_OK = '[ENTITY] Delete SampleCollectionItemsModels Excluding Ids successfully',
	DELETE_SAMPLE_COLLECTION_ITEMS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete SampleCollectionItemsModels Excluding Ids failed',

	DELETE_ALL_SAMPLE_COLLECTION_ITEMS = '[ENTITY] Delete all SampleCollectionItemsModels',
	DELETE_ALL_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Delete all SampleCollectionItemsModels successfully',
	DELETE_ALL_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Delete all SampleCollectionItemsModels failed',

	UPDATE_SAMPLE_COLLECTION_ITEMS = '[ENTITY] Update SampleCollectionItemsModel',
	UPDATE_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Update SampleCollectionItemsModel successfully',
	UPDATE_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Update SampleCollectionItemsModel failed',

	UPDATE_ALL_SAMPLE_COLLECTION_ITEMS = '[ENTITY] Update all SampleCollectionItemsModel',
	UPDATE_ALL_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Update all SampleCollectionItemsModel successfully',
	UPDATE_ALL_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Update all SampleCollectionItemsModel failed',

	FETCH_SAMPLE_COLLECTION_ITEMS= '[ENTITY] Fetch SampleCollectionItemsModel',
	FETCH_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Fetch SampleCollectionItemsModel successfully',
	FETCH_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Fetch SampleCollectionItemsModel failed',

	FETCH_SAMPLE_COLLECTION_ITEMS_AUDIT= '[ENTITY] Fetch SampleCollectionItemsModel audit',
	FETCH_SAMPLE_COLLECTION_ITEMS_AUDIT_OK = '[ENTITY] Fetch SampleCollectionItemsModel audit successfully',
	FETCH_SAMPLE_COLLECTION_ITEMS_AUDIT_FAIL = '[ENTITY] Fetch SampleCollectionItemsModel audit failed',

	FETCH_SAMPLE_COLLECTION_ITEMS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch SampleCollectionItemsModel audits by entity id',
	FETCH_SAMPLE_COLLECTION_ITEMS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch SampleCollectionItemsModel audits by entity id successfully',
	FETCH_SAMPLE_COLLECTION_ITEMS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch SampleCollectionItemsModel audits by entity id failed',

	FETCH_ALL_SAMPLE_COLLECTION_ITEMS = '[ENTITY] Fetch all SampleCollectionItemsModel',
	FETCH_ALL_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Fetch all SampleCollectionItemsModel successfully',
	FETCH_ALL_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Fetch all SampleCollectionItemsModel failed',

	FETCH_SAMPLE_COLLECTION_ITEMS_WITH_QUERY = '[ENTITY] Fetch SampleCollectionItemsModel with query',
	FETCH_SAMPLE_COLLECTION_ITEMS_WITH_QUERY_OK = '[ENTITY] Fetch SampleCollectionItemsModel with query successfully',
	FETCH_SAMPLE_COLLECTION_ITEMS_WITH_QUERY_FAIL = '[ENTITY] Fetch SampleCollectionItemsModel with query failed',

	FETCH_LAST_SAMPLE_COLLECTION_ITEMS_WITH_QUERY = '[ENTITY] Fetch last SampleCollectionItemsModel with query',
	FETCH_LAST_SAMPLE_COLLECTION_ITEMS_WITH_QUERY_OK = '[ENTITY] Fetch last SampleCollectionItemsModel with query successfully',
	FETCH_LAST_SAMPLE_COLLECTION_ITEMS_WITH_QUERY_FAIL = '[ENTITY] Fetch last SampleCollectionItemsModel with query failed',

	EXPORT_SAMPLE_COLLECTION_ITEMS = '[ENTITY] Export SampleCollectionItemsModel',
	EXPORT_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Export SampleCollectionItemsModel successfully',
	EXPORT_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Export SampleCollectionItemsModel failed',

	EXPORT_ALL_SAMPLE_COLLECTION_ITEMS = '[ENTITY] Export All SampleCollectionItemsModels',
	EXPORT_ALL_SAMPLE_COLLECTION_ITEMS_OK = '[ENTITY] Export All SampleCollectionItemsModels successfully',
	EXPORT_ALL_SAMPLE_COLLECTION_ITEMS_FAIL = '[ENTITY] Export All SampleCollectionItemsModels failed',

	EXPORT_SAMPLE_COLLECTION_ITEMS_EXCLUDING_IDS = '[ENTITY] Export SampleCollectionItemsModels excluding Ids',
	EXPORT_SAMPLE_COLLECTION_ITEMS_EXCLUDING_IDS_OK = '[ENTITY] Export SampleCollectionItemsModel excluding Ids successfully',
	EXPORT_SAMPLE_COLLECTION_ITEMS_EXCLUDING_IDS_FAIL = '[ENTITY] Export SampleCollectionItemsModel excluding Ids failed',

	COUNT_SAMPLE_COLLECTION_ITEMSS = '[ENTITY] Fetch number of SampleCollectionItemsModel records',
	COUNT_SAMPLE_COLLECTION_ITEMSS_OK = '[ENTITY] Fetch number of SampleCollectionItemsModel records successfully ',
	COUNT_SAMPLE_COLLECTION_ITEMSS_FAIL = '[ENTITY] Fetch number of SampleCollectionItemsModel records failed',

	IMPORT_SAMPLE_COLLECTION_ITEMSS = '[ENTITY] Import SampleCollectionItemsModels',
	IMPORT_SAMPLE_COLLECTION_ITEMSS_OK = '[ENTITY] Import SampleCollectionItemsModels successfully',
	IMPORT_SAMPLE_COLLECTION_ITEMSS_FAIL = '[ENTITY] Import SampleCollectionItemsModels fail',


	INITIALISE_SAMPLE_COLLECTION_ITEMS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of SampleCollectionItemsModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseSampleCollectionItemsAction implements Action {
	readonly className: string = 'SampleCollectionItemsModel';

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

export class SampleCollectionItemsAction extends BaseSampleCollectionItemsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SampleCollectionItemsAction here] off begin
	// % protected region % [Add any additional class fields for SampleCollectionItemsAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SampleCollectionItemsModel>,
		// % protected region % [Add any additional constructor parameters for SampleCollectionItemsAction here] off begin
		// % protected region % [Add any additional constructor parameters for SampleCollectionItemsAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SampleCollectionItemsAction here] off begin
			// % protected region % [Add any additional constructor arguments for SampleCollectionItemsAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SampleCollectionItemsAction here] off begin
		// % protected region % [Add any additional constructor logic for SampleCollectionItemsAction here] end
	}

	// % protected region % [Add any additional class methods for SampleCollectionItemsAction here] off begin
	// % protected region % [Add any additional class methods for SampleCollectionItemsAction here] end
}

export class SampleCollectionItemsActionOK extends BaseSampleCollectionItemsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SampleCollectionItemsActionOK here] off begin
	// % protected region % [Add any additional class fields for SampleCollectionItemsActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SampleCollectionItemsModel>,
		// % protected region % [Add any additional constructor parameters for SampleCollectionItemsActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for SampleCollectionItemsActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: SampleCollectionItemsModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SampleCollectionItemsActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for SampleCollectionItemsActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SampleCollectionItemsActionOK here] off begin
		// % protected region % [Add any additional constructor logic for SampleCollectionItemsActionOK here] end
	}

	// % protected region % [Add any additional class methods for SampleCollectionItemsActionOK here] off begin
	// % protected region % [Add any additional class methods for SampleCollectionItemsActionOK here] end
}

export class SampleCollectionItemsActionFail extends BaseSampleCollectionItemsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SampleCollectionItemsActionFail here] off begin
	// % protected region % [Add any additional class fields for SampleCollectionItemsActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<SampleCollectionItemsModel>,
		// % protected region % [Add any additional constructor parameters for SampleCollectionItemsActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for SampleCollectionItemsActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SampleCollectionItemsActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for SampleCollectionItemsActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SampleCollectionItemsActionFail here] off begin
		// % protected region % [Add any additional constructor logic for SampleCollectionItemsActionFail here] end
	}

	// % protected region % [Add any additional class methods for SampleCollectionItemsActionFail here] off begin
	// % protected region % [Add any additional class methods for SampleCollectionItemsActionFail here] end
}

export function isSampleCollectionItemsModelAction(e: any): e is BaseSampleCollectionItemsAction {
	return Object.values(SampleCollectionItemsModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
