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
import {SatuSehatConfigurationModel} from './satu_sehat_configuration.model';
import {SatuSehatConfigurationModelAudit} from './satu_sehat_configuration.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Satu Sehat Configuration model actions to be dispatched by NgRx.
 */
export enum SatuSehatConfigurationModelActionTypes {
	CREATE_SATU_SEHAT_CONFIGURATION = '[ENTITY] Create SatuSehatConfigurationModel',
	CREATE_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Create SatuSehatConfigurationModel successfully',
	CREATE_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Create SatuSehatConfigurationModel failed',

	CREATE_ALL_SATU_SEHAT_CONFIGURATION = '[ENTITY] Create All SatuSehatConfigurationModel',
	CREATE_ALL_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Create All SatuSehatConfigurationModel successfully',
	CREATE_ALL_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Create All SatuSehatConfigurationModel failed',

	DELETE_SATU_SEHAT_CONFIGURATION = '[ENTITY] Delete SatuSehatConfigurationModel',
	DELETE_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Delete SatuSehatConfigurationModel successfully',
	DELETE_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Delete SatuSehatConfigurationModel failed',


	DELETE_SATU_SEHAT_CONFIGURATION_EXCLUDING_IDS = '[ENTITY] Delete SatuSehatConfigurationModels Excluding Ids',
	DELETE_SATU_SEHAT_CONFIGURATION_EXCLUDING_IDS_OK = '[ENTITY] Delete SatuSehatConfigurationModels Excluding Ids successfully',
	DELETE_SATU_SEHAT_CONFIGURATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete SatuSehatConfigurationModels Excluding Ids failed',

	DELETE_ALL_SATU_SEHAT_CONFIGURATION = '[ENTITY] Delete all SatuSehatConfigurationModels',
	DELETE_ALL_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Delete all SatuSehatConfigurationModels successfully',
	DELETE_ALL_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Delete all SatuSehatConfigurationModels failed',

	UPDATE_SATU_SEHAT_CONFIGURATION = '[ENTITY] Update SatuSehatConfigurationModel',
	UPDATE_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Update SatuSehatConfigurationModel successfully',
	UPDATE_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Update SatuSehatConfigurationModel failed',

	UPDATE_ALL_SATU_SEHAT_CONFIGURATION = '[ENTITY] Update all SatuSehatConfigurationModel',
	UPDATE_ALL_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Update all SatuSehatConfigurationModel successfully',
	UPDATE_ALL_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Update all SatuSehatConfigurationModel failed',

	FETCH_SATU_SEHAT_CONFIGURATION= '[ENTITY] Fetch SatuSehatConfigurationModel',
	FETCH_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Fetch SatuSehatConfigurationModel successfully',
	FETCH_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Fetch SatuSehatConfigurationModel failed',

	FETCH_SATU_SEHAT_CONFIGURATION_AUDIT= '[ENTITY] Fetch SatuSehatConfigurationModel audit',
	FETCH_SATU_SEHAT_CONFIGURATION_AUDIT_OK = '[ENTITY] Fetch SatuSehatConfigurationModel audit successfully',
	FETCH_SATU_SEHAT_CONFIGURATION_AUDIT_FAIL = '[ENTITY] Fetch SatuSehatConfigurationModel audit failed',

	FETCH_SATU_SEHAT_CONFIGURATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch SatuSehatConfigurationModel audits by entity id',
	FETCH_SATU_SEHAT_CONFIGURATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch SatuSehatConfigurationModel audits by entity id successfully',
	FETCH_SATU_SEHAT_CONFIGURATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch SatuSehatConfigurationModel audits by entity id failed',

	FETCH_ALL_SATU_SEHAT_CONFIGURATION = '[ENTITY] Fetch all SatuSehatConfigurationModel',
	FETCH_ALL_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Fetch all SatuSehatConfigurationModel successfully',
	FETCH_ALL_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Fetch all SatuSehatConfigurationModel failed',

	FETCH_SATU_SEHAT_CONFIGURATION_WITH_QUERY = '[ENTITY] Fetch SatuSehatConfigurationModel with query',
	FETCH_SATU_SEHAT_CONFIGURATION_WITH_QUERY_OK = '[ENTITY] Fetch SatuSehatConfigurationModel with query successfully',
	FETCH_SATU_SEHAT_CONFIGURATION_WITH_QUERY_FAIL = '[ENTITY] Fetch SatuSehatConfigurationModel with query failed',

	FETCH_LAST_SATU_SEHAT_CONFIGURATION_WITH_QUERY = '[ENTITY] Fetch last SatuSehatConfigurationModel with query',
	FETCH_LAST_SATU_SEHAT_CONFIGURATION_WITH_QUERY_OK = '[ENTITY] Fetch last SatuSehatConfigurationModel with query successfully',
	FETCH_LAST_SATU_SEHAT_CONFIGURATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last SatuSehatConfigurationModel with query failed',

