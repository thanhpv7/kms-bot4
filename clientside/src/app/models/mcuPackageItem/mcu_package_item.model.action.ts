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
import {McuPackageItemModel} from './mcu_package_item.model';
import {McuPackageItemModelAudit} from './mcu_package_item.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of MCU Package Item model actions to be dispatched by NgRx.
 */
export enum McuPackageItemModelActionTypes {
	CREATE_MCU_PACKAGE_ITEM = '[ENTITY] Create McuPackageItemModel',
	CREATE_MCU_PACKAGE_ITEM_OK = '[ENTITY] Create McuPackageItemModel successfully',
	CREATE_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Create McuPackageItemModel failed',

	CREATE_ALL_MCU_PACKAGE_ITEM = '[ENTITY] Create All McuPackageItemModel',
	CREATE_ALL_MCU_PACKAGE_ITEM_OK = '[ENTITY] Create All McuPackageItemModel successfully',
	CREATE_ALL_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Create All McuPackageItemModel failed',

	DELETE_MCU_PACKAGE_ITEM = '[ENTITY] Delete McuPackageItemModel',
	DELETE_MCU_PACKAGE_ITEM_OK = '[ENTITY] Delete McuPackageItemModel successfully',
	DELETE_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Delete McuPackageItemModel failed',


	DELETE_MCU_PACKAGE_ITEM_EXCLUDING_IDS = '[ENTITY] Delete McuPackageItemModels Excluding Ids',
	DELETE_MCU_PACKAGE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Delete McuPackageItemModels Excluding Ids successfully',
	DELETE_MCU_PACKAGE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete McuPackageItemModels Excluding Ids failed',

	DELETE_ALL_MCU_PACKAGE_ITEM = '[ENTITY] Delete all McuPackageItemModels',
	DELETE_ALL_MCU_PACKAGE_ITEM_OK = '[ENTITY] Delete all McuPackageItemModels successfully',
	DELETE_ALL_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Delete all McuPackageItemModels failed',

	UPDATE_MCU_PACKAGE_ITEM = '[ENTITY] Update McuPackageItemModel',
	UPDATE_MCU_PACKAGE_ITEM_OK = '[ENTITY] Update McuPackageItemModel successfully',
	UPDATE_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Update McuPackageItemModel failed',

	UPDATE_ALL_MCU_PACKAGE_ITEM = '[ENTITY] Update all McuPackageItemModel',
	UPDATE_ALL_MCU_PACKAGE_ITEM_OK = '[ENTITY] Update all McuPackageItemModel successfully',
	UPDATE_ALL_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Update all McuPackageItemModel failed',

	FETCH_MCU_PACKAGE_ITEM= '[ENTITY] Fetch McuPackageItemModel',
	FETCH_MCU_PACKAGE_ITEM_OK = '[ENTITY] Fetch McuPackageItemModel successfully',
	FETCH_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Fetch McuPackageItemModel failed',

	FETCH_MCU_PACKAGE_ITEM_AUDIT= '[ENTITY] Fetch McuPackageItemModel audit',
	FETCH_MCU_PACKAGE_ITEM_AUDIT_OK = '[ENTITY] Fetch McuPackageItemModel audit successfully',
	FETCH_MCU_PACKAGE_ITEM_AUDIT_FAIL = '[ENTITY] Fetch McuPackageItemModel audit failed',

	FETCH_MCU_PACKAGE_ITEM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch McuPackageItemModel audits by entity id',
	FETCH_MCU_PACKAGE_ITEM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch McuPackageItemModel audits by entity id successfully',
	FETCH_MCU_PACKAGE_ITEM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch McuPackageItemModel audits by entity id failed',

	FETCH_ALL_MCU_PACKAGE_ITEM = '[ENTITY] Fetch all McuPackageItemModel',
	FETCH_ALL_MCU_PACKAGE_ITEM_OK = '[ENTITY] Fetch all McuPackageItemModel successfully',
	FETCH_ALL_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Fetch all McuPackageItemModel failed',

	FETCH_MCU_PACKAGE_ITEM_WITH_QUERY = '[ENTITY] Fetch McuPackageItemModel with query',
	FETCH_MCU_PACKAGE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch McuPackageItemModel with query successfully',
	FETCH_MCU_PACKAGE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch McuPackageItemModel with query failed',

	FETCH_LAST_MCU_PACKAGE_ITEM_WITH_QUERY = '[ENTITY] Fetch last McuPackageItemModel with query',
	FETCH_LAST_MCU_PACKAGE_ITEM_WITH_QUERY_OK = '[ENTITY] Fetch last McuPackageItemModel with query successfully',
	FETCH_LAST_MCU_PACKAGE_ITEM_WITH_QUERY_FAIL = '[ENTITY] Fetch last McuPackageItemModel with query failed',

