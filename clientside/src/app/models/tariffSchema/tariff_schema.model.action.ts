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
import {TariffSchemaModel} from './tariff_schema.model';
import {TariffSchemaModelAudit} from './tariff_schema.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Tariff Schema model actions to be dispatched by NgRx.
 */
export enum TariffSchemaModelActionTypes {
	CREATE_TARIFF_SCHEMA = '[ENTITY] Create TariffSchemaModel',
	CREATE_TARIFF_SCHEMA_OK = '[ENTITY] Create TariffSchemaModel successfully',
	CREATE_TARIFF_SCHEMA_FAIL = '[ENTITY] Create TariffSchemaModel failed',

	CREATE_ALL_TARIFF_SCHEMA = '[ENTITY] Create All TariffSchemaModel',
	CREATE_ALL_TARIFF_SCHEMA_OK = '[ENTITY] Create All TariffSchemaModel successfully',
	CREATE_ALL_TARIFF_SCHEMA_FAIL = '[ENTITY] Create All TariffSchemaModel failed',

	DELETE_TARIFF_SCHEMA = '[ENTITY] Delete TariffSchemaModel',
	DELETE_TARIFF_SCHEMA_OK = '[ENTITY] Delete TariffSchemaModel successfully',
	DELETE_TARIFF_SCHEMA_FAIL = '[ENTITY] Delete TariffSchemaModel failed',


	DELETE_TARIFF_SCHEMA_EXCLUDING_IDS = '[ENTITY] Delete TariffSchemaModels Excluding Ids',
	DELETE_TARIFF_SCHEMA_EXCLUDING_IDS_OK = '[ENTITY] Delete TariffSchemaModels Excluding Ids successfully',
	DELETE_TARIFF_SCHEMA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TariffSchemaModels Excluding Ids failed',

	DELETE_ALL_TARIFF_SCHEMA = '[ENTITY] Delete all TariffSchemaModels',
	DELETE_ALL_TARIFF_SCHEMA_OK = '[ENTITY] Delete all TariffSchemaModels successfully',
	DELETE_ALL_TARIFF_SCHEMA_FAIL = '[ENTITY] Delete all TariffSchemaModels failed',

	UPDATE_TARIFF_SCHEMA = '[ENTITY] Update TariffSchemaModel',
	UPDATE_TARIFF_SCHEMA_OK = '[ENTITY] Update TariffSchemaModel successfully',
	UPDATE_TARIFF_SCHEMA_FAIL = '[ENTITY] Update TariffSchemaModel failed',

	UPDATE_ALL_TARIFF_SCHEMA = '[ENTITY] Update all TariffSchemaModel',
	UPDATE_ALL_TARIFF_SCHEMA_OK = '[ENTITY] Update all TariffSchemaModel successfully',
	UPDATE_ALL_TARIFF_SCHEMA_FAIL = '[ENTITY] Update all TariffSchemaModel failed',

	FETCH_TARIFF_SCHEMA= '[ENTITY] Fetch TariffSchemaModel',
	FETCH_TARIFF_SCHEMA_OK = '[ENTITY] Fetch TariffSchemaModel successfully',
	FETCH_TARIFF_SCHEMA_FAIL = '[ENTITY] Fetch TariffSchemaModel failed',

	FETCH_TARIFF_SCHEMA_AUDIT= '[ENTITY] Fetch TariffSchemaModel audit',
	FETCH_TARIFF_SCHEMA_AUDIT_OK = '[ENTITY] Fetch TariffSchemaModel audit successfully',
	FETCH_TARIFF_SCHEMA_AUDIT_FAIL = '[ENTITY] Fetch TariffSchemaModel audit failed',

	FETCH_TARIFF_SCHEMA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TariffSchemaModel audits by entity id',
	FETCH_TARIFF_SCHEMA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TariffSchemaModel audits by entity id successfully',
	FETCH_TARIFF_SCHEMA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TariffSchemaModel audits by entity id failed',

	FETCH_ALL_TARIFF_SCHEMA = '[ENTITY] Fetch all TariffSchemaModel',
	FETCH_ALL_TARIFF_SCHEMA_OK = '[ENTITY] Fetch all TariffSchemaModel successfully',
	FETCH_ALL_TARIFF_SCHEMA_FAIL = '[ENTITY] Fetch all TariffSchemaModel failed',

	FETCH_TARIFF_SCHEMA_WITH_QUERY = '[ENTITY] Fetch TariffSchemaModel with query',
	FETCH_TARIFF_SCHEMA_WITH_QUERY_OK = '[ENTITY] Fetch TariffSchemaModel with query successfully',
	FETCH_TARIFF_SCHEMA_WITH_QUERY_FAIL = '[ENTITY] Fetch TariffSchemaModel with query failed',

