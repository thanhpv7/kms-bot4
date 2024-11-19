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
import {TariffPackageModel} from './tariff_package.model';
import {TariffPackageModelAudit} from './tariff_package.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Tariff Package model actions to be dispatched by NgRx.
 */
export enum TariffPackageModelActionTypes {
	CREATE_TARIFF_PACKAGE = '[ENTITY] Create TariffPackageModel',
	CREATE_TARIFF_PACKAGE_OK = '[ENTITY] Create TariffPackageModel successfully',
	CREATE_TARIFF_PACKAGE_FAIL = '[ENTITY] Create TariffPackageModel failed',

	CREATE_ALL_TARIFF_PACKAGE = '[ENTITY] Create All TariffPackageModel',
	CREATE_ALL_TARIFF_PACKAGE_OK = '[ENTITY] Create All TariffPackageModel successfully',
	CREATE_ALL_TARIFF_PACKAGE_FAIL = '[ENTITY] Create All TariffPackageModel failed',

	DELETE_TARIFF_PACKAGE = '[ENTITY] Delete TariffPackageModel',
	DELETE_TARIFF_PACKAGE_OK = '[ENTITY] Delete TariffPackageModel successfully',
	DELETE_TARIFF_PACKAGE_FAIL = '[ENTITY] Delete TariffPackageModel failed',


	DELETE_TARIFF_PACKAGE_EXCLUDING_IDS = '[ENTITY] Delete TariffPackageModels Excluding Ids',
	DELETE_TARIFF_PACKAGE_EXCLUDING_IDS_OK = '[ENTITY] Delete TariffPackageModels Excluding Ids successfully',
	DELETE_TARIFF_PACKAGE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TariffPackageModels Excluding Ids failed',

	DELETE_ALL_TARIFF_PACKAGE = '[ENTITY] Delete all TariffPackageModels',
	DELETE_ALL_TARIFF_PACKAGE_OK = '[ENTITY] Delete all TariffPackageModels successfully',
	DELETE_ALL_TARIFF_PACKAGE_FAIL = '[ENTITY] Delete all TariffPackageModels failed',

	UPDATE_TARIFF_PACKAGE = '[ENTITY] Update TariffPackageModel',
	UPDATE_TARIFF_PACKAGE_OK = '[ENTITY] Update TariffPackageModel successfully',
	UPDATE_TARIFF_PACKAGE_FAIL = '[ENTITY] Update TariffPackageModel failed',

	UPDATE_ALL_TARIFF_PACKAGE = '[ENTITY] Update all TariffPackageModel',
	UPDATE_ALL_TARIFF_PACKAGE_OK = '[ENTITY] Update all TariffPackageModel successfully',
	UPDATE_ALL_TARIFF_PACKAGE_FAIL = '[ENTITY] Update all TariffPackageModel failed',

	FETCH_TARIFF_PACKAGE= '[ENTITY] Fetch TariffPackageModel',
	FETCH_TARIFF_PACKAGE_OK = '[ENTITY] Fetch TariffPackageModel successfully',
	FETCH_TARIFF_PACKAGE_FAIL = '[ENTITY] Fetch TariffPackageModel failed',

	FETCH_TARIFF_PACKAGE_AUDIT= '[ENTITY] Fetch TariffPackageModel audit',
	FETCH_TARIFF_PACKAGE_AUDIT_OK = '[ENTITY] Fetch TariffPackageModel audit successfully',
	FETCH_TARIFF_PACKAGE_AUDIT_FAIL = '[ENTITY] Fetch TariffPackageModel audit failed',

	FETCH_TARIFF_PACKAGE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TariffPackageModel audits by entity id',
	FETCH_TARIFF_PACKAGE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TariffPackageModel audits by entity id successfully',
	FETCH_TARIFF_PACKAGE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TariffPackageModel audits by entity id failed',

	FETCH_ALL_TARIFF_PACKAGE = '[ENTITY] Fetch all TariffPackageModel',
	FETCH_ALL_TARIFF_PACKAGE_OK = '[ENTITY] Fetch all TariffPackageModel successfully',
	FETCH_ALL_TARIFF_PACKAGE_FAIL = '[ENTITY] Fetch all TariffPackageModel failed',

	FETCH_TARIFF_PACKAGE_WITH_QUERY = '[ENTITY] Fetch TariffPackageModel with query',
	FETCH_TARIFF_PACKAGE_WITH_QUERY_OK = '[ENTITY] Fetch TariffPackageModel with query successfully',
	FETCH_TARIFF_PACKAGE_WITH_QUERY_FAIL = '[ENTITY] Fetch TariffPackageModel with query failed',

