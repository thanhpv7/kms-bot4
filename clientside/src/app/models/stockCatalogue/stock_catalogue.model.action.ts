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
import {StockCatalogueModel} from './stock_catalogue.model';
import {StockCatalogueModelAudit} from './stock_catalogue.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Stock Catalogue model actions to be dispatched by NgRx.
 */
export enum StockCatalogueModelActionTypes {
	CREATE_STOCK_CATALOGUE = '[ENTITY] Create StockCatalogueModel',
	CREATE_STOCK_CATALOGUE_OK = '[ENTITY] Create StockCatalogueModel successfully',
	CREATE_STOCK_CATALOGUE_FAIL = '[ENTITY] Create StockCatalogueModel failed',

	CREATE_ALL_STOCK_CATALOGUE = '[ENTITY] Create All StockCatalogueModel',
	CREATE_ALL_STOCK_CATALOGUE_OK = '[ENTITY] Create All StockCatalogueModel successfully',
	CREATE_ALL_STOCK_CATALOGUE_FAIL = '[ENTITY] Create All StockCatalogueModel failed',

	DELETE_STOCK_CATALOGUE = '[ENTITY] Delete StockCatalogueModel',
	DELETE_STOCK_CATALOGUE_OK = '[ENTITY] Delete StockCatalogueModel successfully',
	DELETE_STOCK_CATALOGUE_FAIL = '[ENTITY] Delete StockCatalogueModel failed',


	DELETE_STOCK_CATALOGUE_EXCLUDING_IDS = '[ENTITY] Delete StockCatalogueModels Excluding Ids',
	DELETE_STOCK_CATALOGUE_EXCLUDING_IDS_OK = '[ENTITY] Delete StockCatalogueModels Excluding Ids successfully',
	DELETE_STOCK_CATALOGUE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete StockCatalogueModels Excluding Ids failed',

	DELETE_ALL_STOCK_CATALOGUE = '[ENTITY] Delete all StockCatalogueModels',
	DELETE_ALL_STOCK_CATALOGUE_OK = '[ENTITY] Delete all StockCatalogueModels successfully',
	DELETE_ALL_STOCK_CATALOGUE_FAIL = '[ENTITY] Delete all StockCatalogueModels failed',

	UPDATE_STOCK_CATALOGUE = '[ENTITY] Update StockCatalogueModel',
	UPDATE_STOCK_CATALOGUE_OK = '[ENTITY] Update StockCatalogueModel successfully',
	UPDATE_STOCK_CATALOGUE_FAIL = '[ENTITY] Update StockCatalogueModel failed',

	UPDATE_ALL_STOCK_CATALOGUE = '[ENTITY] Update all StockCatalogueModel',
	UPDATE_ALL_STOCK_CATALOGUE_OK = '[ENTITY] Update all StockCatalogueModel successfully',
	UPDATE_ALL_STOCK_CATALOGUE_FAIL = '[ENTITY] Update all StockCatalogueModel failed',

	FETCH_STOCK_CATALOGUE= '[ENTITY] Fetch StockCatalogueModel',
	FETCH_STOCK_CATALOGUE_OK = '[ENTITY] Fetch StockCatalogueModel successfully',
	FETCH_STOCK_CATALOGUE_FAIL = '[ENTITY] Fetch StockCatalogueModel failed',

	FETCH_STOCK_CATALOGUE_AUDIT= '[ENTITY] Fetch StockCatalogueModel audit',
	FETCH_STOCK_CATALOGUE_AUDIT_OK = '[ENTITY] Fetch StockCatalogueModel audit successfully',
	FETCH_STOCK_CATALOGUE_AUDIT_FAIL = '[ENTITY] Fetch StockCatalogueModel audit failed',

	FETCH_STOCK_CATALOGUE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch StockCatalogueModel audits by entity id',
	FETCH_STOCK_CATALOGUE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch StockCatalogueModel audits by entity id successfully',
	FETCH_STOCK_CATALOGUE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch StockCatalogueModel audits by entity id failed',

	FETCH_ALL_STOCK_CATALOGUE = '[ENTITY] Fetch all StockCatalogueModel',
	FETCH_ALL_STOCK_CATALOGUE_OK = '[ENTITY] Fetch all StockCatalogueModel successfully',
	FETCH_ALL_STOCK_CATALOGUE_FAIL = '[ENTITY] Fetch all StockCatalogueModel failed',

	FETCH_STOCK_CATALOGUE_WITH_QUERY = '[ENTITY] Fetch StockCatalogueModel with query',
	FETCH_STOCK_CATALOGUE_WITH_QUERY_OK = '[ENTITY] Fetch StockCatalogueModel with query successfully',
	FETCH_STOCK_CATALOGUE_WITH_QUERY_FAIL = '[ENTITY] Fetch StockCatalogueModel with query failed',

