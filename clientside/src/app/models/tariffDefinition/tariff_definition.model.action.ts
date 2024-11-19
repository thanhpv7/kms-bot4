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
import {TariffDefinitionModel} from './tariff_definition.model';
import {TariffDefinitionModelAudit} from './tariff_definition.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Tariff Definition model actions to be dispatched by NgRx.
 */
export enum TariffDefinitionModelActionTypes {
	CREATE_TARIFF_DEFINITION = '[ENTITY] Create TariffDefinitionModel',
	CREATE_TARIFF_DEFINITION_OK = '[ENTITY] Create TariffDefinitionModel successfully',
	CREATE_TARIFF_DEFINITION_FAIL = '[ENTITY] Create TariffDefinitionModel failed',

	CREATE_ALL_TARIFF_DEFINITION = '[ENTITY] Create All TariffDefinitionModel',
	CREATE_ALL_TARIFF_DEFINITION_OK = '[ENTITY] Create All TariffDefinitionModel successfully',
	CREATE_ALL_TARIFF_DEFINITION_FAIL = '[ENTITY] Create All TariffDefinitionModel failed',

	DELETE_TARIFF_DEFINITION = '[ENTITY] Delete TariffDefinitionModel',
	DELETE_TARIFF_DEFINITION_OK = '[ENTITY] Delete TariffDefinitionModel successfully',
	DELETE_TARIFF_DEFINITION_FAIL = '[ENTITY] Delete TariffDefinitionModel failed',


	DELETE_TARIFF_DEFINITION_EXCLUDING_IDS = '[ENTITY] Delete TariffDefinitionModels Excluding Ids',
	DELETE_TARIFF_DEFINITION_EXCLUDING_IDS_OK = '[ENTITY] Delete TariffDefinitionModels Excluding Ids successfully',
	DELETE_TARIFF_DEFINITION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TariffDefinitionModels Excluding Ids failed',

	DELETE_ALL_TARIFF_DEFINITION = '[ENTITY] Delete all TariffDefinitionModels',
	DELETE_ALL_TARIFF_DEFINITION_OK = '[ENTITY] Delete all TariffDefinitionModels successfully',
	DELETE_ALL_TARIFF_DEFINITION_FAIL = '[ENTITY] Delete all TariffDefinitionModels failed',

	UPDATE_TARIFF_DEFINITION = '[ENTITY] Update TariffDefinitionModel',
	UPDATE_TARIFF_DEFINITION_OK = '[ENTITY] Update TariffDefinitionModel successfully',
	UPDATE_TARIFF_DEFINITION_FAIL = '[ENTITY] Update TariffDefinitionModel failed',

	UPDATE_ALL_TARIFF_DEFINITION = '[ENTITY] Update all TariffDefinitionModel',
	UPDATE_ALL_TARIFF_DEFINITION_OK = '[ENTITY] Update all TariffDefinitionModel successfully',
	UPDATE_ALL_TARIFF_DEFINITION_FAIL = '[ENTITY] Update all TariffDefinitionModel failed',

	FETCH_TARIFF_DEFINITION= '[ENTITY] Fetch TariffDefinitionModel',
	FETCH_TARIFF_DEFINITION_OK = '[ENTITY] Fetch TariffDefinitionModel successfully',
	FETCH_TARIFF_DEFINITION_FAIL = '[ENTITY] Fetch TariffDefinitionModel failed',

	FETCH_TARIFF_DEFINITION_AUDIT= '[ENTITY] Fetch TariffDefinitionModel audit',
	FETCH_TARIFF_DEFINITION_AUDIT_OK = '[ENTITY] Fetch TariffDefinitionModel audit successfully',
	FETCH_TARIFF_DEFINITION_AUDIT_FAIL = '[ENTITY] Fetch TariffDefinitionModel audit failed',

	FETCH_TARIFF_DEFINITION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TariffDefinitionModel audits by entity id',
	FETCH_TARIFF_DEFINITION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TariffDefinitionModel audits by entity id successfully',
	FETCH_TARIFF_DEFINITION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TariffDefinitionModel audits by entity id failed',

	FETCH_ALL_TARIFF_DEFINITION = '[ENTITY] Fetch all TariffDefinitionModel',
	FETCH_ALL_TARIFF_DEFINITION_OK = '[ENTITY] Fetch all TariffDefinitionModel successfully',
	FETCH_ALL_TARIFF_DEFINITION_FAIL = '[ENTITY] Fetch all TariffDefinitionModel failed',

	FETCH_TARIFF_DEFINITION_WITH_QUERY = '[ENTITY] Fetch TariffDefinitionModel with query',
	FETCH_TARIFF_DEFINITION_WITH_QUERY_OK = '[ENTITY] Fetch TariffDefinitionModel with query successfully',
	FETCH_TARIFF_DEFINITION_WITH_QUERY_FAIL = '[ENTITY] Fetch TariffDefinitionModel with query failed',

