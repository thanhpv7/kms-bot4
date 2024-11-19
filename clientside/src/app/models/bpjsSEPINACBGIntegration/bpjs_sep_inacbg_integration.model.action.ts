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
import {BpjsSEPINACBGIntegrationModel} from './bpjs_sep_inacbg_integration.model';
import {BpjsSEPINACBGIntegrationModelAudit} from './bpjs_sep_inacbg_integration.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS SEP INACBG Integration model actions to be dispatched by NgRx.
 */
export enum BpjsSEPINACBGIntegrationModelActionTypes {
	CREATE_BPJS_SEP_INACBG_INTEGRATION = '[ENTITY] Create BpjsSEPINACBGIntegrationModel',
	CREATE_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Create BpjsSEPINACBGIntegrationModel successfully',
	CREATE_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Create BpjsSEPINACBGIntegrationModel failed',

	CREATE_ALL_BPJS_SEP_INACBG_INTEGRATION = '[ENTITY] Create All BpjsSEPINACBGIntegrationModel',
	CREATE_ALL_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Create All BpjsSEPINACBGIntegrationModel successfully',
	CREATE_ALL_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Create All BpjsSEPINACBGIntegrationModel failed',

	DELETE_BPJS_SEP_INACBG_INTEGRATION = '[ENTITY] Delete BpjsSEPINACBGIntegrationModel',
	DELETE_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Delete BpjsSEPINACBGIntegrationModel successfully',
	DELETE_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Delete BpjsSEPINACBGIntegrationModel failed',


	DELETE_BPJS_SEP_INACBG_INTEGRATION_EXCLUDING_IDS = '[ENTITY] Delete BpjsSEPINACBGIntegrationModels Excluding Ids',
	DELETE_BPJS_SEP_INACBG_INTEGRATION_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsSEPINACBGIntegrationModels Excluding Ids successfully',
	DELETE_BPJS_SEP_INACBG_INTEGRATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsSEPINACBGIntegrationModels Excluding Ids failed',

	DELETE_ALL_BPJS_SEP_INACBG_INTEGRATION = '[ENTITY] Delete all BpjsSEPINACBGIntegrationModels',
	DELETE_ALL_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Delete all BpjsSEPINACBGIntegrationModels successfully',
	DELETE_ALL_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Delete all BpjsSEPINACBGIntegrationModels failed',

	UPDATE_BPJS_SEP_INACBG_INTEGRATION = '[ENTITY] Update BpjsSEPINACBGIntegrationModel',
	UPDATE_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Update BpjsSEPINACBGIntegrationModel successfully',
	UPDATE_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Update BpjsSEPINACBGIntegrationModel failed',

	UPDATE_ALL_BPJS_SEP_INACBG_INTEGRATION = '[ENTITY] Update all BpjsSEPINACBGIntegrationModel',
	UPDATE_ALL_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Update all BpjsSEPINACBGIntegrationModel successfully',
	UPDATE_ALL_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Update all BpjsSEPINACBGIntegrationModel failed',

	FETCH_BPJS_SEP_INACBG_INTEGRATION= '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel',
	FETCH_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel successfully',
	FETCH_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel failed',

	FETCH_BPJS_SEP_INACBG_INTEGRATION_AUDIT= '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel audit',
	FETCH_BPJS_SEP_INACBG_INTEGRATION_AUDIT_OK = '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel audit successfully',
	FETCH_BPJS_SEP_INACBG_INTEGRATION_AUDIT_FAIL = '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel audit failed',

	FETCH_BPJS_SEP_INACBG_INTEGRATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel audits by entity id',
	FETCH_BPJS_SEP_INACBG_INTEGRATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel audits by entity id successfully',
	FETCH_BPJS_SEP_INACBG_INTEGRATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel audits by entity id failed',

	FETCH_ALL_BPJS_SEP_INACBG_INTEGRATION = '[ENTITY] Fetch all BpjsSEPINACBGIntegrationModel',
	FETCH_ALL_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Fetch all BpjsSEPINACBGIntegrationModel successfully',
	FETCH_ALL_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Fetch all BpjsSEPINACBGIntegrationModel failed',

	FETCH_BPJS_SEP_INACBG_INTEGRATION_WITH_QUERY = '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel with query',
	FETCH_BPJS_SEP_INACBG_INTEGRATION_WITH_QUERY_OK = '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel with query successfully',
	FETCH_BPJS_SEP_INACBG_INTEGRATION_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsSEPINACBGIntegrationModel with query failed',

