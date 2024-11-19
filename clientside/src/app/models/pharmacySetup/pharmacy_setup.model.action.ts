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
import {PharmacySetupModel} from './pharmacy_setup.model';
import {PharmacySetupModelAudit} from './pharmacy_setup.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Pharmacy Setup model actions to be dispatched by NgRx.
 */
export enum PharmacySetupModelActionTypes {
	CREATE_PHARMACY_SETUP = '[ENTITY] Create PharmacySetupModel',
	CREATE_PHARMACY_SETUP_OK = '[ENTITY] Create PharmacySetupModel successfully',
	CREATE_PHARMACY_SETUP_FAIL = '[ENTITY] Create PharmacySetupModel failed',

	CREATE_ALL_PHARMACY_SETUP = '[ENTITY] Create All PharmacySetupModel',
	CREATE_ALL_PHARMACY_SETUP_OK = '[ENTITY] Create All PharmacySetupModel successfully',
	CREATE_ALL_PHARMACY_SETUP_FAIL = '[ENTITY] Create All PharmacySetupModel failed',

	DELETE_PHARMACY_SETUP = '[ENTITY] Delete PharmacySetupModel',
	DELETE_PHARMACY_SETUP_OK = '[ENTITY] Delete PharmacySetupModel successfully',
	DELETE_PHARMACY_SETUP_FAIL = '[ENTITY] Delete PharmacySetupModel failed',


	DELETE_PHARMACY_SETUP_EXCLUDING_IDS = '[ENTITY] Delete PharmacySetupModels Excluding Ids',
	DELETE_PHARMACY_SETUP_EXCLUDING_IDS_OK = '[ENTITY] Delete PharmacySetupModels Excluding Ids successfully',
	DELETE_PHARMACY_SETUP_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PharmacySetupModels Excluding Ids failed',

	DELETE_ALL_PHARMACY_SETUP = '[ENTITY] Delete all PharmacySetupModels',
	DELETE_ALL_PHARMACY_SETUP_OK = '[ENTITY] Delete all PharmacySetupModels successfully',
	DELETE_ALL_PHARMACY_SETUP_FAIL = '[ENTITY] Delete all PharmacySetupModels failed',

	UPDATE_PHARMACY_SETUP = '[ENTITY] Update PharmacySetupModel',
	UPDATE_PHARMACY_SETUP_OK = '[ENTITY] Update PharmacySetupModel successfully',
	UPDATE_PHARMACY_SETUP_FAIL = '[ENTITY] Update PharmacySetupModel failed',

	UPDATE_ALL_PHARMACY_SETUP = '[ENTITY] Update all PharmacySetupModel',
	UPDATE_ALL_PHARMACY_SETUP_OK = '[ENTITY] Update all PharmacySetupModel successfully',
	UPDATE_ALL_PHARMACY_SETUP_FAIL = '[ENTITY] Update all PharmacySetupModel failed',

	FETCH_PHARMACY_SETUP= '[ENTITY] Fetch PharmacySetupModel',
	FETCH_PHARMACY_SETUP_OK = '[ENTITY] Fetch PharmacySetupModel successfully',
	FETCH_PHARMACY_SETUP_FAIL = '[ENTITY] Fetch PharmacySetupModel failed',

	FETCH_PHARMACY_SETUP_AUDIT= '[ENTITY] Fetch PharmacySetupModel audit',
	FETCH_PHARMACY_SETUP_AUDIT_OK = '[ENTITY] Fetch PharmacySetupModel audit successfully',
	FETCH_PHARMACY_SETUP_AUDIT_FAIL = '[ENTITY] Fetch PharmacySetupModel audit failed',

	FETCH_PHARMACY_SETUP_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PharmacySetupModel audits by entity id',
	FETCH_PHARMACY_SETUP_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PharmacySetupModel audits by entity id successfully',
	FETCH_PHARMACY_SETUP_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PharmacySetupModel audits by entity id failed',

	FETCH_ALL_PHARMACY_SETUP = '[ENTITY] Fetch all PharmacySetupModel',
	FETCH_ALL_PHARMACY_SETUP_OK = '[ENTITY] Fetch all PharmacySetupModel successfully',
	FETCH_ALL_PHARMACY_SETUP_FAIL = '[ENTITY] Fetch all PharmacySetupModel failed',

	FETCH_PHARMACY_SETUP_WITH_QUERY = '[ENTITY] Fetch PharmacySetupModel with query',
	FETCH_PHARMACY_SETUP_WITH_QUERY_OK = '[ENTITY] Fetch PharmacySetupModel with query successfully',
	FETCH_PHARMACY_SETUP_WITH_QUERY_FAIL = '[ENTITY] Fetch PharmacySetupModel with query failed',