	FETCH_LAST_TARIFF_DEFINITION_WITH_QUERY = '[ENTITY] Fetch last TariffDefinitionModel with query',
	FETCH_LAST_TARIFF_DEFINITION_WITH_QUERY_OK = '[ENTITY] Fetch last TariffDefinitionModel with query successfully',
	FETCH_LAST_TARIFF_DEFINITION_WITH_QUERY_FAIL = '[ENTITY] Fetch last TariffDefinitionModel with query failed',

	EXPORT_TARIFF_DEFINITION = '[ENTITY] Export TariffDefinitionModel',
	EXPORT_TARIFF_DEFINITION_OK = '[ENTITY] Export TariffDefinitionModel successfully',
	EXPORT_TARIFF_DEFINITION_FAIL = '[ENTITY] Export TariffDefinitionModel failed',

	EXPORT_ALL_TARIFF_DEFINITION = '[ENTITY] Export All TariffDefinitionModels',
	EXPORT_ALL_TARIFF_DEFINITION_OK = '[ENTITY] Export All TariffDefinitionModels successfully',
	EXPORT_ALL_TARIFF_DEFINITION_FAIL = '[ENTITY] Export All TariffDefinitionModels failed',

	EXPORT_TARIFF_DEFINITION_EXCLUDING_IDS = '[ENTITY] Export TariffDefinitionModels excluding Ids',
	EXPORT_TARIFF_DEFINITION_EXCLUDING_IDS_OK = '[ENTITY] Export TariffDefinitionModel excluding Ids successfully',
	EXPORT_TARIFF_DEFINITION_EXCLUDING_IDS_FAIL = '[ENTITY] Export TariffDefinitionModel excluding Ids failed',

	COUNT_TARIFF_DEFINITIONS = '[ENTITY] Fetch number of TariffDefinitionModel records',
	COUNT_TARIFF_DEFINITIONS_OK = '[ENTITY] Fetch number of TariffDefinitionModel records successfully ',
	COUNT_TARIFF_DEFINITIONS_FAIL = '[ENTITY] Fetch number of TariffDefinitionModel records failed',

	IMPORT_TARIFF_DEFINITIONS = '[ENTITY] Import TariffDefinitionModels',
	IMPORT_TARIFF_DEFINITIONS_OK = '[ENTITY] Import TariffDefinitionModels successfully',
	IMPORT_TARIFF_DEFINITIONS_FAIL = '[ENTITY] Import TariffDefinitionModels fail',


	INITIALISE_TARIFF_DEFINITION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TariffDefinitionModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTariffDefinitionAction implements Action {
	readonly className: string = 'TariffDefinitionModel';

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

export class TariffDefinitionAction extends BaseTariffDefinitionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffDefinitionAction here] off begin
	// % protected region % [Add any additional class fields for TariffDefinitionAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffDefinitionModel>,
		// % protected region % [Add any additional constructor parameters for TariffDefinitionAction here] off begin
		// % protected region % [Add any additional constructor parameters for TariffDefinitionAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffDefinitionAction here] off begin
			// % protected region % [Add any additional constructor arguments for TariffDefinitionAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffDefinitionAction here] off begin
		// % protected region % [Add any additional constructor logic for TariffDefinitionAction here] end
	}

	// % protected region % [Add any additional class methods for TariffDefinitionAction here] off begin
	// % protected region % [Add any additional class methods for TariffDefinitionAction here] end
}

export class TariffDefinitionActionOK extends BaseTariffDefinitionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffDefinitionActionOK here] off begin
	// % protected region % [Add any additional class fields for TariffDefinitionActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffDefinitionModel>,
		// % protected region % [Add any additional constructor parameters for TariffDefinitionActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TariffDefinitionActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TariffDefinitionModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffDefinitionActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TariffDefinitionActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffDefinitionActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TariffDefinitionActionOK here] end
	}

	// % protected region % [Add any additional class methods for TariffDefinitionActionOK here] off begin
	// % protected region % [Add any additional class methods for TariffDefinitionActionOK here] end
}

export class TariffDefinitionActionFail extends BaseTariffDefinitionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffDefinitionActionFail here] off begin
	// % protected region % [Add any additional class fields for TariffDefinitionActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TariffDefinitionModel>,
		// % protected region % [Add any additional constructor parameters for TariffDefinitionActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TariffDefinitionActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffDefinitionActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TariffDefinitionActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffDefinitionActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TariffDefinitionActionFail here] end
	}

	// % protected region % [Add any additional class methods for TariffDefinitionActionFail here] off begin
	// % protected region % [Add any additional class methods for TariffDefinitionActionFail here] end
}

export function isTariffDefinitionModelAction(e: any): e is BaseTariffDefinitionAction {
	return Object.values(TariffDefinitionModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