	FETCH_LAST_TARIFF_PACKAGE_WITH_QUERY = '[ENTITY] Fetch last TariffPackageModel with query',
	FETCH_LAST_TARIFF_PACKAGE_WITH_QUERY_OK = '[ENTITY] Fetch last TariffPackageModel with query successfully',
	FETCH_LAST_TARIFF_PACKAGE_WITH_QUERY_FAIL = '[ENTITY] Fetch last TariffPackageModel with query failed',

	EXPORT_TARIFF_PACKAGE = '[ENTITY] Export TariffPackageModel',
	EXPORT_TARIFF_PACKAGE_OK = '[ENTITY] Export TariffPackageModel successfully',
	EXPORT_TARIFF_PACKAGE_FAIL = '[ENTITY] Export TariffPackageModel failed',

	EXPORT_ALL_TARIFF_PACKAGE = '[ENTITY] Export All TariffPackageModels',
	EXPORT_ALL_TARIFF_PACKAGE_OK = '[ENTITY] Export All TariffPackageModels successfully',
	EXPORT_ALL_TARIFF_PACKAGE_FAIL = '[ENTITY] Export All TariffPackageModels failed',

	EXPORT_TARIFF_PACKAGE_EXCLUDING_IDS = '[ENTITY] Export TariffPackageModels excluding Ids',
	EXPORT_TARIFF_PACKAGE_EXCLUDING_IDS_OK = '[ENTITY] Export TariffPackageModel excluding Ids successfully',
	EXPORT_TARIFF_PACKAGE_EXCLUDING_IDS_FAIL = '[ENTITY] Export TariffPackageModel excluding Ids failed',

	COUNT_TARIFF_PACKAGES = '[ENTITY] Fetch number of TariffPackageModel records',
	COUNT_TARIFF_PACKAGES_OK = '[ENTITY] Fetch number of TariffPackageModel records successfully ',
	COUNT_TARIFF_PACKAGES_FAIL = '[ENTITY] Fetch number of TariffPackageModel records failed',

	IMPORT_TARIFF_PACKAGES = '[ENTITY] Import TariffPackageModels',
	IMPORT_TARIFF_PACKAGES_OK = '[ENTITY] Import TariffPackageModels successfully',
	IMPORT_TARIFF_PACKAGES_FAIL = '[ENTITY] Import TariffPackageModels fail',


	INITIALISE_TARIFF_PACKAGE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TariffPackageModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTariffPackageAction implements Action {
	readonly className: string = 'TariffPackageModel';

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

export class TariffPackageAction extends BaseTariffPackageAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffPackageAction here] off begin
	// % protected region % [Add any additional class fields for TariffPackageAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffPackageModel>,
		// % protected region % [Add any additional constructor parameters for TariffPackageAction here] off begin
		// % protected region % [Add any additional constructor parameters for TariffPackageAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffPackageAction here] off begin
			// % protected region % [Add any additional constructor arguments for TariffPackageAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffPackageAction here] off begin
		// % protected region % [Add any additional constructor logic for TariffPackageAction here] end
	}

	// % protected region % [Add any additional class methods for TariffPackageAction here] off begin
	// % protected region % [Add any additional class methods for TariffPackageAction here] end
}

export class TariffPackageActionOK extends BaseTariffPackageAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffPackageActionOK here] off begin
	// % protected region % [Add any additional class fields for TariffPackageActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffPackageModel>,
		// % protected region % [Add any additional constructor parameters for TariffPackageActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TariffPackageActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TariffPackageModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffPackageActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TariffPackageActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffPackageActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TariffPackageActionOK here] end
	}

	// % protected region % [Add any additional class methods for TariffPackageActionOK here] off begin
	// % protected region % [Add any additional class methods for TariffPackageActionOK here] end
}

export class TariffPackageActionFail extends BaseTariffPackageAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffPackageActionFail here] off begin
	// % protected region % [Add any additional class fields for TariffPackageActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TariffPackageModel>,
		// % protected region % [Add any additional constructor parameters for TariffPackageActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TariffPackageActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffPackageActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TariffPackageActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffPackageActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TariffPackageActionFail here] end
	}

	// % protected region % [Add any additional class methods for TariffPackageActionFail here] off begin
	// % protected region % [Add any additional class methods for TariffPackageActionFail here] end
}

export function isTariffPackageModelAction(e: any): e is BaseTariffPackageAction {
	return Object.values(TariffPackageModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
