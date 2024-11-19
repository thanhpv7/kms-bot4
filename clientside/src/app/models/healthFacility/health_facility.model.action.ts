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
import {HealthFacilityModel} from './health_facility.model';
import {HealthFacilityModelAudit} from './health_facility.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Health Facility model actions to be dispatched by NgRx.
 */
export enum HealthFacilityModelActionTypes {
	CREATE_HEALTH_FACILITY = '[ENTITY] Create HealthFacilityModel',
	CREATE_HEALTH_FACILITY_OK = '[ENTITY] Create HealthFacilityModel successfully',
	CREATE_HEALTH_FACILITY_FAIL = '[ENTITY] Create HealthFacilityModel failed',

	CREATE_ALL_HEALTH_FACILITY = '[ENTITY] Create All HealthFacilityModel',
	CREATE_ALL_HEALTH_FACILITY_OK = '[ENTITY] Create All HealthFacilityModel successfully',
	CREATE_ALL_HEALTH_FACILITY_FAIL = '[ENTITY] Create All HealthFacilityModel failed',

	DELETE_HEALTH_FACILITY = '[ENTITY] Delete HealthFacilityModel',
	DELETE_HEALTH_FACILITY_OK = '[ENTITY] Delete HealthFacilityModel successfully',
	DELETE_HEALTH_FACILITY_FAIL = '[ENTITY] Delete HealthFacilityModel failed',


	DELETE_HEALTH_FACILITY_EXCLUDING_IDS = '[ENTITY] Delete HealthFacilityModels Excluding Ids',
	DELETE_HEALTH_FACILITY_EXCLUDING_IDS_OK = '[ENTITY] Delete HealthFacilityModels Excluding Ids successfully',
	DELETE_HEALTH_FACILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete HealthFacilityModels Excluding Ids failed',

	DELETE_ALL_HEALTH_FACILITY = '[ENTITY] Delete all HealthFacilityModels',
	DELETE_ALL_HEALTH_FACILITY_OK = '[ENTITY] Delete all HealthFacilityModels successfully',
	DELETE_ALL_HEALTH_FACILITY_FAIL = '[ENTITY] Delete all HealthFacilityModels failed',

	UPDATE_HEALTH_FACILITY = '[ENTITY] Update HealthFacilityModel',
	UPDATE_HEALTH_FACILITY_OK = '[ENTITY] Update HealthFacilityModel successfully',
	UPDATE_HEALTH_FACILITY_FAIL = '[ENTITY] Update HealthFacilityModel failed',

	UPDATE_ALL_HEALTH_FACILITY = '[ENTITY] Update all HealthFacilityModel',
	UPDATE_ALL_HEALTH_FACILITY_OK = '[ENTITY] Update all HealthFacilityModel successfully',
	UPDATE_ALL_HEALTH_FACILITY_FAIL = '[ENTITY] Update all HealthFacilityModel failed',

	FETCH_HEALTH_FACILITY= '[ENTITY] Fetch HealthFacilityModel',
	FETCH_HEALTH_FACILITY_OK = '[ENTITY] Fetch HealthFacilityModel successfully',
	FETCH_HEALTH_FACILITY_FAIL = '[ENTITY] Fetch HealthFacilityModel failed',

	FETCH_HEALTH_FACILITY_AUDIT= '[ENTITY] Fetch HealthFacilityModel audit',
	FETCH_HEALTH_FACILITY_AUDIT_OK = '[ENTITY] Fetch HealthFacilityModel audit successfully',
	FETCH_HEALTH_FACILITY_AUDIT_FAIL = '[ENTITY] Fetch HealthFacilityModel audit failed',

	FETCH_HEALTH_FACILITY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch HealthFacilityModel audits by entity id',
	FETCH_HEALTH_FACILITY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch HealthFacilityModel audits by entity id successfully',
	FETCH_HEALTH_FACILITY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch HealthFacilityModel audits by entity id failed',

	FETCH_ALL_HEALTH_FACILITY = '[ENTITY] Fetch all HealthFacilityModel',
	FETCH_ALL_HEALTH_FACILITY_OK = '[ENTITY] Fetch all HealthFacilityModel successfully',
	FETCH_ALL_HEALTH_FACILITY_FAIL = '[ENTITY] Fetch all HealthFacilityModel failed',

	FETCH_HEALTH_FACILITY_WITH_QUERY = '[ENTITY] Fetch HealthFacilityModel with query',
	FETCH_HEALTH_FACILITY_WITH_QUERY_OK = '[ENTITY] Fetch HealthFacilityModel with query successfully',
	FETCH_HEALTH_FACILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch HealthFacilityModel with query failed',

