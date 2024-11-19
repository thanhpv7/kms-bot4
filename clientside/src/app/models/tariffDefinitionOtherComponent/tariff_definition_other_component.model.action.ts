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
import {TariffDefinitionOtherComponentModel} from './tariff_definition_other_component.model';
import {TariffDefinitionOtherComponentModelAudit} from './tariff_definition_other_component.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Tariff Definition Other Component model actions to be dispatched by NgRx.
 */
export enum TariffDefinitionOtherComponentModelActionTypes {
	CREATE_TARIFF_DEFINITION_OTHER_COMPONENT = '[ENTITY] Create TariffDefinitionOtherComponentModel',
	CREATE_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Create TariffDefinitionOtherComponentModel successfully',
	CREATE_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Create TariffDefinitionOtherComponentModel failed',

	CREATE_ALL_TARIFF_DEFINITION_OTHER_COMPONENT = '[ENTITY] Create All TariffDefinitionOtherComponentModel',
	CREATE_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Create All TariffDefinitionOtherComponentModel successfully',
	CREATE_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Create All TariffDefinitionOtherComponentModel failed',

	DELETE_TARIFF_DEFINITION_OTHER_COMPONENT = '[ENTITY] Delete TariffDefinitionOtherComponentModel',
	DELETE_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Delete TariffDefinitionOtherComponentModel successfully',
	DELETE_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Delete TariffDefinitionOtherComponentModel failed',


	DELETE_TARIFF_DEFINITION_OTHER_COMPONENT_EXCLUDING_IDS = '[ENTITY] Delete TariffDefinitionOtherComponentModels Excluding Ids',
	DELETE_TARIFF_DEFINITION_OTHER_COMPONENT_EXCLUDING_IDS_OK = '[ENTITY] Delete TariffDefinitionOtherComponentModels Excluding Ids successfully',
	DELETE_TARIFF_DEFINITION_OTHER_COMPONENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TariffDefinitionOtherComponentModels Excluding Ids failed',

	DELETE_ALL_TARIFF_DEFINITION_OTHER_COMPONENT = '[ENTITY] Delete all TariffDefinitionOtherComponentModels',
	DELETE_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Delete all TariffDefinitionOtherComponentModels successfully',
	DELETE_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Delete all TariffDefinitionOtherComponentModels failed',

	UPDATE_TARIFF_DEFINITION_OTHER_COMPONENT = '[ENTITY] Update TariffDefinitionOtherComponentModel',
	UPDATE_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Update TariffDefinitionOtherComponentModel successfully',
	UPDATE_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Update TariffDefinitionOtherComponentModel failed',

	UPDATE_ALL_TARIFF_DEFINITION_OTHER_COMPONENT = '[ENTITY] Update all TariffDefinitionOtherComponentModel',
	UPDATE_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Update all TariffDefinitionOtherComponentModel successfully',
	UPDATE_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Update all TariffDefinitionOtherComponentModel failed',

	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT= '[ENTITY] Fetch TariffDefinitionOtherComponentModel',
	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Fetch TariffDefinitionOtherComponentModel successfully',
	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Fetch TariffDefinitionOtherComponentModel failed',

	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_AUDIT= '[ENTITY] Fetch TariffDefinitionOtherComponentModel audit',
	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_AUDIT_OK = '[ENTITY] Fetch TariffDefinitionOtherComponentModel audit successfully',
	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_AUDIT_FAIL = '[ENTITY] Fetch TariffDefinitionOtherComponentModel audit failed',

	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TariffDefinitionOtherComponentModel audits by entity id',
	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TariffDefinitionOtherComponentModel audits by entity id successfully',
	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TariffDefinitionOtherComponentModel audits by entity id failed',

	FETCH_ALL_TARIFF_DEFINITION_OTHER_COMPONENT = '[ENTITY] Fetch all TariffDefinitionOtherComponentModel',
	FETCH_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Fetch all TariffDefinitionOtherComponentModel successfully',
	FETCH_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Fetch all TariffDefinitionOtherComponentModel failed',

	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_WITH_QUERY = '[ENTITY] Fetch TariffDefinitionOtherComponentModel with query',
	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_WITH_QUERY_OK = '[ENTITY] Fetch TariffDefinitionOtherComponentModel with query successfully',
	FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_WITH_QUERY_FAIL = '[ENTITY] Fetch TariffDefinitionOtherComponentModel with query failed',

	FETCH_LAST_TARIFF_DEFINITION_OTHER_COMPONENT_WITH_QUERY = '[ENTITY] Fetch last TariffDefinitionOtherComponentModel with query',
	FETCH_LAST_TARIFF_DEFINITION_OTHER_COMPONENT_WITH_QUERY_OK = '[ENTITY] Fetch last TariffDefinitionOtherComponentModel with query successfully',
	FETCH_LAST_TARIFF_DEFINITION_OTHER_COMPONENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last TariffDefinitionOtherComponentModel with query failed',

	EXPORT_TARIFF_DEFINITION_OTHER_COMPONENT = '[ENTITY] Export TariffDefinitionOtherComponentModel',
	EXPORT_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Export TariffDefinitionOtherComponentModel successfully',
	EXPORT_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Export TariffDefinitionOtherComponentModel failed',

