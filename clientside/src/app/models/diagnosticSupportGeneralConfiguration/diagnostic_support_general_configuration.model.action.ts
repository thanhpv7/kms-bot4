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
import {DiagnosticSupportGeneralConfigurationModel} from './diagnostic_support_general_configuration.model';
import {DiagnosticSupportGeneralConfigurationModelAudit} from './diagnostic_support_general_configuration.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Diagnostic Support General Configuration model actions to be dispatched by NgRx.
 */
export enum DiagnosticSupportGeneralConfigurationModelActionTypes {
	CREATE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION = '[ENTITY] Create DiagnosticSupportGeneralConfigurationModel',
	CREATE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Create DiagnosticSupportGeneralConfigurationModel successfully',
	CREATE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Create DiagnosticSupportGeneralConfigurationModel failed',

	CREATE_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION = '[ENTITY] Create All DiagnosticSupportGeneralConfigurationModel',
	CREATE_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Create All DiagnosticSupportGeneralConfigurationModel successfully',
	CREATE_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Create All DiagnosticSupportGeneralConfigurationModel failed',

	DELETE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION = '[ENTITY] Delete DiagnosticSupportGeneralConfigurationModel',
	DELETE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Delete DiagnosticSupportGeneralConfigurationModel successfully',
	DELETE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Delete DiagnosticSupportGeneralConfigurationModel failed',


	DELETE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_EXCLUDING_IDS = '[ENTITY] Delete DiagnosticSupportGeneralConfigurationModels Excluding Ids',
	DELETE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_EXCLUDING_IDS_OK = '[ENTITY] Delete DiagnosticSupportGeneralConfigurationModels Excluding Ids successfully',
	DELETE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DiagnosticSupportGeneralConfigurationModels Excluding Ids failed',

	DELETE_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION = '[ENTITY] Delete all DiagnosticSupportGeneralConfigurationModels',
	DELETE_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Delete all DiagnosticSupportGeneralConfigurationModels successfully',
	DELETE_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Delete all DiagnosticSupportGeneralConfigurationModels failed',

	UPDATE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION = '[ENTITY] Update DiagnosticSupportGeneralConfigurationModel',
	UPDATE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Update DiagnosticSupportGeneralConfigurationModel successfully',
	UPDATE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Update DiagnosticSupportGeneralConfigurationModel failed',

	UPDATE_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION = '[ENTITY] Update all DiagnosticSupportGeneralConfigurationModel',
	UPDATE_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Update all DiagnosticSupportGeneralConfigurationModel successfully',
	UPDATE_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Update all DiagnosticSupportGeneralConfigurationModel failed',

	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION= '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel',
	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel successfully',
	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel failed',

	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_AUDIT= '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel audit',
	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_AUDIT_OK = '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel audit successfully',
	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_AUDIT_FAIL = '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel audit failed',

	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel audits by entity id',
	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel audits by entity id successfully',
	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel audits by entity id failed',

	FETCH_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION = '[ENTITY] Fetch all DiagnosticSupportGeneralConfigurationModel',
	FETCH_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Fetch all DiagnosticSupportGeneralConfigurationModel successfully',
	FETCH_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Fetch all DiagnosticSupportGeneralConfigurationModel failed',

	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_WITH_QUERY = '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel with query',
	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_WITH_QUERY_OK = '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel with query successfully',
	FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_WITH_QUERY_FAIL = '[ENTITY] Fetch DiagnosticSupportGeneralConfigurationModel with query failed',

	FETCH_LAST_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_WITH_QUERY = '[ENTITY] Fetch last DiagnosticSupportGeneralConfigurationModel with query',
	FETCH_LAST_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_WITH_QUERY_OK = '[ENTITY] Fetch last DiagnosticSupportGeneralConfigurationModel with query successfully',
	FETCH_LAST_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last DiagnosticSupportGeneralConfigurationModel with query failed',

	EXPORT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION = '[ENTITY] Export DiagnosticSupportGeneralConfigurationModel',
	EXPORT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Export DiagnosticSupportGeneralConfigurationModel successfully',
	EXPORT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Export DiagnosticSupportGeneralConfigurationModel failed',