	FETCH_LAST_STOCK_CATALOGUE_WITH_QUERY = '[ENTITY] Fetch last StockCatalogueModel with query',
	FETCH_LAST_STOCK_CATALOGUE_WITH_QUERY_OK = '[ENTITY] Fetch last StockCatalogueModel with query successfully',
	FETCH_LAST_STOCK_CATALOGUE_WITH_QUERY_FAIL = '[ENTITY] Fetch last StockCatalogueModel with query failed',

	EXPORT_STOCK_CATALOGUE = '[ENTITY] Export StockCatalogueModel',
	EXPORT_STOCK_CATALOGUE_OK = '[ENTITY] Export StockCatalogueModel successfully',
	EXPORT_STOCK_CATALOGUE_FAIL = '[ENTITY] Export StockCatalogueModel failed',

	EXPORT_ALL_STOCK_CATALOGUE = '[ENTITY] Export All StockCatalogueModels',
	EXPORT_ALL_STOCK_CATALOGUE_OK = '[ENTITY] Export All StockCatalogueModels successfully',
	EXPORT_ALL_STOCK_CATALOGUE_FAIL = '[ENTITY] Export All StockCatalogueModels failed',

	EXPORT_STOCK_CATALOGUE_EXCLUDING_IDS = '[ENTITY] Export StockCatalogueModels excluding Ids',
	EXPORT_STOCK_CATALOGUE_EXCLUDING_IDS_OK = '[ENTITY] Export StockCatalogueModel excluding Ids successfully',
	EXPORT_STOCK_CATALOGUE_EXCLUDING_IDS_FAIL = '[ENTITY] Export StockCatalogueModel excluding Ids failed',

	COUNT_STOCK_CATALOGUES = '[ENTITY] Fetch number of StockCatalogueModel records',
	COUNT_STOCK_CATALOGUES_OK = '[ENTITY] Fetch number of StockCatalogueModel records successfully ',
	COUNT_STOCK_CATALOGUES_FAIL = '[ENTITY] Fetch number of StockCatalogueModel records failed',

	IMPORT_STOCK_CATALOGUES = '[ENTITY] Import StockCatalogueModels',
	IMPORT_STOCK_CATALOGUES_OK = '[ENTITY] Import StockCatalogueModels successfully',
	IMPORT_STOCK_CATALOGUES_FAIL = '[ENTITY] Import StockCatalogueModels fail',


	INITIALISE_STOCK_CATALOGUE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of StockCatalogueModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseStockCatalogueAction implements Action {
	readonly className: string = 'StockCatalogueModel';

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

export class StockCatalogueAction extends BaseStockCatalogueAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockCatalogueAction here] off begin
	// % protected region % [Add any additional class fields for StockCatalogueAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockCatalogueModel>,
		// % protected region % [Add any additional constructor parameters for StockCatalogueAction here] off begin
		// % protected region % [Add any additional constructor parameters for StockCatalogueAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockCatalogueAction here] off begin
			// % protected region % [Add any additional constructor arguments for StockCatalogueAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockCatalogueAction here] off begin
		// % protected region % [Add any additional constructor logic for StockCatalogueAction here] end
	}

	// % protected region % [Add any additional class methods for StockCatalogueAction here] off begin
	// % protected region % [Add any additional class methods for StockCatalogueAction here] end
}

export class StockCatalogueActionOK extends BaseStockCatalogueAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockCatalogueActionOK here] off begin
	// % protected region % [Add any additional class fields for StockCatalogueActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<StockCatalogueModel>,
		// % protected region % [Add any additional constructor parameters for StockCatalogueActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for StockCatalogueActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: StockCatalogueModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockCatalogueActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for StockCatalogueActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockCatalogueActionOK here] off begin
		// % protected region % [Add any additional constructor logic for StockCatalogueActionOK here] end
	}

	// % protected region % [Add any additional class methods for StockCatalogueActionOK here] off begin
	// % protected region % [Add any additional class methods for StockCatalogueActionOK here] end
}

export class StockCatalogueActionFail extends BaseStockCatalogueAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for StockCatalogueActionFail here] off begin
	// % protected region % [Add any additional class fields for StockCatalogueActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<StockCatalogueModel>,
		// % protected region % [Add any additional constructor parameters for StockCatalogueActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for StockCatalogueActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for StockCatalogueActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for StockCatalogueActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for StockCatalogueActionFail here] off begin
		// % protected region % [Add any additional constructor logic for StockCatalogueActionFail here] end
	}

	// % protected region % [Add any additional class methods for StockCatalogueActionFail here] off begin
	// % protected region % [Add any additional class methods for StockCatalogueActionFail here] end
}

export function isStockCatalogueModelAction(e: any): e is BaseStockCatalogueAction {
	return Object.values(StockCatalogueModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
