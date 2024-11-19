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
import {PriceComponentModel} from './price_component.model';
import {PriceComponentModelAudit} from './price_component.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Price Component model actions to be dispatched by NgRx.
 */
export enum PriceComponentModelActionTypes {
	CREATE_PRICE_COMPONENT = '[ENTITY] Create PriceComponentModel',
	CREATE_PRICE_COMPONENT_OK = '[ENTITY] Create PriceComponentModel successfully',
	CREATE_PRICE_COMPONENT_FAIL = '[ENTITY] Create PriceComponentModel failed',

	CREATE_ALL_PRICE_COMPONENT = '[ENTITY] Create All PriceComponentModel',
	CREATE_ALL_PRICE_COMPONENT_OK = '[ENTITY] Create All PriceComponentModel successfully',
	CREATE_ALL_PRICE_COMPONENT_FAIL = '[ENTITY] Create All PriceComponentModel failed',

	DELETE_PRICE_COMPONENT = '[ENTITY] Delete PriceComponentModel',
	DELETE_PRICE_COMPONENT_OK = '[ENTITY] Delete PriceComponentModel successfully',
	DELETE_PRICE_COMPONENT_FAIL = '[ENTITY] Delete PriceComponentModel failed',


	DELETE_PRICE_COMPONENT_EXCLUDING_IDS = '[ENTITY] Delete PriceComponentModels Excluding Ids',
	DELETE_PRICE_COMPONENT_EXCLUDING_IDS_OK = '[ENTITY] Delete PriceComponentModels Excluding Ids successfully',
	DELETE_PRICE_COMPONENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PriceComponentModels Excluding Ids failed',

	DELETE_ALL_PRICE_COMPONENT = '[ENTITY] Delete all PriceComponentModels',
	DELETE_ALL_PRICE_COMPONENT_OK = '[ENTITY] Delete all PriceComponentModels successfully',
	DELETE_ALL_PRICE_COMPONENT_FAIL = '[ENTITY] Delete all PriceComponentModels failed',

	UPDATE_PRICE_COMPONENT = '[ENTITY] Update PriceComponentModel',
	UPDATE_PRICE_COMPONENT_OK = '[ENTITY] Update PriceComponentModel successfully',
	UPDATE_PRICE_COMPONENT_FAIL = '[ENTITY] Update PriceComponentModel failed',

	UPDATE_ALL_PRICE_COMPONENT = '[ENTITY] Update all PriceComponentModel',
	UPDATE_ALL_PRICE_COMPONENT_OK = '[ENTITY] Update all PriceComponentModel successfully',
	UPDATE_ALL_PRICE_COMPONENT_FAIL = '[ENTITY] Update all PriceComponentModel failed',

	FETCH_PRICE_COMPONENT= '[ENTITY] Fetch PriceComponentModel',
	FETCH_PRICE_COMPONENT_OK = '[ENTITY] Fetch PriceComponentModel successfully',
	FETCH_PRICE_COMPONENT_FAIL = '[ENTITY] Fetch PriceComponentModel failed',

	FETCH_PRICE_COMPONENT_AUDIT= '[ENTITY] Fetch PriceComponentModel audit',
	FETCH_PRICE_COMPONENT_AUDIT_OK = '[ENTITY] Fetch PriceComponentModel audit successfully',
	FETCH_PRICE_COMPONENT_AUDIT_FAIL = '[ENTITY] Fetch PriceComponentModel audit failed',

	FETCH_PRICE_COMPONENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PriceComponentModel audits by entity id',
	FETCH_PRICE_COMPONENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PriceComponentModel audits by entity id successfully',
	FETCH_PRICE_COMPONENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PriceComponentModel audits by entity id failed',

	FETCH_ALL_PRICE_COMPONENT = '[ENTITY] Fetch all PriceComponentModel',
	FETCH_ALL_PRICE_COMPONENT_OK = '[ENTITY] Fetch all PriceComponentModel successfully',
	FETCH_ALL_PRICE_COMPONENT_FAIL = '[ENTITY] Fetch all PriceComponentModel failed',

	FETCH_PRICE_COMPONENT_WITH_QUERY = '[ENTITY] Fetch PriceComponentModel with query',
	FETCH_PRICE_COMPONENT_WITH_QUERY_OK = '[ENTITY] Fetch PriceComponentModel with query successfully',
	FETCH_PRICE_COMPONENT_WITH_QUERY_FAIL = '[ENTITY] Fetch PriceComponentModel with query failed',