	EXPORT_ALL_TARIFF_DEFINITION_OTHER_COMPONENT = '[ENTITY] Export All TariffDefinitionOtherComponentModels',
	EXPORT_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_OK = '[ENTITY] Export All TariffDefinitionOtherComponentModels successfully',
	EXPORT_ALL_TARIFF_DEFINITION_OTHER_COMPONENT_FAIL = '[ENTITY] Export All TariffDefinitionOtherComponentModels failed',

	EXPORT_TARIFF_DEFINITION_OTHER_COMPONENT_EXCLUDING_IDS = '[ENTITY] Export TariffDefinitionOtherComponentModels excluding Ids',
	EXPORT_TARIFF_DEFINITION_OTHER_COMPONENT_EXCLUDING_IDS_OK = '[ENTITY] Export TariffDefinitionOtherComponentModel excluding Ids successfully',
	EXPORT_TARIFF_DEFINITION_OTHER_COMPONENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export TariffDefinitionOtherComponentModel excluding Ids failed',

	COUNT_TARIFF_DEFINITION_OTHER_COMPONENTS = '[ENTITY] Fetch number of TariffDefinitionOtherComponentModel records',
	COUNT_TARIFF_DEFINITION_OTHER_COMPONENTS_OK = '[ENTITY] Fetch number of TariffDefinitionOtherComponentModel records successfully ',
	COUNT_TARIFF_DEFINITION_OTHER_COMPONENTS_FAIL = '[ENTITY] Fetch number of TariffDefinitionOtherComponentModel records failed',

	IMPORT_TARIFF_DEFINITION_OTHER_COMPONENTS = '[ENTITY] Import TariffDefinitionOtherComponentModels',
	IMPORT_TARIFF_DEFINITION_OTHER_COMPONENTS_OK = '[ENTITY] Import TariffDefinitionOtherComponentModels successfully',
	IMPORT_TARIFF_DEFINITION_OTHER_COMPONENTS_FAIL = '[ENTITY] Import TariffDefinitionOtherComponentModels fail',


	INITIALISE_TARIFF_DEFINITION_OTHER_COMPONENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TariffDefinitionOtherComponentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTariffDefinitionOtherComponentAction implements Action {
	readonly className: string = 'TariffDefinitionOtherComponentModel';

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

export class TariffDefinitionOtherComponentAction extends BaseTariffDefinitionOtherComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffDefinitionOtherComponentAction here] off begin
	// % protected region % [Add any additional class fields for TariffDefinitionOtherComponentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffDefinitionOtherComponentModel>,
		// % protected region % [Add any additional constructor parameters for TariffDefinitionOtherComponentAction here] off begin
		// % protected region % [Add any additional constructor parameters for TariffDefinitionOtherComponentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffDefinitionOtherComponentAction here] off begin
			// % protected region % [Add any additional constructor arguments for TariffDefinitionOtherComponentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffDefinitionOtherComponentAction here] off begin
		// % protected region % [Add any additional constructor logic for TariffDefinitionOtherComponentAction here] end
	}

	// % protected region % [Add any additional class methods for TariffDefinitionOtherComponentAction here] off begin
	// % protected region % [Add any additional class methods for TariffDefinitionOtherComponentAction here] end
}

export class TariffDefinitionOtherComponentActionOK extends BaseTariffDefinitionOtherComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffDefinitionOtherComponentActionOK here] off begin
	// % protected region % [Add any additional class fields for TariffDefinitionOtherComponentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffDefinitionOtherComponentModel>,
		// % protected region % [Add any additional constructor parameters for TariffDefinitionOtherComponentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TariffDefinitionOtherComponentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TariffDefinitionOtherComponentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffDefinitionOtherComponentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TariffDefinitionOtherComponentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffDefinitionOtherComponentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TariffDefinitionOtherComponentActionOK here] end
	}

	// % protected region % [Add any additional class methods for TariffDefinitionOtherComponentActionOK here] off begin
	// % protected region % [Add any additional class methods for TariffDefinitionOtherComponentActionOK here] end
}

export class TariffDefinitionOtherComponentActionFail extends BaseTariffDefinitionOtherComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffDefinitionOtherComponentActionFail here] off begin
	// % protected region % [Add any additional class fields for TariffDefinitionOtherComponentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TariffDefinitionOtherComponentModel>,
		// % protected region % [Add any additional constructor parameters for TariffDefinitionOtherComponentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TariffDefinitionOtherComponentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffDefinitionOtherComponentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TariffDefinitionOtherComponentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffDefinitionOtherComponentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TariffDefinitionOtherComponentActionFail here] end
	}

	// % protected region % [Add any additional class methods for TariffDefinitionOtherComponentActionFail here] off begin
	// % protected region % [Add any additional class methods for TariffDefinitionOtherComponentActionFail here] end
}

export function isTariffDefinitionOtherComponentModelAction(e: any): e is BaseTariffDefinitionOtherComponentAction {
	return Object.values(TariffDefinitionOtherComponentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
