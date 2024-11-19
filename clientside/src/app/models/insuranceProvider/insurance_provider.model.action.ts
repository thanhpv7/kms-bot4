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
import {InsuranceProviderModel} from './insurance_provider.model';
import {InsuranceProviderModelAudit} from './insurance_provider.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Insurance Provider model actions to be dispatched by NgRx.
 */
export enum InsuranceProviderModelActionTypes {
	CREATE_INSURANCE_PROVIDER = '[ENTITY] Create InsuranceProviderModel',
	CREATE_INSURANCE_PROVIDER_OK = '[ENTITY] Create InsuranceProviderModel successfully',
	CREATE_INSURANCE_PROVIDER_FAIL = '[ENTITY] Create InsuranceProviderModel failed',

	CREATE_ALL_INSURANCE_PROVIDER = '[ENTITY] Create All InsuranceProviderModel',
	CREATE_ALL_INSURANCE_PROVIDER_OK = '[ENTITY] Create All InsuranceProviderModel successfully',
	CREATE_ALL_INSURANCE_PROVIDER_FAIL = '[ENTITY] Create All InsuranceProviderModel failed',

	DELETE_INSURANCE_PROVIDER = '[ENTITY] Delete InsuranceProviderModel',
	DELETE_INSURANCE_PROVIDER_OK = '[ENTITY] Delete InsuranceProviderModel successfully',
	DELETE_INSURANCE_PROVIDER_FAIL = '[ENTITY] Delete InsuranceProviderModel failed',


	DELETE_INSURANCE_PROVIDER_EXCLUDING_IDS = '[ENTITY] Delete InsuranceProviderModels Excluding Ids',
	DELETE_INSURANCE_PROVIDER_EXCLUDING_IDS_OK = '[ENTITY] Delete InsuranceProviderModels Excluding Ids successfully',
	DELETE_INSURANCE_PROVIDER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InsuranceProviderModels Excluding Ids failed',

	DELETE_ALL_INSURANCE_PROVIDER = '[ENTITY] Delete all InsuranceProviderModels',
	DELETE_ALL_INSURANCE_PROVIDER_OK = '[ENTITY] Delete all InsuranceProviderModels successfully',
	DELETE_ALL_INSURANCE_PROVIDER_FAIL = '[ENTITY] Delete all InsuranceProviderModels failed',

	UPDATE_INSURANCE_PROVIDER = '[ENTITY] Update InsuranceProviderModel',
	UPDATE_INSURANCE_PROVIDER_OK = '[ENTITY] Update InsuranceProviderModel successfully',
	UPDATE_INSURANCE_PROVIDER_FAIL = '[ENTITY] Update InsuranceProviderModel failed',

	UPDATE_ALL_INSURANCE_PROVIDER = '[ENTITY] Update all InsuranceProviderModel',
	UPDATE_ALL_INSURANCE_PROVIDER_OK = '[ENTITY] Update all InsuranceProviderModel successfully',
	UPDATE_ALL_INSURANCE_PROVIDER_FAIL = '[ENTITY] Update all InsuranceProviderModel failed',

	FETCH_INSURANCE_PROVIDER= '[ENTITY] Fetch InsuranceProviderModel',
	FETCH_INSURANCE_PROVIDER_OK = '[ENTITY] Fetch InsuranceProviderModel successfully',
	FETCH_INSURANCE_PROVIDER_FAIL = '[ENTITY] Fetch InsuranceProviderModel failed',

	FETCH_INSURANCE_PROVIDER_AUDIT= '[ENTITY] Fetch InsuranceProviderModel audit',
	FETCH_INSURANCE_PROVIDER_AUDIT_OK = '[ENTITY] Fetch InsuranceProviderModel audit successfully',
	FETCH_INSURANCE_PROVIDER_AUDIT_FAIL = '[ENTITY] Fetch InsuranceProviderModel audit failed',

	FETCH_INSURANCE_PROVIDER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InsuranceProviderModel audits by entity id',
	FETCH_INSURANCE_PROVIDER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InsuranceProviderModel audits by entity id successfully',
	FETCH_INSURANCE_PROVIDER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InsuranceProviderModel audits by entity id failed',

	FETCH_ALL_INSURANCE_PROVIDER = '[ENTITY] Fetch all InsuranceProviderModel',
	FETCH_ALL_INSURANCE_PROVIDER_OK = '[ENTITY] Fetch all InsuranceProviderModel successfully',
	FETCH_ALL_INSURANCE_PROVIDER_FAIL = '[ENTITY] Fetch all InsuranceProviderModel failed',

	FETCH_INSURANCE_PROVIDER_WITH_QUERY = '[ENTITY] Fetch InsuranceProviderModel with query',
	FETCH_INSURANCE_PROVIDER_WITH_QUERY_OK = '[ENTITY] Fetch InsuranceProviderModel with query successfully',
	FETCH_INSURANCE_PROVIDER_WITH_QUERY_FAIL = '[ENTITY] Fetch InsuranceProviderModel with query failed',