	FETCH_LAST_BPJS_SEP_INACBG_INTEGRATION_WITH_QUERY = '[ENTITY] Fetch last BpjsSEPINACBGIntegrationModel with query',
	FETCH_LAST_BPJS_SEP_INACBG_INTEGRATION_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsSEPINACBGIntegrationModel with query successfully',
	FETCH_LAST_BPJS_SEP_INACBG_INTEGRATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsSEPINACBGIntegrationModel with query failed',

	EXPORT_BPJS_SEP_INACBG_INTEGRATION = '[ENTITY] Export BpjsSEPINACBGIntegrationModel',
	EXPORT_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Export BpjsSEPINACBGIntegrationModel successfully',
	EXPORT_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Export BpjsSEPINACBGIntegrationModel failed',

	EXPORT_ALL_BPJS_SEP_INACBG_INTEGRATION = '[ENTITY] Export All BpjsSEPINACBGIntegrationModels',
	EXPORT_ALL_BPJS_SEP_INACBG_INTEGRATION_OK = '[ENTITY] Export All BpjsSEPINACBGIntegrationModels successfully',
	EXPORT_ALL_BPJS_SEP_INACBG_INTEGRATION_FAIL = '[ENTITY] Export All BpjsSEPINACBGIntegrationModels failed',

	EXPORT_BPJS_SEP_INACBG_INTEGRATION_EXCLUDING_IDS = '[ENTITY] Export BpjsSEPINACBGIntegrationModels excluding Ids',
	EXPORT_BPJS_SEP_INACBG_INTEGRATION_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsSEPINACBGIntegrationModel excluding Ids successfully',
	EXPORT_BPJS_SEP_INACBG_INTEGRATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsSEPINACBGIntegrationModel excluding Ids failed',

	COUNT_BPJS_SEP_INACBG_INTEGRATIONS = '[ENTITY] Fetch number of BpjsSEPINACBGIntegrationModel records',
	COUNT_BPJS_SEP_INACBG_INTEGRATIONS_OK = '[ENTITY] Fetch number of BpjsSEPINACBGIntegrationModel records successfully ',
	COUNT_BPJS_SEP_INACBG_INTEGRATIONS_FAIL = '[ENTITY] Fetch number of BpjsSEPINACBGIntegrationModel records failed',

	IMPORT_BPJS_SEP_INACBG_INTEGRATIONS = '[ENTITY] Import BpjsSEPINACBGIntegrationModels',
	IMPORT_BPJS_SEP_INACBG_INTEGRATIONS_OK = '[ENTITY] Import BpjsSEPINACBGIntegrationModels successfully',
	IMPORT_BPJS_SEP_INACBG_INTEGRATIONS_FAIL = '[ENTITY] Import BpjsSEPINACBGIntegrationModels fail',


	INITIALISE_BPJS_SEP_INACBG_INTEGRATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsSEPINACBGIntegrationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsSEPINACBGIntegrationAction implements Action {
	readonly className: string = 'BpjsSEPINACBGIntegrationModel';

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

export class BpjsSEPINACBGIntegrationAction extends BaseBpjsSEPINACBGIntegrationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPINACBGIntegrationAction here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPINACBGIntegrationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSEPINACBGIntegrationModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPINACBGIntegrationAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPINACBGIntegrationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPINACBGIntegrationAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPINACBGIntegrationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPINACBGIntegrationAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPINACBGIntegrationAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPINACBGIntegrationAction here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPINACBGIntegrationAction here] end
}

export class BpjsSEPINACBGIntegrationActionOK extends BaseBpjsSEPINACBGIntegrationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPINACBGIntegrationActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPINACBGIntegrationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSEPINACBGIntegrationModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPINACBGIntegrationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPINACBGIntegrationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsSEPINACBGIntegrationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPINACBGIntegrationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPINACBGIntegrationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPINACBGIntegrationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPINACBGIntegrationActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPINACBGIntegrationActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPINACBGIntegrationActionOK here] end
}

export class BpjsSEPINACBGIntegrationActionFail extends BaseBpjsSEPINACBGIntegrationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPINACBGIntegrationActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPINACBGIntegrationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsSEPINACBGIntegrationModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPINACBGIntegrationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPINACBGIntegrationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPINACBGIntegrationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPINACBGIntegrationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPINACBGIntegrationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPINACBGIntegrationActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPINACBGIntegrationActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPINACBGIntegrationActionFail here] end
}

export function isBpjsSEPINACBGIntegrationModelAction(e: any): e is BaseBpjsSEPINACBGIntegrationAction {
	return Object.values(BpjsSEPINACBGIntegrationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
