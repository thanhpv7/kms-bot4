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
import {BedFacilityModel} from './bed_facility.model';
import {BedFacilityModelAudit} from './bed_facility.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Bed Facility model actions to be dispatched by NgRx.
 */
export enum BedFacilityModelActionTypes {
	CREATE_BED_FACILITY = '[ENTITY] Create BedFacilityModel',
	CREATE_BED_FACILITY_OK = '[ENTITY] Create BedFacilityModel successfully',
	CREATE_BED_FACILITY_FAIL = '[ENTITY] Create BedFacilityModel failed',

	CREATE_ALL_BED_FACILITY = '[ENTITY] Create All BedFacilityModel',
	CREATE_ALL_BED_FACILITY_OK = '[ENTITY] Create All BedFacilityModel successfully',
	CREATE_ALL_BED_FACILITY_FAIL = '[ENTITY] Create All BedFacilityModel failed',

	DELETE_BED_FACILITY = '[ENTITY] Delete BedFacilityModel',
	DELETE_BED_FACILITY_OK = '[ENTITY] Delete BedFacilityModel successfully',
	DELETE_BED_FACILITY_FAIL = '[ENTITY] Delete BedFacilityModel failed',


	DELETE_BED_FACILITY_EXCLUDING_IDS = '[ENTITY] Delete BedFacilityModels Excluding Ids',
	DELETE_BED_FACILITY_EXCLUDING_IDS_OK = '[ENTITY] Delete BedFacilityModels Excluding Ids successfully',
	DELETE_BED_FACILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BedFacilityModels Excluding Ids failed',

	DELETE_ALL_BED_FACILITY = '[ENTITY] Delete all BedFacilityModels',
	DELETE_ALL_BED_FACILITY_OK = '[ENTITY] Delete all BedFacilityModels successfully',
	DELETE_ALL_BED_FACILITY_FAIL = '[ENTITY] Delete all BedFacilityModels failed',

	UPDATE_BED_FACILITY = '[ENTITY] Update BedFacilityModel',
	UPDATE_BED_FACILITY_OK = '[ENTITY] Update BedFacilityModel successfully',
	UPDATE_BED_FACILITY_FAIL = '[ENTITY] Update BedFacilityModel failed',

	UPDATE_ALL_BED_FACILITY = '[ENTITY] Update all BedFacilityModel',
	UPDATE_ALL_BED_FACILITY_OK = '[ENTITY] Update all BedFacilityModel successfully',
	UPDATE_ALL_BED_FACILITY_FAIL = '[ENTITY] Update all BedFacilityModel failed',

	FETCH_BED_FACILITY= '[ENTITY] Fetch BedFacilityModel',
	FETCH_BED_FACILITY_OK = '[ENTITY] Fetch BedFacilityModel successfully',
	FETCH_BED_FACILITY_FAIL = '[ENTITY] Fetch BedFacilityModel failed',

	FETCH_BED_FACILITY_AUDIT= '[ENTITY] Fetch BedFacilityModel audit',
	FETCH_BED_FACILITY_AUDIT_OK = '[ENTITY] Fetch BedFacilityModel audit successfully',
	FETCH_BED_FACILITY_AUDIT_FAIL = '[ENTITY] Fetch BedFacilityModel audit failed',

	FETCH_BED_FACILITY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BedFacilityModel audits by entity id',
	FETCH_BED_FACILITY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BedFacilityModel audits by entity id successfully',
	FETCH_BED_FACILITY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BedFacilityModel audits by entity id failed',

	FETCH_ALL_BED_FACILITY = '[ENTITY] Fetch all BedFacilityModel',
	FETCH_ALL_BED_FACILITY_OK = '[ENTITY] Fetch all BedFacilityModel successfully',
	FETCH_ALL_BED_FACILITY_FAIL = '[ENTITY] Fetch all BedFacilityModel failed',

	FETCH_BED_FACILITY_WITH_QUERY = '[ENTITY] Fetch BedFacilityModel with query',
	FETCH_BED_FACILITY_WITH_QUERY_OK = '[ENTITY] Fetch BedFacilityModel with query successfully',
	FETCH_BED_FACILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch BedFacilityModel with query failed',

