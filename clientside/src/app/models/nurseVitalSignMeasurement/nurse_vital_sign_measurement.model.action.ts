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
import {NurseVitalSignMeasurementModel} from './nurse_vital_sign_measurement.model';
import {NurseVitalSignMeasurementModelAudit} from './nurse_vital_sign_measurement.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Nurse Vital Sign Measurement model actions to be dispatched by NgRx.
 */
export enum NurseVitalSignMeasurementModelActionTypes {
	CREATE_NURSE_VITAL_SIGN_MEASUREMENT = '[ENTITY] Create NurseVitalSignMeasurementModel',
	CREATE_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Create NurseVitalSignMeasurementModel successfully',
	CREATE_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Create NurseVitalSignMeasurementModel failed',

	CREATE_ALL_NURSE_VITAL_SIGN_MEASUREMENT = '[ENTITY] Create All NurseVitalSignMeasurementModel',
	CREATE_ALL_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Create All NurseVitalSignMeasurementModel successfully',
	CREATE_ALL_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Create All NurseVitalSignMeasurementModel failed',

	DELETE_NURSE_VITAL_SIGN_MEASUREMENT = '[ENTITY] Delete NurseVitalSignMeasurementModel',
	DELETE_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Delete NurseVitalSignMeasurementModel successfully',
	DELETE_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Delete NurseVitalSignMeasurementModel failed',


	DELETE_NURSE_VITAL_SIGN_MEASUREMENT_EXCLUDING_IDS = '[ENTITY] Delete NurseVitalSignMeasurementModels Excluding Ids',
	DELETE_NURSE_VITAL_SIGN_MEASUREMENT_EXCLUDING_IDS_OK = '[ENTITY] Delete NurseVitalSignMeasurementModels Excluding Ids successfully',
	DELETE_NURSE_VITAL_SIGN_MEASUREMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NurseVitalSignMeasurementModels Excluding Ids failed',

	DELETE_ALL_NURSE_VITAL_SIGN_MEASUREMENT = '[ENTITY] Delete all NurseVitalSignMeasurementModels',
	DELETE_ALL_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Delete all NurseVitalSignMeasurementModels successfully',
	DELETE_ALL_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Delete all NurseVitalSignMeasurementModels failed',

	UPDATE_NURSE_VITAL_SIGN_MEASUREMENT = '[ENTITY] Update NurseVitalSignMeasurementModel',
	UPDATE_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Update NurseVitalSignMeasurementModel successfully',
	UPDATE_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Update NurseVitalSignMeasurementModel failed',

	UPDATE_ALL_NURSE_VITAL_SIGN_MEASUREMENT = '[ENTITY] Update all NurseVitalSignMeasurementModel',
	UPDATE_ALL_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Update all NurseVitalSignMeasurementModel successfully',
	UPDATE_ALL_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Update all NurseVitalSignMeasurementModel failed',

	FETCH_NURSE_VITAL_SIGN_MEASUREMENT= '[ENTITY] Fetch NurseVitalSignMeasurementModel',
	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Fetch NurseVitalSignMeasurementModel successfully',
	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Fetch NurseVitalSignMeasurementModel failed',

	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_AUDIT= '[ENTITY] Fetch NurseVitalSignMeasurementModel audit',
	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_AUDIT_OK = '[ENTITY] Fetch NurseVitalSignMeasurementModel audit successfully',
	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_AUDIT_FAIL = '[ENTITY] Fetch NurseVitalSignMeasurementModel audit failed',

	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NurseVitalSignMeasurementModel audits by entity id',
	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NurseVitalSignMeasurementModel audits by entity id successfully',
	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NurseVitalSignMeasurementModel audits by entity id failed',

	FETCH_ALL_NURSE_VITAL_SIGN_MEASUREMENT = '[ENTITY] Fetch all NurseVitalSignMeasurementModel',
	FETCH_ALL_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Fetch all NurseVitalSignMeasurementModel successfully',
	FETCH_ALL_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Fetch all NurseVitalSignMeasurementModel failed',

	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_WITH_QUERY = '[ENTITY] Fetch NurseVitalSignMeasurementModel with query',
	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_WITH_QUERY_OK = '[ENTITY] Fetch NurseVitalSignMeasurementModel with query successfully',
	FETCH_NURSE_VITAL_SIGN_MEASUREMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch NurseVitalSignMeasurementModel with query failed',

	FETCH_LAST_NURSE_VITAL_SIGN_MEASUREMENT_WITH_QUERY = '[ENTITY] Fetch last NurseVitalSignMeasurementModel with query',
	FETCH_LAST_NURSE_VITAL_SIGN_MEASUREMENT_WITH_QUERY_OK = '[ENTITY] Fetch last NurseVitalSignMeasurementModel with query successfully',
	FETCH_LAST_NURSE_VITAL_SIGN_MEASUREMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last NurseVitalSignMeasurementModel with query failed',

	EXPORT_NURSE_VITAL_SIGN_MEASUREMENT = '[ENTITY] Export NurseVitalSignMeasurementModel',
	EXPORT_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Export NurseVitalSignMeasurementModel successfully',
	EXPORT_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Export NurseVitalSignMeasurementModel failed',

