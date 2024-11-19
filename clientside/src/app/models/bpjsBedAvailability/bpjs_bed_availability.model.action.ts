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
import {BpjsBedAvailabilityModel} from './bpjs_bed_availability.model';
import {BpjsBedAvailabilityModelAudit} from './bpjs_bed_availability.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Bed Availability model actions to be dispatched by NgRx.
 */
export enum BpjsBedAvailabilityModelActionTypes {
	CREATE_BPJS_BED_AVAILABILITY = '[ENTITY] Create BpjsBedAvailabilityModel',
	CREATE_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Create BpjsBedAvailabilityModel successfully',
	CREATE_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Create BpjsBedAvailabilityModel failed',

	CREATE_ALL_BPJS_BED_AVAILABILITY = '[ENTITY] Create All BpjsBedAvailabilityModel',
	CREATE_ALL_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Create All BpjsBedAvailabilityModel successfully',
	CREATE_ALL_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Create All BpjsBedAvailabilityModel failed',

	DELETE_BPJS_BED_AVAILABILITY = '[ENTITY] Delete BpjsBedAvailabilityModel',
	DELETE_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Delete BpjsBedAvailabilityModel successfully',
	DELETE_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Delete BpjsBedAvailabilityModel failed',


	DELETE_BPJS_BED_AVAILABILITY_EXCLUDING_IDS = '[ENTITY] Delete BpjsBedAvailabilityModels Excluding Ids',
	DELETE_BPJS_BED_AVAILABILITY_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsBedAvailabilityModels Excluding Ids successfully',
	DELETE_BPJS_BED_AVAILABILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsBedAvailabilityModels Excluding Ids failed',

	DELETE_ALL_BPJS_BED_AVAILABILITY = '[ENTITY] Delete all BpjsBedAvailabilityModels',
	DELETE_ALL_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Delete all BpjsBedAvailabilityModels successfully',
	DELETE_ALL_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Delete all BpjsBedAvailabilityModels failed',

	UPDATE_BPJS_BED_AVAILABILITY = '[ENTITY] Update BpjsBedAvailabilityModel',
	UPDATE_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Update BpjsBedAvailabilityModel successfully',
	UPDATE_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Update BpjsBedAvailabilityModel failed',

	UPDATE_ALL_BPJS_BED_AVAILABILITY = '[ENTITY] Update all BpjsBedAvailabilityModel',
	UPDATE_ALL_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Update all BpjsBedAvailabilityModel successfully',
	UPDATE_ALL_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Update all BpjsBedAvailabilityModel failed',

	FETCH_BPJS_BED_AVAILABILITY= '[ENTITY] Fetch BpjsBedAvailabilityModel',
	FETCH_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Fetch BpjsBedAvailabilityModel successfully',
	FETCH_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Fetch BpjsBedAvailabilityModel failed',

	FETCH_BPJS_BED_AVAILABILITY_AUDIT= '[ENTITY] Fetch BpjsBedAvailabilityModel audit',
	FETCH_BPJS_BED_AVAILABILITY_AUDIT_OK = '[ENTITY] Fetch BpjsBedAvailabilityModel audit successfully',
	FETCH_BPJS_BED_AVAILABILITY_AUDIT_FAIL = '[ENTITY] Fetch BpjsBedAvailabilityModel audit failed',

	FETCH_BPJS_BED_AVAILABILITY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsBedAvailabilityModel audits by entity id',
	FETCH_BPJS_BED_AVAILABILITY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsBedAvailabilityModel audits by entity id successfully',
	FETCH_BPJS_BED_AVAILABILITY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsBedAvailabilityModel audits by entity id failed',

	FETCH_ALL_BPJS_BED_AVAILABILITY = '[ENTITY] Fetch all BpjsBedAvailabilityModel',
	FETCH_ALL_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Fetch all BpjsBedAvailabilityModel successfully',
	FETCH_ALL_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Fetch all BpjsBedAvailabilityModel failed',

	FETCH_BPJS_BED_AVAILABILITY_WITH_QUERY = '[ENTITY] Fetch BpjsBedAvailabilityModel with query',
	FETCH_BPJS_BED_AVAILABILITY_WITH_QUERY_OK = '[ENTITY] Fetch BpjsBedAvailabilityModel with query successfully',
	FETCH_BPJS_BED_AVAILABILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsBedAvailabilityModel with query failed',