	FETCH_LAST_INSURANCE_PROVIDER_WITH_QUERY = '[ENTITY] Fetch last InsuranceProviderModel with query',
	FETCH_LAST_INSURANCE_PROVIDER_WITH_QUERY_OK = '[ENTITY] Fetch last InsuranceProviderModel with query successfully',
	FETCH_LAST_INSURANCE_PROVIDER_WITH_QUERY_FAIL = '[ENTITY] Fetch last InsuranceProviderModel with query failed',

	EXPORT_INSURANCE_PROVIDER = '[ENTITY] Export InsuranceProviderModel',
	EXPORT_INSURANCE_PROVIDER_OK = '[ENTITY] Export InsuranceProviderModel successfully',
	EXPORT_INSURANCE_PROVIDER_FAIL = '[ENTITY] Export InsuranceProviderModel failed',

	EXPORT_ALL_INSURANCE_PROVIDER = '[ENTITY] Export All InsuranceProviderModels',
	EXPORT_ALL_INSURANCE_PROVIDER_OK = '[ENTITY] Export All InsuranceProviderModels successfully',
	EXPORT_ALL_INSURANCE_PROVIDER_FAIL = '[ENTITY] Export All InsuranceProviderModels failed',

	EXPORT_INSURANCE_PROVIDER_EXCLUDING_IDS = '[ENTITY] Export InsuranceProviderModels excluding Ids',
	EXPORT_INSURANCE_PROVIDER_EXCLUDING_IDS_OK = '[ENTITY] Export InsuranceProviderModel excluding Ids successfully',
	EXPORT_INSURANCE_PROVIDER_EXCLUDING_IDS_FAIL = '[ENTITY] Export InsuranceProviderModel excluding Ids failed',

	COUNT_INSURANCE_PROVIDERS = '[ENTITY] Fetch number of InsuranceProviderModel records',
	COUNT_INSURANCE_PROVIDERS_OK = '[ENTITY] Fetch number of InsuranceProviderModel records successfully ',
	COUNT_INSURANCE_PROVIDERS_FAIL = '[ENTITY] Fetch number of InsuranceProviderModel records failed',

	IMPORT_INSURANCE_PROVIDERS = '[ENTITY] Import InsuranceProviderModels',
	IMPORT_INSURANCE_PROVIDERS_OK = '[ENTITY] Import InsuranceProviderModels successfully',
	IMPORT_INSURANCE_PROVIDERS_FAIL = '[ENTITY] Import InsuranceProviderModels fail',


	INITIALISE_INSURANCE_PROVIDER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InsuranceProviderModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInsuranceProviderAction implements Action {
	readonly className: string = 'InsuranceProviderModel';

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

export class InsuranceProviderAction extends BaseInsuranceProviderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InsuranceProviderAction here] off begin
	// % protected region % [Add any additional class fields for InsuranceProviderAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InsuranceProviderModel>,
		// % protected region % [Add any additional constructor parameters for InsuranceProviderAction here] off begin
		// % protected region % [Add any additional constructor parameters for InsuranceProviderAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InsuranceProviderAction here] off begin
			// % protected region % [Add any additional constructor arguments for InsuranceProviderAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InsuranceProviderAction here] off begin
		// % protected region % [Add any additional constructor logic for InsuranceProviderAction here] end
	}

	// % protected region % [Add any additional class methods for InsuranceProviderAction here] off begin
	// % protected region % [Add any additional class methods for InsuranceProviderAction here] end
}

export class InsuranceProviderActionOK extends BaseInsuranceProviderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InsuranceProviderActionOK here] off begin
	// % protected region % [Add any additional class fields for InsuranceProviderActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InsuranceProviderModel>,
		// % protected region % [Add any additional constructor parameters for InsuranceProviderActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InsuranceProviderActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InsuranceProviderModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InsuranceProviderActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InsuranceProviderActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InsuranceProviderActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InsuranceProviderActionOK here] end
	}

	// % protected region % [Add any additional class methods for InsuranceProviderActionOK here] off begin
	// % protected region % [Add any additional class methods for InsuranceProviderActionOK here] end
}

export class InsuranceProviderActionFail extends BaseInsuranceProviderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InsuranceProviderActionFail here] off begin
	// % protected region % [Add any additional class fields for InsuranceProviderActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InsuranceProviderModel>,
		// % protected region % [Add any additional constructor parameters for InsuranceProviderActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InsuranceProviderActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InsuranceProviderActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InsuranceProviderActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InsuranceProviderActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InsuranceProviderActionFail here] end
	}

	// % protected region % [Add any additional class methods for InsuranceProviderActionFail here] off begin
	// % protected region % [Add any additional class methods for InsuranceProviderActionFail here] end
}

export function isInsuranceProviderModelAction(e: any): e is BaseInsuranceProviderAction {
	return Object.values(InsuranceProviderModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
