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
import {TariffPackageItemModel} from './tariff_package_item.model';
import {TariffPackageItemModelAudit} from './tariff_package_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Tariff Package Item model actions to be dispatched by NgRx.
 */
export enum TariffPackageItemModelActionTypes {
	CREATE_TARIFF_PACKAGE_ITEM = '[ENTITY] Create TariffPackageItemModel',
	CREATE_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Create TariffPackageItemModel successfully',
	CREATE_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Create TariffPackageItemModel failed',

	CREATE_ALL_TARIFF_PACKAGE_ITEM = '[ENTITY] Create All TariffPackageItemModel',
	CREATE_ALL_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Create All TariffPackageItemModel successfully',
	CREATE_ALL_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Create All TariffPackageItemModel failed',

	DELETE_TARIFF_PACKAGE_ITEM = '[ENTITY] Delete TariffPackageItemModel',
	DELETE_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Delete TariffPackageItemModel successfully',
	DELETE_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Delete TariffPackageItemModel failed',


	DELETE_TARIFF_PACKAGE_ITEM_EXCLUDING_IDS = '[ENTITY] Delete TariffPackageItemModels Excluding Ids',
	DELETE_TARIFF_PACKAGE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete TariffPackageItemModels Excluding Ids successfully',
	DELETE_TARIFF_PACKAGE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TariffPackageItemModels Excluding Ids failed',

	DELETE_ALL_TARIFF_PACKAGE_ITEM = '[ENTITY] Delete all TariffPackageItemModels',
	DELETE_ALL_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Delete all TariffPackageItemModels successfully',
	DELETE_ALL_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Delete all TariffPackageItemModels failed',

	UPDATE_TARIFF_PACKAGE_ITEM = '[ENTITY] Update TariffPackageItemModel',
	UPDATE_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Update TariffPackageItemModel successfully',
	UPDATE_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Update TariffPackageItemModel failed',

	UPDATE_ALL_TARIFF_PACKAGE_ITEM = '[ENTITY] Update all TariffPackageItemModel',
	UPDATE_ALL_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Update all TariffPackageItemModel successfully',
	UPDATE_ALL_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Update all TariffPackageItemModel failed',

	FETCH_TARIFF_PACKAGE_ITEM= '[ENTITY] Fetch TariffPackageItemModel',
	FETCH_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Fetch TariffPackageItemModel successfully',
	FETCH_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Fetch TariffPackageItemModel failed',

	FETCH_TARIFF_PACKAGE_ITEM_AUDIT= '[ENTITY] Fetch TariffPackageItemModel audit',
	FETCH_TARIFF_PACKAGE_ITEM_AUDIT_OK = '[ENTITY] Fetch TariffPackageItemModel audit successfully',
	FETCH_TARIFF_PACKAGE_ITEM_AUDIT_FAIL = '[ENTITY] Fetch TariffPackageItemModel audit failed',

	FETCH_TARIFF_PACKAGE_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TariffPackageItemModel audits by entity id',
	FETCH_TARIFF_PACKAGE_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TariffPackageItemModel audits by entity id successfully',
	FETCH_TARIFF_PACKAGE_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TariffPackageItemModel audits by entity id failed',

	FETCH_ALL_TARIFF_PACKAGE_ITEM = '[ENTITY] Fetch all TariffPackageItemModel',
	FETCH_ALL_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Fetch all TariffPackageItemModel successfully',
	FETCH_ALL_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Fetch all TariffPackageItemModel failed',

	FETCH_TARIFF_PACKAGE_ITEM_WITH_QUERY = '[ENTITY] Fetch TariffPackageItemModel with query',
	FETCH_TARIFF_PACKAGE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch TariffPackageItemModel with query successfully',
	FETCH_TARIFF_PACKAGE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch TariffPackageItemModel with query failed',

	FETCH_LAST_TARIFF_PACKAGE_ITEM_WITH_QUERY = '[ENTITY] Fetch last TariffPackageItemModel with query',
	FETCH_LAST_TARIFF_PACKAGE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last TariffPackageItemModel with query successfully',
	FETCH_LAST_TARIFF_PACKAGE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last TariffPackageItemModel with query failed',

