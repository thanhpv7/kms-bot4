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
import {ChartOfAccountModel} from './chart_of_account.model';
import {ChartOfAccountModelAudit} from './chart_of_account.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Chart of Account model actions to be dispatched by NgRx.
 */
export enum ChartOfAccountModelActionTypes {
	CREATE_CHART_OF_ACCOUNT = '[ENTITY] Create ChartOfAccountModel',
	CREATE_CHART_OF_ACCOUNT_OK = '[ENTITY] Create ChartOfAccountModel successfully',
	CREATE_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Create ChartOfAccountModel failed',

	CREATE_ALL_CHART_OF_ACCOUNT = '[ENTITY] Create All ChartOfAccountModel',
	CREATE_ALL_CHART_OF_ACCOUNT_OK = '[ENTITY] Create All ChartOfAccountModel successfully',
	CREATE_ALL_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Create All ChartOfAccountModel failed',

	DELETE_CHART_OF_ACCOUNT = '[ENTITY] Delete ChartOfAccountModel',
	DELETE_CHART_OF_ACCOUNT_OK = '[ENTITY] Delete ChartOfAccountModel successfully',
	DELETE_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Delete ChartOfAccountModel failed',


	DELETE_CHART_OF_ACCOUNT_EXCLUDING_IDS = '[ENTITY] Delete ChartOfAccountModels Excluding Ids',
	DELETE_CHART_OF_ACCOUNT_EXCLUDING_IDS_OK = '[ENTITY] Delete ChartOfAccountModels Excluding Ids successfully',
	DELETE_CHART_OF_ACCOUNT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete ChartOfAccountModels Excluding Ids failed',

	DELETE_ALL_CHART_OF_ACCOUNT = '[ENTITY] Delete all ChartOfAccountModels',
	DELETE_ALL_CHART_OF_ACCOUNT_OK = '[ENTITY] Delete all ChartOfAccountModels successfully',
	DELETE_ALL_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Delete all ChartOfAccountModels failed',

	UPDATE_CHART_OF_ACCOUNT = '[ENTITY] Update ChartOfAccountModel',
	UPDATE_CHART_OF_ACCOUNT_OK = '[ENTITY] Update ChartOfAccountModel successfully',
	UPDATE_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Update ChartOfAccountModel failed',

	UPDATE_ALL_CHART_OF_ACCOUNT = '[ENTITY] Update all ChartOfAccountModel',
	UPDATE_ALL_CHART_OF_ACCOUNT_OK = '[ENTITY] Update all ChartOfAccountModel successfully',
	UPDATE_ALL_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Update all ChartOfAccountModel failed',

	FETCH_CHART_OF_ACCOUNT= '[ENTITY] Fetch ChartOfAccountModel',
	FETCH_CHART_OF_ACCOUNT_OK = '[ENTITY] Fetch ChartOfAccountModel successfully',
	FETCH_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Fetch ChartOfAccountModel failed',

	FETCH_CHART_OF_ACCOUNT_AUDIT= '[ENTITY] Fetch ChartOfAccountModel audit',
	FETCH_CHART_OF_ACCOUNT_AUDIT_OK = '[ENTITY] Fetch ChartOfAccountModel audit successfully',
	FETCH_CHART_OF_ACCOUNT_AUDIT_FAIL = '[ENTITY] Fetch ChartOfAccountModel audit failed',

	FETCH_CHART_OF_ACCOUNT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch ChartOfAccountModel audits by entity id',
	FETCH_CHART_OF_ACCOUNT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch ChartOfAccountModel audits by entity id successfully',
	FETCH_CHART_OF_ACCOUNT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch ChartOfAccountModel audits by entity id failed',

	FETCH_ALL_CHART_OF_ACCOUNT = '[ENTITY] Fetch all ChartOfAccountModel',
	FETCH_ALL_CHART_OF_ACCOUNT_OK = '[ENTITY] Fetch all ChartOfAccountModel successfully',
	FETCH_ALL_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Fetch all ChartOfAccountModel failed',

	FETCH_CHART_OF_ACCOUNT_WITH_QUERY = '[ENTITY] Fetch ChartOfAccountModel with query',
	FETCH_CHART_OF_ACCOUNT_WITH_QUERY_OK = '[ENTITY] Fetch ChartOfAccountModel with query successfully',
	FETCH_CHART_OF_ACCOUNT_WITH_QUERY_FAIL = '[ENTITY] Fetch ChartOfAccountModel with query failed',

	FETCH_LAST_CHART_OF_ACCOUNT_WITH_QUERY = '[ENTITY] Fetch last ChartOfAccountModel with query',
	FETCH_LAST_CHART_OF_ACCOUNT_WITH_QUERY_OK = '[ENTITY] Fetch last ChartOfAccountModel with query successfully',
	FETCH_LAST_CHART_OF_ACCOUNT_WITH_QUERY_FAIL = '[ENTITY] Fetch last ChartOfAccountModel with query failed',