	FETCH_LAST_BPJS_BED_AVAILABILITY_WITH_QUERY = '[ENTITY] Fetch last BpjsBedAvailabilityModel with query',
	FETCH_LAST_BPJS_BED_AVAILABILITY_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsBedAvailabilityModel with query successfully',
	FETCH_LAST_BPJS_BED_AVAILABILITY_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsBedAvailabilityModel with query failed',

	EXPORT_BPJS_BED_AVAILABILITY = '[ENTITY] Export BpjsBedAvailabilityModel',
	EXPORT_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Export BpjsBedAvailabilityModel successfully',
	EXPORT_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Export BpjsBedAvailabilityModel failed',

	EXPORT_ALL_BPJS_BED_AVAILABILITY = '[ENTITY] Export All BpjsBedAvailabilityModels',
	EXPORT_ALL_BPJS_BED_AVAILABILITY_OK = '[ENTITY] Export All BpjsBedAvailabilityModels successfully',
	EXPORT_ALL_BPJS_BED_AVAILABILITY_FAIL = '[ENTITY] Export All BpjsBedAvailabilityModels failed',

	EXPORT_BPJS_BED_AVAILABILITY_EXCLUDING_IDS = '[ENTITY] Export BpjsBedAvailabilityModels excluding Ids',
	EXPORT_BPJS_BED_AVAILABILITY_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsBedAvailabilityModel excluding Ids successfully',
	EXPORT_BPJS_BED_AVAILABILITY_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsBedAvailabilityModel excluding Ids failed',

	COUNT_BPJS_BED_AVAILABILITYS = '[ENTITY] Fetch number of BpjsBedAvailabilityModel records',
	COUNT_BPJS_BED_AVAILABILITYS_OK = '[ENTITY] Fetch number of BpjsBedAvailabilityModel records successfully ',
	COUNT_BPJS_BED_AVAILABILITYS_FAIL = '[ENTITY] Fetch number of BpjsBedAvailabilityModel records failed',

	IMPORT_BPJS_BED_AVAILABILITYS = '[ENTITY] Import BpjsBedAvailabilityModels',
	IMPORT_BPJS_BED_AVAILABILITYS_OK = '[ENTITY] Import BpjsBedAvailabilityModels successfully',
	IMPORT_BPJS_BED_AVAILABILITYS_FAIL = '[ENTITY] Import BpjsBedAvailabilityModels fail',


	INITIALISE_BPJS_BED_AVAILABILITY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsBedAvailabilityModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsBedAvailabilityAction implements Action {
	readonly className: string = 'BpjsBedAvailabilityModel';

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

export class BpjsBedAvailabilityAction extends BaseBpjsBedAvailabilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsBedAvailabilityAction here] off begin
	// % protected region % [Add any additional class fields for BpjsBedAvailabilityAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsBedAvailabilityModel>,
		// % protected region % [Add any additional constructor parameters for BpjsBedAvailabilityAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsBedAvailabilityAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsBedAvailabilityAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsBedAvailabilityAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsBedAvailabilityAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsBedAvailabilityAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsBedAvailabilityAction here] off begin
	// % protected region % [Add any additional class methods for BpjsBedAvailabilityAction here] end
}

export class BpjsBedAvailabilityActionOK extends BaseBpjsBedAvailabilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsBedAvailabilityActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsBedAvailabilityActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsBedAvailabilityModel>,
		// % protected region % [Add any additional constructor parameters for BpjsBedAvailabilityActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsBedAvailabilityActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsBedAvailabilityModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsBedAvailabilityActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsBedAvailabilityActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsBedAvailabilityActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsBedAvailabilityActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsBedAvailabilityActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsBedAvailabilityActionOK here] end
}

export class BpjsBedAvailabilityActionFail extends BaseBpjsBedAvailabilityAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsBedAvailabilityActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsBedAvailabilityActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsBedAvailabilityModel>,
		// % protected region % [Add any additional constructor parameters for BpjsBedAvailabilityActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsBedAvailabilityActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsBedAvailabilityActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsBedAvailabilityActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsBedAvailabilityActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsBedAvailabilityActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsBedAvailabilityActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsBedAvailabilityActionFail here] end
}

export function isBpjsBedAvailabilityModelAction(e: any): e is BaseBpjsBedAvailabilityAction {
	return Object.values(BpjsBedAvailabilityModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