	FETCH_LAST_PRICE_COMPONENT_WITH_QUERY = '[ENTITY] Fetch last PriceComponentModel with query',
	FETCH_LAST_PRICE_COMPONENT_WITH_QUERY_OK = '[ENTITY] Fetch last PriceComponentModel with query successfully',
	FETCH_LAST_PRICE_COMPONENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last PriceComponentModel with query failed',

	EXPORT_PRICE_COMPONENT = '[ENTITY] Export PriceComponentModel',
	EXPORT_PRICE_COMPONENT_OK = '[ENTITY] Export PriceComponentModel successfully',
	EXPORT_PRICE_COMPONENT_FAIL = '[ENTITY] Export PriceComponentModel failed',

	EXPORT_ALL_PRICE_COMPONENT = '[ENTITY] Export All PriceComponentModels',
	EXPORT_ALL_PRICE_COMPONENT_OK = '[ENTITY] Export All PriceComponentModels successfully',
	EXPORT_ALL_PRICE_COMPONENT_FAIL = '[ENTITY] Export All PriceComponentModels failed',

	EXPORT_PRICE_COMPONENT_EXCLUDING_IDS = '[ENTITY] Export PriceComponentModels excluding Ids',
	EXPORT_PRICE_COMPONENT_EXCLUDING_IDS_OK = '[ENTITY] Export PriceComponentModel excluding Ids successfully',
	EXPORT_PRICE_COMPONENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export PriceComponentModel excluding Ids failed',

	COUNT_PRICE_COMPONENTS = '[ENTITY] Fetch number of PriceComponentModel records',
	COUNT_PRICE_COMPONENTS_OK = '[ENTITY] Fetch number of PriceComponentModel records successfully ',
	COUNT_PRICE_COMPONENTS_FAIL = '[ENTITY] Fetch number of PriceComponentModel records failed',

	IMPORT_PRICE_COMPONENTS = '[ENTITY] Import PriceComponentModels',
	IMPORT_PRICE_COMPONENTS_OK = '[ENTITY] Import PriceComponentModels successfully',
	IMPORT_PRICE_COMPONENTS_FAIL = '[ENTITY] Import PriceComponentModels fail',


	INITIALISE_PRICE_COMPONENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PriceComponentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePriceComponentAction implements Action {
	readonly className: string = 'PriceComponentModel';

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

export class PriceComponentAction extends BasePriceComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PriceComponentAction here] off begin
	// % protected region % [Add any additional class fields for PriceComponentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PriceComponentModel>,
		// % protected region % [Add any additional constructor parameters for PriceComponentAction here] off begin
		// % protected region % [Add any additional constructor parameters for PriceComponentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PriceComponentAction here] off begin
			// % protected region % [Add any additional constructor arguments for PriceComponentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PriceComponentAction here] off begin
		// % protected region % [Add any additional constructor logic for PriceComponentAction here] end
	}

	// % protected region % [Add any additional class methods for PriceComponentAction here] off begin
	// % protected region % [Add any additional class methods for PriceComponentAction here] end
}

export class PriceComponentActionOK extends BasePriceComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PriceComponentActionOK here] off begin
	// % protected region % [Add any additional class fields for PriceComponentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PriceComponentModel>,
		// % protected region % [Add any additional constructor parameters for PriceComponentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PriceComponentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PriceComponentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PriceComponentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PriceComponentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PriceComponentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PriceComponentActionOK here] end
	}

	// % protected region % [Add any additional class methods for PriceComponentActionOK here] off begin
	// % protected region % [Add any additional class methods for PriceComponentActionOK here] end
}

export class PriceComponentActionFail extends BasePriceComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PriceComponentActionFail here] off begin
	// % protected region % [Add any additional class fields for PriceComponentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PriceComponentModel>,
		// % protected region % [Add any additional constructor parameters for PriceComponentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PriceComponentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PriceComponentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PriceComponentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PriceComponentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PriceComponentActionFail here] end
	}

	// % protected region % [Add any additional class methods for PriceComponentActionFail here] off begin
	// % protected region % [Add any additional class methods for PriceComponentActionFail here] end
}

export function isPriceComponentModelAction(e: any): e is BasePriceComponentAction {
	return Object.values(PriceComponentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
