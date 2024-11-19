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
import {McuPackageModel} from './mcu_package.model';
import {McuPackageModelAudit} from './mcu_package.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of MCU Package model actions to be dispatched by NgRx.
 */
export enum McuPackageModelActionTypes {
	CREATE_MCU_PACKAGE = '[ENTITY] Create McuPackageModel',
	CREATE_MCU_PACKAGE_OK = '[ENTITY] Create McuPackageModel successfully',
	CREATE_MCU_PACKAGE_FAIL = '[ENTITY] Create McuPackageModel failed',

	CREATE_ALL_MCU_PACKAGE = '[ENTITY] Create All McuPackageModel',
	CREATE_ALL_MCU_PACKAGE_OK = '[ENTITY] Create All McuPackageModel successfully',
	CREATE_ALL_MCU_PACKAGE_FAIL = '[ENTITY] Create All McuPackageModel failed',

	DELETE_MCU_PACKAGE = '[ENTITY] Delete McuPackageModel',
	DELETE_MCU_PACKAGE_OK = '[ENTITY] Delete McuPackageModel successfully',
	DELETE_MCU_PACKAGE_FAIL = '[ENTITY] Delete McuPackageModel failed',


	DELETE_MCU_PACKAGE_EXCLUDING_IDS = '[ENTITY] Delete McuPackageModels Excluding Ids',
	DELETE_MCU_PACKAGE_EXCLUDING_IDS_OK = '[ENTITY] Delete McuPackageModels Excluding Ids successfully',
	DELETE_MCU_PACKAGE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete McuPackageModels Excluding Ids failed',

	DELETE_ALL_MCU_PACKAGE = '[ENTITY] Delete all McuPackageModels',
	DELETE_ALL_MCU_PACKAGE_OK = '[ENTITY] Delete all McuPackageModels successfully',
	DELETE_ALL_MCU_PACKAGE_FAIL = '[ENTITY] Delete all McuPackageModels failed',

	UPDATE_MCU_PACKAGE = '[ENTITY] Update McuPackageModel',
	UPDATE_MCU_PACKAGE_OK = '[ENTITY] Update McuPackageModel successfully',
	UPDATE_MCU_PACKAGE_FAIL = '[ENTITY] Update McuPackageModel failed',

	UPDATE_ALL_MCU_PACKAGE = '[ENTITY] Update all McuPackageModel',
	UPDATE_ALL_MCU_PACKAGE_OK = '[ENTITY] Update all McuPackageModel successfully',
	UPDATE_ALL_MCU_PACKAGE_FAIL = '[ENTITY] Update all McuPackageModel failed',

	FETCH_MCU_PACKAGE= '[ENTITY] Fetch McuPackageModel',
	FETCH_MCU_PACKAGE_OK = '[ENTITY] Fetch McuPackageModel successfully',
	FETCH_MCU_PACKAGE_FAIL = '[ENTITY] Fetch McuPackageModel failed',

	FETCH_MCU_PACKAGE_AUDIT= '[ENTITY] Fetch McuPackageModel audit',
	FETCH_MCU_PACKAGE_AUDIT_OK = '[ENTITY] Fetch McuPackageModel audit successfully',
	FETCH_MCU_PACKAGE_AUDIT_FAIL = '[ENTITY] Fetch McuPackageModel audit failed',

	FETCH_MCU_PACKAGE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch McuPackageModel audits by entity id',
	FETCH_MCU_PACKAGE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch McuPackageModel audits by entity id successfully',
	FETCH_MCU_PACKAGE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch McuPackageModel audits by entity id failed',

	FETCH_ALL_MCU_PACKAGE = '[ENTITY] Fetch all McuPackageModel',
	FETCH_ALL_MCU_PACKAGE_OK = '[ENTITY] Fetch all McuPackageModel successfully',
	FETCH_ALL_MCU_PACKAGE_FAIL = '[ENTITY] Fetch all McuPackageModel failed',

	FETCH_MCU_PACKAGE_WITH_QUERY = '[ENTITY] Fetch McuPackageModel with query',
	FETCH_MCU_PACKAGE_WITH_QUERY_OK = '[ENTITY] Fetch McuPackageModel with query successfully',
	FETCH_MCU_PACKAGE_WITH_QUERY_FAIL = '[ENTITY] Fetch McuPackageModel with query failed',

