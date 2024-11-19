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
import {UnitOfMeasurementModel} from './unit_of_measurement.model';
import {UnitOfMeasurementModelAudit} from './unit_of_measurement.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Unit Of Measurement model actions to be dispatched by NgRx.
 */
export enum UnitOfMeasurementModelActionTypes {
	CREATE_UNIT_OF_MEASUREMENT = '[ENTITY] Create UnitOfMeasurementModel',
	CREATE_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Create UnitOfMeasurementModel successfully',
	CREATE_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Create UnitOfMeasurementModel failed',

	CREATE_ALL_UNIT_OF_MEASUREMENT = '[ENTITY] Create All UnitOfMeasurementModel',
	CREATE_ALL_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Create All UnitOfMeasurementModel successfully',
	CREATE_ALL_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Create All UnitOfMeasurementModel failed',

	DELETE_UNIT_OF_MEASUREMENT = '[ENTITY] Delete UnitOfMeasurementModel',
	DELETE_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Delete UnitOfMeasurementModel successfully',
	DELETE_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Delete UnitOfMeasurementModel failed',


	DELETE_UNIT_OF_MEASUREMENT_EXCLUDING_IDS = '[ENTITY] Delete UnitOfMeasurementModels Excluding Ids',
	DELETE_UNIT_OF_MEASUREMENT_EXCLUDING_IDS_OK = '[ENTITY] Delete UnitOfMeasurementModels Excluding Ids successfully',
	DELETE_UNIT_OF_MEASUREMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete UnitOfMeasurementModels Excluding Ids failed',

	DELETE_ALL_UNIT_OF_MEASUREMENT = '[ENTITY] Delete all UnitOfMeasurementModels',
	DELETE_ALL_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Delete all UnitOfMeasurementModels successfully',
	DELETE_ALL_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Delete all UnitOfMeasurementModels failed',

	UPDATE_UNIT_OF_MEASUREMENT = '[ENTITY] Update UnitOfMeasurementModel',
	UPDATE_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Update UnitOfMeasurementModel successfully',
	UPDATE_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Update UnitOfMeasurementModel failed',

	UPDATE_ALL_UNIT_OF_MEASUREMENT = '[ENTITY] Update all UnitOfMeasurementModel',
	UPDATE_ALL_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Update all UnitOfMeasurementModel successfully',
	UPDATE_ALL_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Update all UnitOfMeasurementModel failed',

	FETCH_UNIT_OF_MEASUREMENT= '[ENTITY] Fetch UnitOfMeasurementModel',
	FETCH_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Fetch UnitOfMeasurementModel successfully',
	FETCH_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Fetch UnitOfMeasurementModel failed',

	FETCH_UNIT_OF_MEASUREMENT_AUDIT= '[ENTITY] Fetch UnitOfMeasurementModel audit',
	FETCH_UNIT_OF_MEASUREMENT_AUDIT_OK = '[ENTITY] Fetch UnitOfMeasurementModel audit successfully',
	FETCH_UNIT_OF_MEASUREMENT_AUDIT_FAIL = '[ENTITY] Fetch UnitOfMeasurementModel audit failed',

	FETCH_UNIT_OF_MEASUREMENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch UnitOfMeasurementModel audits by entity id',
	FETCH_UNIT_OF_MEASUREMENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch UnitOfMeasurementModel audits by entity id successfully',
	FETCH_UNIT_OF_MEASUREMENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch UnitOfMeasurementModel audits by entity id failed',

	FETCH_ALL_UNIT_OF_MEASUREMENT = '[ENTITY] Fetch all UnitOfMeasurementModel',
	FETCH_ALL_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Fetch all UnitOfMeasurementModel successfully',
	FETCH_ALL_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Fetch all UnitOfMeasurementModel failed',

	FETCH_UNIT_OF_MEASUREMENT_WITH_QUERY = '[ENTITY] Fetch UnitOfMeasurementModel with query',
	FETCH_UNIT_OF_MEASUREMENT_WITH_QUERY_OK = '[ENTITY] Fetch UnitOfMeasurementModel with query successfully',
	FETCH_UNIT_OF_MEASUREMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch UnitOfMeasurementModel with query failed',

	FETCH_LAST_UNIT_OF_MEASUREMENT_WITH_QUERY = '[ENTITY] Fetch last UnitOfMeasurementModel with query',
	FETCH_LAST_UNIT_OF_MEASUREMENT_WITH_QUERY_OK = '[ENTITY] Fetch last UnitOfMeasurementModel with query successfully',
	FETCH_LAST_UNIT_OF_MEASUREMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last UnitOfMeasurementModel with query failed',