	FETCH_LAST_TARIFF_SCHEMA_WITH_QUERY = '[ENTITY] Fetch last TariffSchemaModel with query',
	FETCH_LAST_TARIFF_SCHEMA_WITH_QUERY_OK = '[ENTITY] Fetch last TariffSchemaModel with query successfully',
	FETCH_LAST_TARIFF_SCHEMA_WITH_QUERY_FAIL = '[ENTITY] Fetch last TariffSchemaModel with query failed',

	EXPORT_TARIFF_SCHEMA = '[ENTITY] Export TariffSchemaModel',
	EXPORT_TARIFF_SCHEMA_OK = '[ENTITY] Export TariffSchemaModel successfully',
	EXPORT_TARIFF_SCHEMA_FAIL = '[ENTITY] Export TariffSchemaModel failed',

	EXPORT_ALL_TARIFF_SCHEMA = '[ENTITY] Export All TariffSchemaModels',
	EXPORT_ALL_TARIFF_SCHEMA_OK = '[ENTITY] Export All TariffSchemaModels successfully',
	EXPORT_ALL_TARIFF_SCHEMA_FAIL = '[ENTITY] Export All TariffSchemaModels failed',

	EXPORT_TARIFF_SCHEMA_EXCLUDING_IDS = '[ENTITY] Export TariffSchemaModels excluding Ids',
	EXPORT_TARIFF_SCHEMA_EXCLUDING_IDS_OK = '[ENTITY] Export TariffSchemaModel excluding Ids successfully',
	EXPORT_TARIFF_SCHEMA_EXCLUDING_IDS_FAIL = '[ENTITY] Export TariffSchemaModel excluding Ids failed',

	COUNT_TARIFF_SCHEMAS = '[ENTITY] Fetch number of TariffSchemaModel records',
	COUNT_TARIFF_SCHEMAS_OK = '[ENTITY] Fetch number of TariffSchemaModel records successfully ',
	COUNT_TARIFF_SCHEMAS_FAIL = '[ENTITY] Fetch number of TariffSchemaModel records failed',

	IMPORT_TARIFF_SCHEMAS = '[ENTITY] Import TariffSchemaModels',
	IMPORT_TARIFF_SCHEMAS_OK = '[ENTITY] Import TariffSchemaModels successfully',
	IMPORT_TARIFF_SCHEMAS_FAIL = '[ENTITY] Import TariffSchemaModels fail',


	INITIALISE_TARIFF_SCHEMA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TariffSchemaModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTariffSchemaAction implements Action {
	readonly className: string = 'TariffSchemaModel';

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

export class TariffSchemaAction extends BaseTariffSchemaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffSchemaAction here] off begin
	// % protected region % [Add any additional class fields for TariffSchemaAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffSchemaModel>,
		// % protected region % [Add any additional constructor parameters for TariffSchemaAction here] off begin
		// % protected region % [Add any additional constructor parameters for TariffSchemaAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffSchemaAction here] off begin
			// % protected region % [Add any additional constructor arguments for TariffSchemaAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffSchemaAction here] off begin
		// % protected region % [Add any additional constructor logic for TariffSchemaAction here] end
	}

	// % protected region % [Add any additional class methods for TariffSchemaAction here] off begin
	// % protected region % [Add any additional class methods for TariffSchemaAction here] end
}

export class TariffSchemaActionOK extends BaseTariffSchemaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffSchemaActionOK here] off begin
	// % protected region % [Add any additional class fields for TariffSchemaActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffSchemaModel>,
		// % protected region % [Add any additional constructor parameters for TariffSchemaActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TariffSchemaActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TariffSchemaModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffSchemaActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TariffSchemaActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffSchemaActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TariffSchemaActionOK here] end
	}

	// % protected region % [Add any additional class methods for TariffSchemaActionOK here] off begin
	// % protected region % [Add any additional class methods for TariffSchemaActionOK here] end
}

export class TariffSchemaActionFail extends BaseTariffSchemaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffSchemaActionFail here] off begin
	// % protected region % [Add any additional class fields for TariffSchemaActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TariffSchemaModel>,
		// % protected region % [Add any additional constructor parameters for TariffSchemaActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TariffSchemaActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffSchemaActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TariffSchemaActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffSchemaActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TariffSchemaActionFail here] end
	}

	// % protected region % [Add any additional class methods for TariffSchemaActionFail here] off begin
	// % protected region % [Add any additional class methods for TariffSchemaActionFail here] end
}

export function isTariffSchemaModelAction(e: any): e is BaseTariffSchemaAction {
	return Object.values(TariffSchemaModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