	EXPORT_TARIFF_PACKAGE_ITEM = '[ENTITY] Export TariffPackageItemModel',
	EXPORT_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Export TariffPackageItemModel successfully',
	EXPORT_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Export TariffPackageItemModel failed',

	EXPORT_ALL_TARIFF_PACKAGE_ITEM = '[ENTITY] Export All TariffPackageItemModels',
	EXPORT_ALL_TARIFF_PACKAGE_ITEM_OK = '[ENTITY] Export All TariffPackageItemModels successfully',
	EXPORT_ALL_TARIFF_PACKAGE_ITEM_FAIL = '[ENTITY] Export All TariffPackageItemModels failed',

	EXPORT_TARIFF_PACKAGE_ITEM_EXCLUDING_IDS = '[ENTITY] Export TariffPackageItemModels excluding Ids',
	EXPORT_TARIFF_PACKAGE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export TariffPackageItemModel excluding Ids successfully',
	EXPORT_TARIFF_PACKAGE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export TariffPackageItemModel excluding Ids failed',

	COUNT_TARIFF_PACKAGE_ITEMS = '[ENTITY] Fetch number of TariffPackageItemModel records',
	COUNT_TARIFF_PACKAGE_ITEMS_OK = '[ENTITY] Fetch number of TariffPackageItemModel records successfully ',
	COUNT_TARIFF_PACKAGE_ITEMS_FAIL = '[ENTITY] Fetch number of TariffPackageItemModel records failed',

	IMPORT_TARIFF_PACKAGE_ITEMS = '[ENTITY] Import TariffPackageItemModels',
	IMPORT_TARIFF_PACKAGE_ITEMS_OK = '[ENTITY] Import TariffPackageItemModels successfully',
	IMPORT_TARIFF_PACKAGE_ITEMS_FAIL = '[ENTITY] Import TariffPackageItemModels fail',


	INITIALISE_TARIFF_PACKAGE_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TariffPackageItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTariffPackageItemAction implements Action {
	readonly className: string = 'TariffPackageItemModel';

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

export class TariffPackageItemAction extends BaseTariffPackageItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffPackageItemAction here] off begin
	// % protected region % [Add any additional class fields for TariffPackageItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffPackageItemModel>,
		// % protected region % [Add any additional constructor parameters for TariffPackageItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for TariffPackageItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffPackageItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for TariffPackageItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffPackageItemAction here] off begin
		// % protected region % [Add any additional constructor logic for TariffPackageItemAction here] end
	}

	// % protected region % [Add any additional class methods for TariffPackageItemAction here] off begin
	// % protected region % [Add any additional class methods for TariffPackageItemAction here] end
}

export class TariffPackageItemActionOK extends BaseTariffPackageItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffPackageItemActionOK here] off begin
	// % protected region % [Add any additional class fields for TariffPackageItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffPackageItemModel>,
		// % protected region % [Add any additional constructor parameters for TariffPackageItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TariffPackageItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TariffPackageItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffPackageItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TariffPackageItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffPackageItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TariffPackageItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for TariffPackageItemActionOK here] off begin
	// % protected region % [Add any additional class methods for TariffPackageItemActionOK here] end
}

export class TariffPackageItemActionFail extends BaseTariffPackageItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffPackageItemActionFail here] off begin
	// % protected region % [Add any additional class fields for TariffPackageItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TariffPackageItemModel>,
		// % protected region % [Add any additional constructor parameters for TariffPackageItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TariffPackageItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffPackageItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TariffPackageItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffPackageItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TariffPackageItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for TariffPackageItemActionFail here] off begin
	// % protected region % [Add any additional class methods for TariffPackageItemActionFail here] end
}

export function isTariffPackageItemModelAction(e: any): e is BaseTariffPackageItemAction {
	return Object.values(TariffPackageItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