	FETCH_LAST_HEALTH_FACILITY_WITH_QUERY = '[ENTITY] Fetch last HealthFacilityModel with query',
	FETCH_LAST_HEALTH_FACILITY_WITH_QUERY_OK = '[ENTITY] Fetch last HealthFacilityModel with query successfully',
	FETCH_LAST_HEALTH_FACILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch last HealthFacilityModel with query failed',

	EXPORT_HEALTH_FACILITY = '[ENTITY] Export HealthFacilityModel',
	EXPORT_HEALTH_FACILITY_OK = '[ENTITY] Export HealthFacilityModel successfully',
	EXPORT_HEALTH_FACILITY_FAIL = '[ENTITY] Export HealthFacilityModel failed',

	EXPORT_ALL_HEALTH_FACILITY = '[ENTITY] Export All HealthFacilityModels',
	EXPORT_ALL_HEALTH_FACILITY_OK = '[ENTITY] Export All HealthFacilityModels successfully',
	EXPORT_ALL_HEALTH_FACILITY_FAIL = '[ENTITY] Export All HealthFacilityModels failed',

	EXPORT_HEALTH_FACILITY_EXCLUDING_IDS = '[ENTITY] Export HealthFacilityModels excluding Ids',
	EXPORT_HEALTH_FACILITY_EXCLUDING_IDS_OK = '[ENTITY] Export HealthFacilityModel excluding Ids successfully',
	EXPORT_HEALTH_FACILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Export HealthFacilityModel excluding Ids failed',

	COUNT_HEALTH_FACILITYS = '[ENTITY] Fetch number of HealthFacilityModel records',
	COUNT_HEALTH_FACILITYS_OK = '[ENTITY] Fetch number of HealthFacilityModel records successfully ',
	COUNT_HEALTH_FACILITYS_FAIL = '[ENTITY] Fetch number of HealthFacilityModel records failed',

	IMPORT_HEALTH_FACILITYS = '[ENTITY] Import HealthFacilityModels',
	IMPORT_HEALTH_FACILITYS_OK = '[ENTITY] Import HealthFacilityModels successfully',
	IMPORT_HEALTH_FACILITYS_FAIL = '[ENTITY] Import HealthFacilityModels fail',


	INITIALISE_HEALTH_FACILITY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of HealthFacilityModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseHealthFacilityAction implements Action {
	readonly className: string = 'HealthFacilityModel';

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

export class HealthFacilityAction extends BaseHealthFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HealthFacilityAction here] off begin
	// % protected region % [Add any additional class fields for HealthFacilityAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HealthFacilityModel>,
		// % protected region % [Add any additional constructor parameters for HealthFacilityAction here] off begin
		// % protected region % [Add any additional constructor parameters for HealthFacilityAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HealthFacilityAction here] off begin
			// % protected region % [Add any additional constructor arguments for HealthFacilityAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HealthFacilityAction here] off begin
		// % protected region % [Add any additional constructor logic for HealthFacilityAction here] end
	}

	// % protected region % [Add any additional class methods for HealthFacilityAction here] off begin
	// % protected region % [Add any additional class methods for HealthFacilityAction here] end
}

export class HealthFacilityActionOK extends BaseHealthFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HealthFacilityActionOK here] off begin
	// % protected region % [Add any additional class fields for HealthFacilityActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HealthFacilityModel>,
		// % protected region % [Add any additional constructor parameters for HealthFacilityActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for HealthFacilityActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: HealthFacilityModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HealthFacilityActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for HealthFacilityActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HealthFacilityActionOK here] off begin
		// % protected region % [Add any additional constructor logic for HealthFacilityActionOK here] end
	}

	// % protected region % [Add any additional class methods for HealthFacilityActionOK here] off begin
	// % protected region % [Add any additional class methods for HealthFacilityActionOK here] end
}

export class HealthFacilityActionFail extends BaseHealthFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HealthFacilityActionFail here] off begin
	// % protected region % [Add any additional class fields for HealthFacilityActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<HealthFacilityModel>,
		// % protected region % [Add any additional constructor parameters for HealthFacilityActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for HealthFacilityActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HealthFacilityActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for HealthFacilityActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HealthFacilityActionFail here] off begin
		// % protected region % [Add any additional constructor logic for HealthFacilityActionFail here] end
	}

	// % protected region % [Add any additional class methods for HealthFacilityActionFail here] off begin
	// % protected region % [Add any additional class methods for HealthFacilityActionFail here] end
}

export function isHealthFacilityModelAction(e: any): e is BaseHealthFacilityAction {
	return Object.values(HealthFacilityModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
