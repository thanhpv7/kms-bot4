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
import {BpjsHealthFacilityModel} from './bpjs_health_facility.model';
import {BpjsHealthFacilityModelAudit} from './bpjs_health_facility.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Health Facility model actions to be dispatched by NgRx.
 */
export enum BpjsHealthFacilityModelActionTypes {
	CREATE_BPJS_HEALTH_FACILITY = '[ENTITY] Create BpjsHealthFacilityModel',
	CREATE_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Create BpjsHealthFacilityModel successfully',
	CREATE_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Create BpjsHealthFacilityModel failed',

	CREATE_ALL_BPJS_HEALTH_FACILITY = '[ENTITY] Create All BpjsHealthFacilityModel',
	CREATE_ALL_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Create All BpjsHealthFacilityModel successfully',
	CREATE_ALL_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Create All BpjsHealthFacilityModel failed',

	DELETE_BPJS_HEALTH_FACILITY = '[ENTITY] Delete BpjsHealthFacilityModel',
	DELETE_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Delete BpjsHealthFacilityModel successfully',
	DELETE_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Delete BpjsHealthFacilityModel failed',


	DELETE_BPJS_HEALTH_FACILITY_EXCLUDING_IDS = '[ENTITY] Delete BpjsHealthFacilityModels Excluding Ids',
	DELETE_BPJS_HEALTH_FACILITY_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsHealthFacilityModels Excluding Ids successfully',
	DELETE_BPJS_HEALTH_FACILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsHealthFacilityModels Excluding Ids failed',

	DELETE_ALL_BPJS_HEALTH_FACILITY = '[ENTITY] Delete all BpjsHealthFacilityModels',
	DELETE_ALL_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Delete all BpjsHealthFacilityModels successfully',
	DELETE_ALL_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Delete all BpjsHealthFacilityModels failed',

	UPDATE_BPJS_HEALTH_FACILITY = '[ENTITY] Update BpjsHealthFacilityModel',
	UPDATE_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Update BpjsHealthFacilityModel successfully',
	UPDATE_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Update BpjsHealthFacilityModel failed',

	UPDATE_ALL_BPJS_HEALTH_FACILITY = '[ENTITY] Update all BpjsHealthFacilityModel',
	UPDATE_ALL_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Update all BpjsHealthFacilityModel successfully',
	UPDATE_ALL_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Update all BpjsHealthFacilityModel failed',

	FETCH_BPJS_HEALTH_FACILITY= '[ENTITY] Fetch BpjsHealthFacilityModel',
	FETCH_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Fetch BpjsHealthFacilityModel successfully',
	FETCH_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Fetch BpjsHealthFacilityModel failed',

	FETCH_BPJS_HEALTH_FACILITY_AUDIT= '[ENTITY] Fetch BpjsHealthFacilityModel audit',
	FETCH_BPJS_HEALTH_FACILITY_AUDIT_OK = '[ENTITY] Fetch BpjsHealthFacilityModel audit successfully',
	FETCH_BPJS_HEALTH_FACILITY_AUDIT_FAIL = '[ENTITY] Fetch BpjsHealthFacilityModel audit failed',

	FETCH_BPJS_HEALTH_FACILITY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsHealthFacilityModel audits by entity id',
	FETCH_BPJS_HEALTH_FACILITY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsHealthFacilityModel audits by entity id successfully',
	FETCH_BPJS_HEALTH_FACILITY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsHealthFacilityModel audits by entity id failed',

	FETCH_ALL_BPJS_HEALTH_FACILITY = '[ENTITY] Fetch all BpjsHealthFacilityModel',
	FETCH_ALL_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Fetch all BpjsHealthFacilityModel successfully',
	FETCH_ALL_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Fetch all BpjsHealthFacilityModel failed',

	FETCH_BPJS_HEALTH_FACILITY_WITH_QUERY = '[ENTITY] Fetch BpjsHealthFacilityModel with query',
	FETCH_BPJS_HEALTH_FACILITY_WITH_QUERY_OK = '[ENTITY] Fetch BpjsHealthFacilityModel with query successfully',
	FETCH_BPJS_HEALTH_FACILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsHealthFacilityModel with query failed',