	EXPORT_CHART_OF_ACCOUNT = '[ENTITY] Export ChartOfAccountModel',
	EXPORT_CHART_OF_ACCOUNT_OK = '[ENTITY] Export ChartOfAccountModel successfully',
	EXPORT_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Export ChartOfAccountModel failed',

	EXPORT_ALL_CHART_OF_ACCOUNT = '[ENTITY] Export All ChartOfAccountModels',
	EXPORT_ALL_CHART_OF_ACCOUNT_OK = '[ENTITY] Export All ChartOfAccountModels successfully',
	EXPORT_ALL_CHART_OF_ACCOUNT_FAIL = '[ENTITY] Export All ChartOfAccountModels failed',

	EXPORT_CHART_OF_ACCOUNT_EXCLUDING_IDS = '[ENTITY] Export ChartOfAccountModels excluding Ids',
	EXPORT_CHART_OF_ACCOUNT_EXCLUDING_IDS_OK = '[ENTITY] Export ChartOfAccountModel excluding Ids successfully',
	EXPORT_CHART_OF_ACCOUNT_EXCLUDING_IDS_FAIL = '[ENTITY] Export ChartOfAccountModel excluding Ids failed',

	COUNT_CHART_OF_ACCOUNTS = '[ENTITY] Fetch number of ChartOfAccountModel records',
	COUNT_CHART_OF_ACCOUNTS_OK = '[ENTITY] Fetch number of ChartOfAccountModel records successfully ',
	COUNT_CHART_OF_ACCOUNTS_FAIL = '[ENTITY] Fetch number of ChartOfAccountModel records failed',

	IMPORT_CHART_OF_ACCOUNTS = '[ENTITY] Import ChartOfAccountModels',
	IMPORT_CHART_OF_ACCOUNTS_OK = '[ENTITY] Import ChartOfAccountModels successfully',
	IMPORT_CHART_OF_ACCOUNTS_FAIL = '[ENTITY] Import ChartOfAccountModels fail',


	INITIALISE_CHART_OF_ACCOUNT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of ChartOfAccountModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseChartOfAccountAction implements Action {
	readonly className: string = 'ChartOfAccountModel';

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

export class ChartOfAccountAction extends BaseChartOfAccountAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ChartOfAccountAction here] off begin
	// % protected region % [Add any additional class fields for ChartOfAccountAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ChartOfAccountModel>,
		// % protected region % [Add any additional constructor parameters for ChartOfAccountAction here] off begin
		// % protected region % [Add any additional constructor parameters for ChartOfAccountAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ChartOfAccountAction here] off begin
			// % protected region % [Add any additional constructor arguments for ChartOfAccountAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ChartOfAccountAction here] off begin
		// % protected region % [Add any additional constructor logic for ChartOfAccountAction here] end
	}

	// % protected region % [Add any additional class methods for ChartOfAccountAction here] off begin
	// % protected region % [Add any additional class methods for ChartOfAccountAction here] end
}

export class ChartOfAccountActionOK extends BaseChartOfAccountAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ChartOfAccountActionOK here] off begin
	// % protected region % [Add any additional class fields for ChartOfAccountActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<ChartOfAccountModel>,
		// % protected region % [Add any additional constructor parameters for ChartOfAccountActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for ChartOfAccountActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: ChartOfAccountModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ChartOfAccountActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for ChartOfAccountActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ChartOfAccountActionOK here] off begin
		// % protected region % [Add any additional constructor logic for ChartOfAccountActionOK here] end
	}

	// % protected region % [Add any additional class methods for ChartOfAccountActionOK here] off begin
	// % protected region % [Add any additional class methods for ChartOfAccountActionOK here] end
}

export class ChartOfAccountActionFail extends BaseChartOfAccountAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for ChartOfAccountActionFail here] off begin
	// % protected region % [Add any additional class fields for ChartOfAccountActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<ChartOfAccountModel>,
		// % protected region % [Add any additional constructor parameters for ChartOfAccountActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for ChartOfAccountActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for ChartOfAccountActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for ChartOfAccountActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for ChartOfAccountActionFail here] off begin
		// % protected region % [Add any additional constructor logic for ChartOfAccountActionFail here] end
	}

	// % protected region % [Add any additional class methods for ChartOfAccountActionFail here] off begin
	// % protected region % [Add any additional class methods for ChartOfAccountActionFail here] end
}

export function isChartOfAccountModelAction(e: any): e is BaseChartOfAccountAction {
	return Object.values(ChartOfAccountModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
