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
import {LocationModel} from './location.model';
import {LocationModelAudit} from './location.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Location model actions to be dispatched by NgRx.
 */
export enum LocationModelActionTypes {
	CREATE_LOCATION = '[ENTITY] Create LocationModel',
	CREATE_LOCATION_OK = '[ENTITY] Create LocationModel successfully',
	CREATE_LOCATION_FAIL = '[ENTITY] Create LocationModel failed',

	CREATE_ALL_LOCATION = '[ENTITY] Create All LocationModel',
	CREATE_ALL_LOCATION_OK = '[ENTITY] Create All LocationModel successfully',
	CREATE_ALL_LOCATION_FAIL = '[ENTITY] Create All LocationModel failed',

	DELETE_LOCATION = '[ENTITY] Delete LocationModel',
	DELETE_LOCATION_OK = '[ENTITY] Delete LocationModel successfully',
	DELETE_LOCATION_FAIL = '[ENTITY] Delete LocationModel failed',


	DELETE_LOCATION_EXCLUDING_IDS = '[ENTITY] Delete LocationModels Excluding Ids',
	DELETE_LOCATION_EXCLUDING_IDS_OK = '[ENTITY] Delete LocationModels Excluding Ids successfully',
	DELETE_LOCATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete LocationModels Excluding Ids failed',

	DELETE_ALL_LOCATION = '[ENTITY] Delete all LocationModels',
	DELETE_ALL_LOCATION_OK = '[ENTITY] Delete all LocationModels successfully',
	DELETE_ALL_LOCATION_FAIL = '[ENTITY] Delete all LocationModels failed',

	UPDATE_LOCATION = '[ENTITY] Update LocationModel',
	UPDATE_LOCATION_OK = '[ENTITY] Update LocationModel successfully',
	UPDATE_LOCATION_FAIL = '[ENTITY] Update LocationModel failed',

	UPDATE_ALL_LOCATION = '[ENTITY] Update all LocationModel',
	UPDATE_ALL_LOCATION_OK = '[ENTITY] Update all LocationModel successfully',
	UPDATE_ALL_LOCATION_FAIL = '[ENTITY] Update all LocationModel failed',

	FETCH_LOCATION= '[ENTITY] Fetch LocationModel',
	FETCH_LOCATION_OK = '[ENTITY] Fetch LocationModel successfully',
	FETCH_LOCATION_FAIL = '[ENTITY] Fetch LocationModel failed',

	FETCH_LOCATION_AUDIT= '[ENTITY] Fetch LocationModel audit',
	FETCH_LOCATION_AUDIT_OK = '[ENTITY] Fetch LocationModel audit successfully',
	FETCH_LOCATION_AUDIT_FAIL = '[ENTITY] Fetch LocationModel audit failed',

	FETCH_LOCATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch LocationModel audits by entity id',
	FETCH_LOCATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch LocationModel audits by entity id successfully',
	FETCH_LOCATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch LocationModel audits by entity id failed',

	FETCH_ALL_LOCATION = '[ENTITY] Fetch all LocationModel',
	FETCH_ALL_LOCATION_OK = '[ENTITY] Fetch all LocationModel successfully',
	FETCH_ALL_LOCATION_FAIL = '[ENTITY] Fetch all LocationModel failed',

	FETCH_LOCATION_WITH_QUERY = '[ENTITY] Fetch LocationModel with query',
	FETCH_LOCATION_WITH_QUERY_OK = '[ENTITY] Fetch LocationModel with query successfully',
	FETCH_LOCATION_WITH_QUERY_FAIL = '[ENTITY] Fetch LocationModel with query failed',

	FETCH_LAST_LOCATION_WITH_QUERY = '[ENTITY] Fetch last LocationModel with query',
	FETCH_LAST_LOCATION_WITH_QUERY_OK = '[ENTITY] Fetch last LocationModel with query successfully',
	FETCH_LAST_LOCATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last LocationModel with query failed',

	EXPORT_LOCATION = '[ENTITY] Export LocationModel',
	EXPORT_LOCATION_OK = '[ENTITY] Export LocationModel successfully',
	EXPORT_LOCATION_FAIL = '[ENTITY] Export LocationModel failed',

	EXPORT_ALL_LOCATION = '[ENTITY] Export All LocationModels',
	EXPORT_ALL_LOCATION_OK = '[ENTITY] Export All LocationModels successfully',
	EXPORT_ALL_LOCATION_FAIL = '[ENTITY] Export All LocationModels failed',

	EXPORT_LOCATION_EXCLUDING_IDS = '[ENTITY] Export LocationModels excluding Ids',
	EXPORT_LOCATION_EXCLUDING_IDS_OK = '[ENTITY] Export LocationModel excluding Ids successfully',
	EXPORT_LOCATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export LocationModel excluding Ids failed',

	COUNT_LOCATIONS = '[ENTITY] Fetch number of LocationModel records',
	COUNT_LOCATIONS_OK = '[ENTITY] Fetch number of LocationModel records successfully ',
	COUNT_LOCATIONS_FAIL = '[ENTITY] Fetch number of LocationModel records failed',

	IMPORT_LOCATIONS = '[ENTITY] Import LocationModels',
	IMPORT_LOCATIONS_OK = '[ENTITY] Import LocationModels successfully',
	IMPORT_LOCATIONS_FAIL = '[ENTITY] Import LocationModels fail',


	INITIALISE_LOCATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of LocationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseLocationAction implements Action {
	readonly className: string = 'LocationModel';

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

export class LocationAction extends BaseLocationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for LocationAction here] off begin
	// % protected region % [Add any additional class fields for LocationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<LocationModel>,
		// % protected region % [Add any additional constructor parameters for LocationAction here] off begin
		// % protected region % [Add any additional constructor parameters for LocationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for LocationAction here] off begin
			// % protected region % [Add any additional constructor arguments for LocationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for LocationAction here] off begin
		// % protected region % [Add any additional constructor logic for LocationAction here] end
	}

	// % protected region % [Add any additional class methods for LocationAction here] off begin
	// % protected region % [Add any additional class methods for LocationAction here] end
}

export class LocationActionOK extends BaseLocationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for LocationActionOK here] off begin
	// % protected region % [Add any additional class fields for LocationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<LocationModel>,
		// % protected region % [Add any additional constructor parameters for LocationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for LocationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: LocationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for LocationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for LocationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for LocationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for LocationActionOK here] end
	}

	// % protected region % [Add any additional class methods for LocationActionOK here] off begin
	// % protected region % [Add any additional class methods for LocationActionOK here] end
}

export class LocationActionFail extends BaseLocationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for LocationActionFail here] off begin
	// % protected region % [Add any additional class fields for LocationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<LocationModel>,
		// % protected region % [Add any additional constructor parameters for LocationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for LocationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for LocationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for LocationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for LocationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for LocationActionFail here] end
	}

	// % protected region % [Add any additional class methods for LocationActionFail here] off begin
	// % protected region % [Add any additional class methods for LocationActionFail here] end
}

export function isLocationModelAction(e: any): e is BaseLocationAction {
	return Object.values(LocationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
