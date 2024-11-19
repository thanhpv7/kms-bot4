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
import {ChartOfAccountMappingModel} from './chart_of_account_mapping.model';
import {ChartOfAccountMappingModelAudit} from './chart_of_account_mapping.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Chart of Account Mapping model actions to be dispatched by NgRx.
 */
export enum ChartOfAccountMappingModelActionTypes {
	CREATE_CHART_OF_ACCOUNT_MAPPING = '[ENTITY] Create ChartOfAccountMappingModel',
	CREATE_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Create ChartOfAccountMappingModel successfully',
	CREATE_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Create ChartOfAccountMappingModel failed',

	CREATE_ALL_CHART_OF_ACCOUNT_MAPPING = '[ENTITY] Create All ChartOfAccountMappingModel',
	CREATE_ALL_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Create All ChartOfAccountMappingModel successfully',
	CREATE_ALL_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Create All ChartOfAccountMappingModel failed',

	DELETE_CHART_OF_ACCOUNT_MAPPING = '[ENTITY] Delete ChartOfAccountMappingModel',
	DELETE_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Delete ChartOfAccountMappingModel successfully',
	DELETE_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Delete ChartOfAccountMappingModel failed',


	DELETE_CHART_OF_ACCOUNT_MAPPING_EXCLUDING_IDS = '[ENTITY] Delete ChartOfAccountMappingModels Excluding Ids',
	DELETE_CHART_OF_ACCOUNT_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Delete ChartOfAccountMappingModels Excluding Ids successfully',
	DELETE_CHART_OF_ACCOUNT_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ChartOfAccountMappingModels Excluding Ids failed',

	DELETE_ALL_CHART_OF_ACCOUNT_MAPPING = '[ENTITY] Delete all ChartOfAccountMappingModels',
	DELETE_ALL_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Delete all ChartOfAccountMappingModels successfully',
	DELETE_ALL_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Delete all ChartOfAccountMappingModels failed',

	UPDATE_CHART_OF_ACCOUNT_MAPPING = '[ENTITY] Update ChartOfAccountMappingModel',
	UPDATE_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Update ChartOfAccountMappingModel successfully',
	UPDATE_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Update ChartOfAccountMappingModel failed',

	UPDATE_ALL_CHART_OF_ACCOUNT_MAPPING = '[ENTITY] Update all ChartOfAccountMappingModel',
	UPDATE_ALL_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Update all ChartOfAccountMappingModel successfully',
	UPDATE_ALL_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Update all ChartOfAccountMappingModel failed',

	FETCH_CHART_OF_ACCOUNT_MAPPING= '[ENTITY] Fetch ChartOfAccountMappingModel',
	FETCH_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Fetch ChartOfAccountMappingModel successfully',
	FETCH_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Fetch ChartOfAccountMappingModel failed',

	FETCH_CHART_OF_ACCOUNT_MAPPING_AUDIT= '[ENTITY] Fetch ChartOfAccountMappingModel audit',
	FETCH_CHART_OF_ACCOUNT_MAPPING_AUDIT_OK = '[ENTITY] Fetch ChartOfAccountMappingModel audit successfully',
	FETCH_CHART_OF_ACCOUNT_MAPPING_AUDIT_FAIL = '[ENTITY] Fetch ChartOfAccountMappingModel audit failed',

	FETCH_CHART_OF_ACCOUNT_MAPPING_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ChartOfAccountMappingModel audits by entity id',
	FETCH_CHART_OF_ACCOUNT_MAPPING_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ChartOfAccountMappingModel audits by entity id successfully',
	FETCH_CHART_OF_ACCOUNT_MAPPING_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ChartOfAccountMappingModel audits by entity id failed',

	FETCH_ALL_CHART_OF_ACCOUNT_MAPPING = '[ENTITY] Fetch all ChartOfAccountMappingModel',
	FETCH_ALL_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Fetch all ChartOfAccountMappingModel successfully',
	FETCH_ALL_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Fetch all ChartOfAccountMappingModel failed',

	FETCH_CHART_OF_ACCOUNT_MAPPING_WITH_QUERY = '[ENTITY] Fetch ChartOfAccountMappingModel with query',
	FETCH_CHART_OF_ACCOUNT_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch ChartOfAccountMappingModel with query successfully',
	FETCH_CHART_OF_ACCOUNT_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch ChartOfAccountMappingModel with query failed',

	FETCH_LAST_CHART_OF_ACCOUNT_MAPPING_WITH_QUERY = '[ENTITY] Fetch last ChartOfAccountMappingModel with query',
	FETCH_LAST_CHART_OF_ACCOUNT_MAPPING_WITH_QUERY_OK = '[ENTITY] Fetch last ChartOfAccountMappingModel with query successfully',
	FETCH_LAST_CHART_OF_ACCOUNT_MAPPING_WITH_QUERY_FAIL = '[ENTITY] Fetch last ChartOfAccountMappingModel with query failed',