	FETCH_LAST_BED_FACILITY_WITH_QUERY = '[ENTITY] Fetch last BedFacilityModel with query',
	FETCH_LAST_BED_FACILITY_WITH_QUERY_OK = '[ENTITY] Fetch last BedFacilityModel with query successfully',
	FETCH_LAST_BED_FACILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch last BedFacilityModel with query failed',

	EXPORT_BED_FACILITY = '[ENTITY] Export BedFacilityModel',
	EXPORT_BED_FACILITY_OK = '[ENTITY] Export BedFacilityModel successfully',
	EXPORT_BED_FACILITY_FAIL = '[ENTITY] Export BedFacilityModel failed',

	EXPORT_ALL_BED_FACILITY = '[ENTITY] Export All BedFacilityModels',
	EXPORT_ALL_BED_FACILITY_OK = '[ENTITY] Export All BedFacilityModels successfully',
	EXPORT_ALL_BED_FACILITY_FAIL = '[ENTITY] Export All BedFacilityModels failed',

	EXPORT_BED_FACILITY_EXCLUDING_IDS = '[ENTITY] Export BedFacilityModels excluding Ids',
	EXPORT_BED_FACILITY_EXCLUDING_IDS_OK = '[ENTITY] Export BedFacilityModel excluding Ids successfully',
	EXPORT_BED_FACILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Export BedFacilityModel excluding Ids failed',

	COUNT_BED_FACILITYS = '[ENTITY] Fetch number of BedFacilityModel records',
	COUNT_BED_FACILITYS_OK = '[ENTITY] Fetch number of BedFacilityModel records successfully ',
	COUNT_BED_FACILITYS_FAIL = '[ENTITY] Fetch number of BedFacilityModel records failed',

	IMPORT_BED_FACILITYS = '[ENTITY] Import BedFacilityModels',
	IMPORT_BED_FACILITYS_OK = '[ENTITY] Import BedFacilityModels successfully',
	IMPORT_BED_FACILITYS_FAIL = '[ENTITY] Import BedFacilityModels fail',


	INITIALISE_BED_FACILITY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BedFacilityModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBedFacilityAction implements Action {
	readonly className: string = 'BedFacilityModel';

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

export class BedFacilityAction extends BaseBedFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BedFacilityAction here] off begin
	// % protected region % [Add any additional class fields for BedFacilityAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BedFacilityModel>,
		// % protected region % [Add any additional constructor parameters for BedFacilityAction here] off begin
		// % protected region % [Add any additional constructor parameters for BedFacilityAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BedFacilityAction here] off begin
			// % protected region % [Add any additional constructor arguments for BedFacilityAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BedFacilityAction here] off begin
		// % protected region % [Add any additional constructor logic for BedFacilityAction here] end
	}

	// % protected region % [Add any additional class methods for BedFacilityAction here] off begin
	// % protected region % [Add any additional class methods for BedFacilityAction here] end
}

export class BedFacilityActionOK extends BaseBedFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BedFacilityActionOK here] off begin
	// % protected region % [Add any additional class fields for BedFacilityActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BedFacilityModel>,
		// % protected region % [Add any additional constructor parameters for BedFacilityActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BedFacilityActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BedFacilityModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BedFacilityActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BedFacilityActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BedFacilityActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BedFacilityActionOK here] end
	}

	// % protected region % [Add any additional class methods for BedFacilityActionOK here] off begin
	// % protected region % [Add any additional class methods for BedFacilityActionOK here] end
}

export class BedFacilityActionFail extends BaseBedFacilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BedFacilityActionFail here] off begin
	// % protected region % [Add any additional class fields for BedFacilityActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BedFacilityModel>,
		// % protected region % [Add any additional constructor parameters for BedFacilityActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BedFacilityActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BedFacilityActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BedFacilityActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BedFacilityActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BedFacilityActionFail here] end
	}

	// % protected region % [Add any additional class methods for BedFacilityActionFail here] off begin
	// % protected region % [Add any additional class methods for BedFacilityActionFail here] end
}

export function isBedFacilityModelAction(e: any): e is BaseBedFacilityAction {
	return Object.values(BedFacilityModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