	FETCH_LAST_MCU_PACKAGE_WITH_QUERY = '[ENTITY] Fetch last McuPackageModel with query',
	FETCH_LAST_MCU_PACKAGE_WITH_QUERY_OK = '[ENTITY] Fetch last McuPackageModel with query successfully',
	FETCH_LAST_MCU_PACKAGE_WITH_QUERY_FAIL = '[ENTITY] Fetch last McuPackageModel with query failed',

	EXPORT_MCU_PACKAGE = '[ENTITY] Export McuPackageModel',
	EXPORT_MCU_PACKAGE_OK = '[ENTITY] Export McuPackageModel successfully',
	EXPORT_MCU_PACKAGE_FAIL = '[ENTITY] Export McuPackageModel failed',

	EXPORT_ALL_MCU_PACKAGE = '[ENTITY] Export All McuPackageModels',
	EXPORT_ALL_MCU_PACKAGE_OK = '[ENTITY] Export All McuPackageModels successfully',
	EXPORT_ALL_MCU_PACKAGE_FAIL = '[ENTITY] Export All McuPackageModels failed',

	EXPORT_MCU_PACKAGE_EXCLUDING_IDS = '[ENTITY] Export McuPackageModels excluding Ids',
	EXPORT_MCU_PACKAGE_EXCLUDING_IDS_OK = '[ENTITY] Export McuPackageModel excluding Ids successfully',
	EXPORT_MCU_PACKAGE_EXCLUDING_IDS_FAIL = '[ENTITY] Export McuPackageModel excluding Ids failed',

	COUNT_MCU_PACKAGES = '[ENTITY] Fetch number of McuPackageModel records',
	COUNT_MCU_PACKAGES_OK = '[ENTITY] Fetch number of McuPackageModel records successfully ',
	COUNT_MCU_PACKAGES_FAIL = '[ENTITY] Fetch number of McuPackageModel records failed',

	IMPORT_MCU_PACKAGES = '[ENTITY] Import McuPackageModels',
	IMPORT_MCU_PACKAGES_OK = '[ENTITY] Import McuPackageModels successfully',
	IMPORT_MCU_PACKAGES_FAIL = '[ENTITY] Import McuPackageModels fail',


	INITIALISE_MCU_PACKAGE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of McuPackageModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMcuPackageAction implements Action {
	readonly className: string = 'McuPackageModel';

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

export class McuPackageAction extends BaseMcuPackageAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for McuPackageAction here] off begin
	// % protected region % [Add any additional class fields for McuPackageAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<McuPackageModel>,
		// % protected region % [Add any additional constructor parameters for McuPackageAction here] off begin
		// % protected region % [Add any additional constructor parameters for McuPackageAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for McuPackageAction here] off begin
			// % protected region % [Add any additional constructor arguments for McuPackageAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for McuPackageAction here] off begin
		// % protected region % [Add any additional constructor logic for McuPackageAction here] end
	}

	// % protected region % [Add any additional class methods for McuPackageAction here] off begin
	// % protected region % [Add any additional class methods for McuPackageAction here] end
}

export class McuPackageActionOK extends BaseMcuPackageAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for McuPackageActionOK here] off begin
	// % protected region % [Add any additional class fields for McuPackageActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<McuPackageModel>,
		// % protected region % [Add any additional constructor parameters for McuPackageActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for McuPackageActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: McuPackageModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for McuPackageActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for McuPackageActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for McuPackageActionOK here] off begin
		// % protected region % [Add any additional constructor logic for McuPackageActionOK here] end
	}

	// % protected region % [Add any additional class methods for McuPackageActionOK here] off begin
	// % protected region % [Add any additional class methods for McuPackageActionOK here] end
}

export class McuPackageActionFail extends BaseMcuPackageAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for McuPackageActionFail here] off begin
	// % protected region % [Add any additional class fields for McuPackageActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<McuPackageModel>,
		// % protected region % [Add any additional constructor parameters for McuPackageActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for McuPackageActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for McuPackageActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for McuPackageActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for McuPackageActionFail here] off begin
		// % protected region % [Add any additional constructor logic for McuPackageActionFail here] end
	}

	// % protected region % [Add any additional class methods for McuPackageActionFail here] off begin
	// % protected region % [Add any additional class methods for McuPackageActionFail here] end
}

export function isMcuPackageModelAction(e: any): e is BaseMcuPackageAction {
	return Object.values(McuPackageModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