	FETCH_LAST_BPJS_HEALTH_FACILITY_WITH_QUERY = '[ENTITY] Fetch last BpjsHealthFacilityModel with query',
	FETCH_LAST_BPJS_HEALTH_FACILITY_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsHealthFacilityModel with query successfully',
	FETCH_LAST_BPJS_HEALTH_FACILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsHealthFacilityModel with query failed',

	EXPORT_BPJS_HEALTH_FACILITY = '[ENTITY] Export BpjsHealthFacilityModel',
	EXPORT_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Export BpjsHealthFacilityModel successfully',
	EXPORT_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Export BpjsHealthFacilityModel failed',

	EXPORT_ALL_BPJS_HEALTH_FACILITY = '[ENTITY] Export All BpjsHealthFacilityModels',
	EXPORT_ALL_BPJS_HEALTH_FACILITY_OK = '[ENTITY] Export All BpjsHealthFacilityModels successfully',
	EXPORT_ALL_BPJS_HEALTH_FACILITY_FAIL = '[ENTITY] Export All BpjsHealthFacilityModels failed',

	EXPORT_BPJS_HEALTH_FACILITY_EXCLUDING_IDS = '[ENTITY] Export BpjsHealthFacilityModels excluding Ids',
	EXPORT_BPJS_HEALTH_FACILITY_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsHealthFacilityModel excluding Ids successfully',
	EXPORT_BPJS_HEALTH_FACILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsHealthFacilityModel excluding Ids failed',

	COUNT_BPJS_HEALTH_FACILITYS = '[ENTITY] Fetch number of BpjsHealthFacilityModel records',
	COUNT_BPJS_HEALTH_FACILITYS_OK = '[ENTITY] Fetch number of BpjsHealthFacilityModel records successfully ',
	COUNT_BPJS_HEALTH_FACILITYS_FAIL = '[ENTITY] Fetch number of BpjsHealthFacilityModel records failed',

	IMPORT_BPJS_HEALTH_FACILITYS = '[ENTITY] Import BpjsHealthFacilityModels',
	IMPORT_BPJS_HEALTH_FACILITYS_OK = '[ENTITY] Import BpjsHealthFacilityModels successfully',
	IMPORT_BPJS_HEALTH_FACILITYS_FAIL = '[ENTITY] Import BpjsHealthFacilityModels fail',


	INITIALISE_BPJS_HEALTH_FACILITY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsHealthFacilityModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsHealthFacilityAction implements Action {
	readonly className: string = 'BpjsHealthFacilityModel';

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

export class BpjsHealthFacilityAction extends BaseBpjsHealthFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsHealthFacilityAction here] off begin
	// % protected region % [Add any additional class fields for BpjsHealthFacilityAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsHealthFacilityModel>,
		// % protected region % [Add any additional constructor parameters for BpjsHealthFacilityAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsHealthFacilityAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsHealthFacilityAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsHealthFacilityAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsHealthFacilityAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsHealthFacilityAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsHealthFacilityAction here] off begin
	// % protected region % [Add any additional class methods for BpjsHealthFacilityAction here] end
}

export class BpjsHealthFacilityActionOK extends BaseBpjsHealthFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsHealthFacilityActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsHealthFacilityActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsHealthFacilityModel>,
		// % protected region % [Add any additional constructor parameters for BpjsHealthFacilityActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsHealthFacilityActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsHealthFacilityModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsHealthFacilityActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsHealthFacilityActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsHealthFacilityActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsHealthFacilityActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsHealthFacilityActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsHealthFacilityActionOK here] end
}

export class BpjsHealthFacilityActionFail extends BaseBpjsHealthFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsHealthFacilityActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsHealthFacilityActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsHealthFacilityModel>,
		// % protected region % [Add any additional constructor parameters for BpjsHealthFacilityActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsHealthFacilityActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsHealthFacilityActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsHealthFacilityActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsHealthFacilityActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsHealthFacilityActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsHealthFacilityActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsHealthFacilityActionFail here] end
}

export function isBpjsHealthFacilityModelAction(e: any): e is BaseBpjsHealthFacilityAction {
	return Object.values(BpjsHealthFacilityModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