	EXPORT_CHART_OF_ACCOUNT_MAPPING = '[ENTITY] Export ChartOfAccountMappingModel',
	EXPORT_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Export ChartOfAccountMappingModel successfully',
	EXPORT_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Export ChartOfAccountMappingModel failed',

	EXPORT_ALL_CHART_OF_ACCOUNT_MAPPING = '[ENTITY] Export All ChartOfAccountMappingModels',
	EXPORT_ALL_CHART_OF_ACCOUNT_MAPPING_OK = '[ENTITY] Export All ChartOfAccountMappingModels successfully',
	EXPORT_ALL_CHART_OF_ACCOUNT_MAPPING_FAIL = '[ENTITY] Export All ChartOfAccountMappingModels failed',

	EXPORT_CHART_OF_ACCOUNT_MAPPING_EXCLUDING_IDS = '[ENTITY] Export ChartOfAccountMappingModels excluding Ids',
	EXPORT_CHART_OF_ACCOUNT_MAPPING_EXCLUDING_IDS_OK = '[ENTITY] Export ChartOfAccountMappingModel excluding Ids successfully',
	EXPORT_CHART_OF_ACCOUNT_MAPPING_EXCLUDING_IDS_FAIL = '[ENTITY] Export ChartOfAccountMappingModel excluding Ids failed',

	COUNT_CHART_OF_ACCOUNT_MAPPINGS = '[ENTITY] Fetch number of ChartOfAccountMappingModel records',
	COUNT_CHART_OF_ACCOUNT_MAPPINGS_OK = '[ENTITY] Fetch number of ChartOfAccountMappingModel records successfully ',
	COUNT_CHART_OF_ACCOUNT_MAPPINGS_FAIL = '[ENTITY] Fetch number of ChartOfAccountMappingModel records failed',

	IMPORT_CHART_OF_ACCOUNT_MAPPINGS = '[ENTITY] Import ChartOfAccountMappingModels',
	IMPORT_CHART_OF_ACCOUNT_MAPPINGS_OK = '[ENTITY] Import ChartOfAccountMappingModels successfully',
	IMPORT_CHART_OF_ACCOUNT_MAPPINGS_FAIL = '[ENTITY] Import ChartOfAccountMappingModels fail',


	INITIALISE_CHART_OF_ACCOUNT_MAPPING_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ChartOfAccountMappingModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseChartOfAccountMappingAction implements Action {
	readonly className: string = 'ChartOfAccountMappingModel';

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

export class ChartOfAccountMappingAction extends BaseChartOfAccountMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ChartOfAccountMappingAction here] off begin
	// % protected region % [Add any additional class fields for ChartOfAccountMappingAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ChartOfAccountMappingModel>,
		// % protected region % [Add any additional constructor parameters for ChartOfAccountMappingAction here] off begin
		// % protected region % [Add any additional constructor parameters for ChartOfAccountMappingAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ChartOfAccountMappingAction here] off begin
			// % protected region % [Add any additional constructor arguments for ChartOfAccountMappingAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ChartOfAccountMappingAction here] off begin
		// % protected region % [Add any additional constructor logic for ChartOfAccountMappingAction here] end
	}

	// % protected region % [Add any additional class methods for ChartOfAccountMappingAction here] off begin
	// % protected region % [Add any additional class methods for ChartOfAccountMappingAction here] end
}

export class ChartOfAccountMappingActionOK extends BaseChartOfAccountMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ChartOfAccountMappingActionOK here] off begin
	// % protected region % [Add any additional class fields for ChartOfAccountMappingActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ChartOfAccountMappingModel>,
		// % protected region % [Add any additional constructor parameters for ChartOfAccountMappingActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ChartOfAccountMappingActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ChartOfAccountMappingModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ChartOfAccountMappingActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ChartOfAccountMappingActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ChartOfAccountMappingActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ChartOfAccountMappingActionOK here] end
	}

	// % protected region % [Add any additional class methods for ChartOfAccountMappingActionOK here] off begin
	// % protected region % [Add any additional class methods for ChartOfAccountMappingActionOK here] end
}

export class ChartOfAccountMappingActionFail extends BaseChartOfAccountMappingAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ChartOfAccountMappingActionFail here] off begin
	// % protected region % [Add any additional class fields for ChartOfAccountMappingActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ChartOfAccountMappingModel>,
		// % protected region % [Add any additional constructor parameters for ChartOfAccountMappingActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ChartOfAccountMappingActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ChartOfAccountMappingActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ChartOfAccountMappingActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ChartOfAccountMappingActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ChartOfAccountMappingActionFail here] end
	}

	// % protected region % [Add any additional class methods for ChartOfAccountMappingActionFail here] off begin
	// % protected region % [Add any additional class methods for ChartOfAccountMappingActionFail here] end
}

export function isChartOfAccountMappingModelAction(e: any): e is BaseChartOfAccountMappingAction {
	return Object.values(ChartOfAccountMappingModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