	EXPORT_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION = '[ENTITY] Export All DiagnosticSupportGeneralConfigurationModels',
	EXPORT_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_OK = '[ENTITY] Export All DiagnosticSupportGeneralConfigurationModels successfully',
	EXPORT_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_FAIL = '[ENTITY] Export All DiagnosticSupportGeneralConfigurationModels failed',

	EXPORT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_EXCLUDING_IDS = '[ENTITY] Export DiagnosticSupportGeneralConfigurationModels excluding Ids',
	EXPORT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_EXCLUDING_IDS_OK = '[ENTITY] Export DiagnosticSupportGeneralConfigurationModel excluding Ids successfully',
	EXPORT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export DiagnosticSupportGeneralConfigurationModel excluding Ids failed',

	COUNT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATIONS = '[ENTITY] Fetch number of DiagnosticSupportGeneralConfigurationModel records',
	COUNT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATIONS_OK = '[ENTITY] Fetch number of DiagnosticSupportGeneralConfigurationModel records successfully ',
	COUNT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATIONS_FAIL = '[ENTITY] Fetch number of DiagnosticSupportGeneralConfigurationModel records failed',

	IMPORT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATIONS = '[ENTITY] Import DiagnosticSupportGeneralConfigurationModels',
	IMPORT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATIONS_OK = '[ENTITY] Import DiagnosticSupportGeneralConfigurationModels successfully',
	IMPORT_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATIONS_FAIL = '[ENTITY] Import DiagnosticSupportGeneralConfigurationModels fail',


	INITIALISE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DiagnosticSupportGeneralConfigurationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDiagnosticSupportGeneralConfigurationAction implements Action {
	readonly className: string = 'DiagnosticSupportGeneralConfigurationModel';

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

export class DiagnosticSupportGeneralConfigurationAction extends BaseDiagnosticSupportGeneralConfigurationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticSupportGeneralConfigurationAction here] off begin
	// % protected region % [Add any additional class fields for DiagnosticSupportGeneralConfigurationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosticSupportGeneralConfigurationModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportGeneralConfigurationAction here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportGeneralConfigurationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportGeneralConfigurationAction here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportGeneralConfigurationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticSupportGeneralConfigurationAction here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticSupportGeneralConfigurationAction here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticSupportGeneralConfigurationAction here] off begin
	// % protected region % [Add any additional class methods for DiagnosticSupportGeneralConfigurationAction here] end
}

export class DiagnosticSupportGeneralConfigurationActionOK extends BaseDiagnosticSupportGeneralConfigurationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticSupportGeneralConfigurationActionOK here] off begin
	// % protected region % [Add any additional class fields for DiagnosticSupportGeneralConfigurationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosticSupportGeneralConfigurationModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportGeneralConfigurationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportGeneralConfigurationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DiagnosticSupportGeneralConfigurationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportGeneralConfigurationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportGeneralConfigurationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticSupportGeneralConfigurationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticSupportGeneralConfigurationActionOK here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticSupportGeneralConfigurationActionOK here] off begin
	// % protected region % [Add any additional class methods for DiagnosticSupportGeneralConfigurationActionOK here] end
}

export class DiagnosticSupportGeneralConfigurationActionFail extends BaseDiagnosticSupportGeneralConfigurationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosticSupportGeneralConfigurationActionFail here] off begin
	// % protected region % [Add any additional class fields for DiagnosticSupportGeneralConfigurationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DiagnosticSupportGeneralConfigurationModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportGeneralConfigurationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosticSupportGeneralConfigurationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportGeneralConfigurationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosticSupportGeneralConfigurationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosticSupportGeneralConfigurationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosticSupportGeneralConfigurationActionFail here] end
	}

	// % protected region % [Add any additional class methods for DiagnosticSupportGeneralConfigurationActionFail here] off begin
	// % protected region % [Add any additional class methods for DiagnosticSupportGeneralConfigurationActionFail here] end
}

export function isDiagnosticSupportGeneralConfigurationModelAction(e: any): e is BaseDiagnosticSupportGeneralConfigurationAction {
	return Object.values(DiagnosticSupportGeneralConfigurationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