	FETCH_LAST_PHARMACY_SETUP_WITH_QUERY = '[ENTITY] Fetch last PharmacySetupModel with query',
	FETCH_LAST_PHARMACY_SETUP_WITH_QUERY_OK = '[ENTITY] Fetch last PharmacySetupModel with query successfully',
	FETCH_LAST_PHARMACY_SETUP_WITH_QUERY_FAIL = '[ENTITY] Fetch last PharmacySetupModel with query failed',

	EXPORT_PHARMACY_SETUP = '[ENTITY] Export PharmacySetupModel',
	EXPORT_PHARMACY_SETUP_OK = '[ENTITY] Export PharmacySetupModel successfully',
	EXPORT_PHARMACY_SETUP_FAIL = '[ENTITY] Export PharmacySetupModel failed',

	EXPORT_ALL_PHARMACY_SETUP = '[ENTITY] Export All PharmacySetupModels',
	EXPORT_ALL_PHARMACY_SETUP_OK = '[ENTITY] Export All PharmacySetupModels successfully',
	EXPORT_ALL_PHARMACY_SETUP_FAIL = '[ENTITY] Export All PharmacySetupModels failed',

	EXPORT_PHARMACY_SETUP_EXCLUDING_IDS = '[ENTITY] Export PharmacySetupModels excluding Ids',
	EXPORT_PHARMACY_SETUP_EXCLUDING_IDS_OK = '[ENTITY] Export PharmacySetupModel excluding Ids successfully',
	EXPORT_PHARMACY_SETUP_EXCLUDING_IDS_FAIL = '[ENTITY] Export PharmacySetupModel excluding Ids failed',

	COUNT_PHARMACY_SETUPS = '[ENTITY] Fetch number of PharmacySetupModel records',
	COUNT_PHARMACY_SETUPS_OK = '[ENTITY] Fetch number of PharmacySetupModel records successfully ',
	COUNT_PHARMACY_SETUPS_FAIL = '[ENTITY] Fetch number of PharmacySetupModel records failed',

	IMPORT_PHARMACY_SETUPS = '[ENTITY] Import PharmacySetupModels',
	IMPORT_PHARMACY_SETUPS_OK = '[ENTITY] Import PharmacySetupModels successfully',
	IMPORT_PHARMACY_SETUPS_FAIL = '[ENTITY] Import PharmacySetupModels fail',


	INITIALISE_PHARMACY_SETUP_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PharmacySetupModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePharmacySetupAction implements Action {
	readonly className: string = 'PharmacySetupModel';

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

export class PharmacySetupAction extends BasePharmacySetupAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PharmacySetupAction here] off begin
	// % protected region % [Add any additional class fields for PharmacySetupAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PharmacySetupModel>,
		// % protected region % [Add any additional constructor parameters for PharmacySetupAction here] off begin
		// % protected region % [Add any additional constructor parameters for PharmacySetupAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PharmacySetupAction here] off begin
			// % protected region % [Add any additional constructor arguments for PharmacySetupAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PharmacySetupAction here] off begin
		// % protected region % [Add any additional constructor logic for PharmacySetupAction here] end
	}

	// % protected region % [Add any additional class methods for PharmacySetupAction here] off begin
	// % protected region % [Add any additional class methods for PharmacySetupAction here] end
}

export class PharmacySetupActionOK extends BasePharmacySetupAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PharmacySetupActionOK here] off begin
	// % protected region % [Add any additional class fields for PharmacySetupActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PharmacySetupModel>,
		// % protected region % [Add any additional constructor parameters for PharmacySetupActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PharmacySetupActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PharmacySetupModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PharmacySetupActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PharmacySetupActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PharmacySetupActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PharmacySetupActionOK here] end
	}

	// % protected region % [Add any additional class methods for PharmacySetupActionOK here] off begin
	// % protected region % [Add any additional class methods for PharmacySetupActionOK here] end
}

export class PharmacySetupActionFail extends BasePharmacySetupAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PharmacySetupActionFail here] off begin
	// % protected region % [Add any additional class fields for PharmacySetupActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PharmacySetupModel>,
		// % protected region % [Add any additional constructor parameters for PharmacySetupActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PharmacySetupActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PharmacySetupActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PharmacySetupActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PharmacySetupActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PharmacySetupActionFail here] end
	}

	// % protected region % [Add any additional class methods for PharmacySetupActionFail here] off begin
	// % protected region % [Add any additional class methods for PharmacySetupActionFail here] end
}

export function isPharmacySetupModelAction(e: any): e is BasePharmacySetupAction {
	return Object.values(PharmacySetupModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