	EXPORT_UNIT_OF_MEASUREMENT = '[ENTITY] Export UnitOfMeasurementModel',
	EXPORT_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Export UnitOfMeasurementModel successfully',
	EXPORT_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Export UnitOfMeasurementModel failed',

	EXPORT_ALL_UNIT_OF_MEASUREMENT = '[ENTITY] Export All UnitOfMeasurementModels',
	EXPORT_ALL_UNIT_OF_MEASUREMENT_OK = '[ENTITY] Export All UnitOfMeasurementModels successfully',
	EXPORT_ALL_UNIT_OF_MEASUREMENT_FAIL = '[ENTITY] Export All UnitOfMeasurementModels failed',

	EXPORT_UNIT_OF_MEASUREMENT_EXCLUDING_IDS = '[ENTITY] Export UnitOfMeasurementModels excluding Ids',
	EXPORT_UNIT_OF_MEASUREMENT_EXCLUDING_IDS_OK = '[ENTITY] Export UnitOfMeasurementModel excluding Ids successfully',
	EXPORT_UNIT_OF_MEASUREMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export UnitOfMeasurementModel excluding Ids failed',

	COUNT_UNIT_OF_MEASUREMENTS = '[ENTITY] Fetch number of UnitOfMeasurementModel records',
	COUNT_UNIT_OF_MEASUREMENTS_OK = '[ENTITY] Fetch number of UnitOfMeasurementModel records successfully ',
	COUNT_UNIT_OF_MEASUREMENTS_FAIL = '[ENTITY] Fetch number of UnitOfMeasurementModel records failed',

	IMPORT_UNIT_OF_MEASUREMENTS = '[ENTITY] Import UnitOfMeasurementModels',
	IMPORT_UNIT_OF_MEASUREMENTS_OK = '[ENTITY] Import UnitOfMeasurementModels successfully',
	IMPORT_UNIT_OF_MEASUREMENTS_FAIL = '[ENTITY] Import UnitOfMeasurementModels fail',


	INITIALISE_UNIT_OF_MEASUREMENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of UnitOfMeasurementModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseUnitOfMeasurementAction implements Action {
	readonly className: string = 'UnitOfMeasurementModel';

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

export class UnitOfMeasurementAction extends BaseUnitOfMeasurementAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for UnitOfMeasurementAction here] off begin
	// % protected region % [Add any additional class fields for UnitOfMeasurementAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<UnitOfMeasurementModel>,
		// % protected region % [Add any additional constructor parameters for UnitOfMeasurementAction here] off begin
		// % protected region % [Add any additional constructor parameters for UnitOfMeasurementAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for UnitOfMeasurementAction here] off begin
			// % protected region % [Add any additional constructor arguments for UnitOfMeasurementAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for UnitOfMeasurementAction here] off begin
		// % protected region % [Add any additional constructor logic for UnitOfMeasurementAction here] end
	}

	// % protected region % [Add any additional class methods for UnitOfMeasurementAction here] off begin
	// % protected region % [Add any additional class methods for UnitOfMeasurementAction here] end
}

export class UnitOfMeasurementActionOK extends BaseUnitOfMeasurementAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for UnitOfMeasurementActionOK here] off begin
	// % protected region % [Add any additional class fields for UnitOfMeasurementActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<UnitOfMeasurementModel>,
		// % protected region % [Add any additional constructor parameters for UnitOfMeasurementActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for UnitOfMeasurementActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: UnitOfMeasurementModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for UnitOfMeasurementActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for UnitOfMeasurementActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for UnitOfMeasurementActionOK here] off begin
		// % protected region % [Add any additional constructor logic for UnitOfMeasurementActionOK here] end
	}

	// % protected region % [Add any additional class methods for UnitOfMeasurementActionOK here] off begin
	// % protected region % [Add any additional class methods for UnitOfMeasurementActionOK here] end
}

export class UnitOfMeasurementActionFail extends BaseUnitOfMeasurementAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for UnitOfMeasurementActionFail here] off begin
	// % protected region % [Add any additional class fields for UnitOfMeasurementActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<UnitOfMeasurementModel>,
		// % protected region % [Add any additional constructor parameters for UnitOfMeasurementActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for UnitOfMeasurementActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for UnitOfMeasurementActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for UnitOfMeasurementActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for UnitOfMeasurementActionFail here] off begin
		// % protected region % [Add any additional constructor logic for UnitOfMeasurementActionFail here] end
	}

	// % protected region % [Add any additional class methods for UnitOfMeasurementActionFail here] off begin
	// % protected region % [Add any additional class methods for UnitOfMeasurementActionFail here] end
}

export function isUnitOfMeasurementModelAction(e: any): e is BaseUnitOfMeasurementAction {
	return Object.values(UnitOfMeasurementModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