	EXPORT_ALL_NURSE_VITAL_SIGN_MEASUREMENT = '[ENTITY] Export All NurseVitalSignMeasurementModels',
	EXPORT_ALL_NURSE_VITAL_SIGN_MEASUREMENT_OK = '[ENTITY] Export All NurseVitalSignMeasurementModels successfully',
	EXPORT_ALL_NURSE_VITAL_SIGN_MEASUREMENT_FAIL = '[ENTITY] Export All NurseVitalSignMeasurementModels failed',

	EXPORT_NURSE_VITAL_SIGN_MEASUREMENT_EXCLUDING_IDS = '[ENTITY] Export NurseVitalSignMeasurementModels excluding Ids',
	EXPORT_NURSE_VITAL_SIGN_MEASUREMENT_EXCLUDING_IDS_OK = '[ENTITY] Export NurseVitalSignMeasurementModel excluding Ids successfully',
	EXPORT_NURSE_VITAL_SIGN_MEASUREMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export NurseVitalSignMeasurementModel excluding Ids failed',

	COUNT_NURSE_VITAL_SIGN_MEASUREMENTS = '[ENTITY] Fetch number of NurseVitalSignMeasurementModel records',
	COUNT_NURSE_VITAL_SIGN_MEASUREMENTS_OK = '[ENTITY] Fetch number of NurseVitalSignMeasurementModel records successfully ',
	COUNT_NURSE_VITAL_SIGN_MEASUREMENTS_FAIL = '[ENTITY] Fetch number of NurseVitalSignMeasurementModel records failed',

	IMPORT_NURSE_VITAL_SIGN_MEASUREMENTS = '[ENTITY] Import NurseVitalSignMeasurementModels',
	IMPORT_NURSE_VITAL_SIGN_MEASUREMENTS_OK = '[ENTITY] Import NurseVitalSignMeasurementModels successfully',
	IMPORT_NURSE_VITAL_SIGN_MEASUREMENTS_FAIL = '[ENTITY] Import NurseVitalSignMeasurementModels fail',


	INITIALISE_NURSE_VITAL_SIGN_MEASUREMENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NurseVitalSignMeasurementModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNurseVitalSignMeasurementAction implements Action {
	readonly className: string = 'NurseVitalSignMeasurementModel';

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

export class NurseVitalSignMeasurementAction extends BaseNurseVitalSignMeasurementAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NurseVitalSignMeasurementAction here] off begin
	// % protected region % [Add any additional class fields for NurseVitalSignMeasurementAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NurseVitalSignMeasurementModel>,
		// % protected region % [Add any additional constructor parameters for NurseVitalSignMeasurementAction here] off begin
		// % protected region % [Add any additional constructor parameters for NurseVitalSignMeasurementAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NurseVitalSignMeasurementAction here] off begin
			// % protected region % [Add any additional constructor arguments for NurseVitalSignMeasurementAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NurseVitalSignMeasurementAction here] off begin
		// % protected region % [Add any additional constructor logic for NurseVitalSignMeasurementAction here] end
	}

	// % protected region % [Add any additional class methods for NurseVitalSignMeasurementAction here] off begin
	// % protected region % [Add any additional class methods for NurseVitalSignMeasurementAction here] end
}

export class NurseVitalSignMeasurementActionOK extends BaseNurseVitalSignMeasurementAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NurseVitalSignMeasurementActionOK here] off begin
	// % protected region % [Add any additional class fields for NurseVitalSignMeasurementActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NurseVitalSignMeasurementModel>,
		// % protected region % [Add any additional constructor parameters for NurseVitalSignMeasurementActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NurseVitalSignMeasurementActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NurseVitalSignMeasurementModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NurseVitalSignMeasurementActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NurseVitalSignMeasurementActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NurseVitalSignMeasurementActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NurseVitalSignMeasurementActionOK here] end
	}

	// % protected region % [Add any additional class methods for NurseVitalSignMeasurementActionOK here] off begin
	// % protected region % [Add any additional class methods for NurseVitalSignMeasurementActionOK here] end
}

export class NurseVitalSignMeasurementActionFail extends BaseNurseVitalSignMeasurementAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NurseVitalSignMeasurementActionFail here] off begin
	// % protected region % [Add any additional class fields for NurseVitalSignMeasurementActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NurseVitalSignMeasurementModel>,
		// % protected region % [Add any additional constructor parameters for NurseVitalSignMeasurementActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NurseVitalSignMeasurementActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NurseVitalSignMeasurementActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NurseVitalSignMeasurementActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NurseVitalSignMeasurementActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NurseVitalSignMeasurementActionFail here] end
	}

	// % protected region % [Add any additional class methods for NurseVitalSignMeasurementActionFail here] off begin
	// % protected region % [Add any additional class methods for NurseVitalSignMeasurementActionFail here] end
}

export function isNurseVitalSignMeasurementModelAction(e: any): e is BaseNurseVitalSignMeasurementAction {
	return Object.values(NurseVitalSignMeasurementModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