	EXPORT_SATU_SEHAT_CONFIGURATION = '[ENTITY] Export SatuSehatConfigurationModel',
	EXPORT_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Export SatuSehatConfigurationModel successfully',
	EXPORT_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Export SatuSehatConfigurationModel failed',

	EXPORT_ALL_SATU_SEHAT_CONFIGURATION = '[ENTITY] Export All SatuSehatConfigurationModels',
	EXPORT_ALL_SATU_SEHAT_CONFIGURATION_OK = '[ENTITY] Export All SatuSehatConfigurationModels successfully',
	EXPORT_ALL_SATU_SEHAT_CONFIGURATION_FAIL = '[ENTITY] Export All SatuSehatConfigurationModels failed',

	EXPORT_SATU_SEHAT_CONFIGURATION_EXCLUDING_IDS = '[ENTITY] Export SatuSehatConfigurationModels excluding Ids',
	EXPORT_SATU_SEHAT_CONFIGURATION_EXCLUDING_IDS_OK = '[ENTITY] Export SatuSehatConfigurationModel excluding Ids successfully',
	EXPORT_SATU_SEHAT_CONFIGURATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export SatuSehatConfigurationModel excluding Ids failed',

	COUNT_SATU_SEHAT_CONFIGURATIONS = '[ENTITY] Fetch number of SatuSehatConfigurationModel records',
	COUNT_SATU_SEHAT_CONFIGURATIONS_OK = '[ENTITY] Fetch number of SatuSehatConfigurationModel records successfully ',
	COUNT_SATU_SEHAT_CONFIGURATIONS_FAIL = '[ENTITY] Fetch number of SatuSehatConfigurationModel records failed',

	IMPORT_SATU_SEHAT_CONFIGURATIONS = '[ENTITY] Import SatuSehatConfigurationModels',
	IMPORT_SATU_SEHAT_CONFIGURATIONS_OK = '[ENTITY] Import SatuSehatConfigurationModels successfully',
	IMPORT_SATU_SEHAT_CONFIGURATIONS_FAIL = '[ENTITY] Import SatuSehatConfigurationModels fail',


	INITIALISE_SATU_SEHAT_CONFIGURATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of SatuSehatConfigurationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseSatuSehatConfigurationAction implements Action {
	readonly className: string = 'SatuSehatConfigurationModel';

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

export class SatuSehatConfigurationAction extends BaseSatuSehatConfigurationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SatuSehatConfigurationAction here] off begin
	// % protected region % [Add any additional class fields for SatuSehatConfigurationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SatuSehatConfigurationModel>,
		// % protected region % [Add any additional constructor parameters for SatuSehatConfigurationAction here] off begin
		// % protected region % [Add any additional constructor parameters for SatuSehatConfigurationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SatuSehatConfigurationAction here] off begin
			// % protected region % [Add any additional constructor arguments for SatuSehatConfigurationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SatuSehatConfigurationAction here] off begin
		// % protected region % [Add any additional constructor logic for SatuSehatConfigurationAction here] end
	}

	// % protected region % [Add any additional class methods for SatuSehatConfigurationAction here] off begin
	// % protected region % [Add any additional class methods for SatuSehatConfigurationAction here] end
}

export class SatuSehatConfigurationActionOK extends BaseSatuSehatConfigurationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SatuSehatConfigurationActionOK here] off begin
	// % protected region % [Add any additional class fields for SatuSehatConfigurationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SatuSehatConfigurationModel>,
		// % protected region % [Add any additional constructor parameters for SatuSehatConfigurationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for SatuSehatConfigurationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: SatuSehatConfigurationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SatuSehatConfigurationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for SatuSehatConfigurationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SatuSehatConfigurationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for SatuSehatConfigurationActionOK here] end
	}

	// % protected region % [Add any additional class methods for SatuSehatConfigurationActionOK here] off begin
	// % protected region % [Add any additional class methods for SatuSehatConfigurationActionOK here] end
}

export class SatuSehatConfigurationActionFail extends BaseSatuSehatConfigurationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SatuSehatConfigurationActionFail here] off begin
	// % protected region % [Add any additional class fields for SatuSehatConfigurationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<SatuSehatConfigurationModel>,
		// % protected region % [Add any additional constructor parameters for SatuSehatConfigurationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for SatuSehatConfigurationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SatuSehatConfigurationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for SatuSehatConfigurationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SatuSehatConfigurationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for SatuSehatConfigurationActionFail here] end
	}

	// % protected region % [Add any additional class methods for SatuSehatConfigurationActionFail here] off begin
	// % protected region % [Add any additional class methods for SatuSehatConfigurationActionFail here] end
}

export function isSatuSehatConfigurationModelAction(e: any): e is BaseSatuSehatConfigurationAction {
	return Object.values(SatuSehatConfigurationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