	EXPORT_MCU_PACKAGE_ITEM = '[ENTITY] Export McuPackageItemModel',
	EXPORT_MCU_PACKAGE_ITEM_OK = '[ENTITY] Export McuPackageItemModel successfully',
	EXPORT_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Export McuPackageItemModel failed',

	EXPORT_ALL_MCU_PACKAGE_ITEM = '[ENTITY] Export All McuPackageItemModels',
	EXPORT_ALL_MCU_PACKAGE_ITEM_OK = '[ENTITY] Export All McuPackageItemModels successfully',
	EXPORT_ALL_MCU_PACKAGE_ITEM_FAIL = '[ENTITY] Export All McuPackageItemModels failed',

	EXPORT_MCU_PACKAGE_ITEM_EXCLUDING_IDS = '[ENTITY] Export McuPackageItemModels excluding Ids',
	EXPORT_MCU_PACKAGE_ITEM_EXCLUDING_IDS_OK = '[ENTITY] Export McuPackageItemModel excluding Ids successfully',
	EXPORT_MCU_PACKAGE_ITEM_EXCLUDING_IDS_FAIL = '[ENTITY] Export McuPackageItemModel excluding Ids failed',

	COUNT_MCU_PACKAGE_ITEMS = '[ENTITY] Fetch number of McuPackageItemModel records',
	COUNT_MCU_PACKAGE_ITEMS_OK = '[ENTITY] Fetch number of McuPackageItemModel records successfully ',
	COUNT_MCU_PACKAGE_ITEMS_FAIL = '[ENTITY] Fetch number of McuPackageItemModel records failed',

	IMPORT_MCU_PACKAGE_ITEMS = '[ENTITY] Import McuPackageItemModels',
	IMPORT_MCU_PACKAGE_ITEMS_OK = '[ENTITY] Import McuPackageItemModels successfully',
	IMPORT_MCU_PACKAGE_ITEMS_FAIL = '[ENTITY] Import McuPackageItemModels fail',


	INITIALISE_MCU_PACKAGE_ITEM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of McuPackageItemModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMcuPackageItemAction implements Action {
	readonly className: string = 'McuPackageItemModel';

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

export class McuPackageItemAction extends BaseMcuPackageItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for McuPackageItemAction here] off begin
	// % protected region % [Add any additional class fields for McuPackageItemAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<McuPackageItemModel>,
		// % protected region % [Add any additional constructor parameters for McuPackageItemAction here] off begin
		// % protected region % [Add any additional constructor parameters for McuPackageItemAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for McuPackageItemAction here] off begin
			// % protected region % [Add any additional constructor arguments for McuPackageItemAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for McuPackageItemAction here] off begin
		// % protected region % [Add any additional constructor logic for McuPackageItemAction here] end
	}

	// % protected region % [Add any additional class methods for McuPackageItemAction here] off begin
	// % protected region % [Add any additional class methods for McuPackageItemAction here] end
}

export class McuPackageItemActionOK extends BaseMcuPackageItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for McuPackageItemActionOK here] off begin
	// % protected region % [Add any additional class fields for McuPackageItemActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<McuPackageItemModel>,
		// % protected region % [Add any additional constructor parameters for McuPackageItemActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for McuPackageItemActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: McuPackageItemModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for McuPackageItemActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for McuPackageItemActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for McuPackageItemActionOK here] off begin
		// % protected region % [Add any additional constructor logic for McuPackageItemActionOK here] end
	}

	// % protected region % [Add any additional class methods for McuPackageItemActionOK here] off begin
	// % protected region % [Add any additional class methods for McuPackageItemActionOK here] end
}

export class McuPackageItemActionFail extends BaseMcuPackageItemAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for McuPackageItemActionFail here] off begin
	// % protected region % [Add any additional class fields for McuPackageItemActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<McuPackageItemModel>,
		// % protected region % [Add any additional constructor parameters for McuPackageItemActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for McuPackageItemActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for McuPackageItemActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for McuPackageItemActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for McuPackageItemActionFail here] off begin
		// % protected region % [Add any additional constructor logic for McuPackageItemActionFail here] end
	}

	// % protected region % [Add any additional class methods for McuPackageItemActionFail here] off begin
	// % protected region % [Add any additional class methods for McuPackageItemActionFail here] end
}

export function isMcuPackageItemModelAction(e: any): e is BaseMcuPackageItemAction {
	return Object.values(McuPackageItemModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
