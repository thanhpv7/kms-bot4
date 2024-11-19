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
import {PatientDetailAddressModel} from './patient_detail_address.model';
import {PatientDetailAddressModelAudit} from './patient_detail_address.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Detail Address model actions to be dispatched by NgRx.
 */
export enum PatientDetailAddressModelActionTypes {
	CREATE_PATIENT_DETAIL_ADDRESS = '[ENTITY] Create PatientDetailAddressModel',
	CREATE_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Create PatientDetailAddressModel successfully',
	CREATE_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Create PatientDetailAddressModel failed',

	CREATE_ALL_PATIENT_DETAIL_ADDRESS = '[ENTITY] Create All PatientDetailAddressModel',
	CREATE_ALL_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Create All PatientDetailAddressModel successfully',
	CREATE_ALL_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Create All PatientDetailAddressModel failed',

	DELETE_PATIENT_DETAIL_ADDRESS = '[ENTITY] Delete PatientDetailAddressModel',
	DELETE_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Delete PatientDetailAddressModel successfully',
	DELETE_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Delete PatientDetailAddressModel failed',


	DELETE_PATIENT_DETAIL_ADDRESS_EXCLUDING_IDS = '[ENTITY] Delete PatientDetailAddressModels Excluding Ids',
	DELETE_PATIENT_DETAIL_ADDRESS_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientDetailAddressModels Excluding Ids successfully',
	DELETE_PATIENT_DETAIL_ADDRESS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientDetailAddressModels Excluding Ids failed',

	DELETE_ALL_PATIENT_DETAIL_ADDRESS = '[ENTITY] Delete all PatientDetailAddressModels',
	DELETE_ALL_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Delete all PatientDetailAddressModels successfully',
	DELETE_ALL_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Delete all PatientDetailAddressModels failed',

	UPDATE_PATIENT_DETAIL_ADDRESS = '[ENTITY] Update PatientDetailAddressModel',
	UPDATE_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Update PatientDetailAddressModel successfully',
	UPDATE_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Update PatientDetailAddressModel failed',

	UPDATE_ALL_PATIENT_DETAIL_ADDRESS = '[ENTITY] Update all PatientDetailAddressModel',
	UPDATE_ALL_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Update all PatientDetailAddressModel successfully',
	UPDATE_ALL_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Update all PatientDetailAddressModel failed',

	FETCH_PATIENT_DETAIL_ADDRESS= '[ENTITY] Fetch PatientDetailAddressModel',
	FETCH_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Fetch PatientDetailAddressModel successfully',
	FETCH_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Fetch PatientDetailAddressModel failed',

	FETCH_PATIENT_DETAIL_ADDRESS_AUDIT= '[ENTITY] Fetch PatientDetailAddressModel audit',
	FETCH_PATIENT_DETAIL_ADDRESS_AUDIT_OK = '[ENTITY] Fetch PatientDetailAddressModel audit successfully',
	FETCH_PATIENT_DETAIL_ADDRESS_AUDIT_FAIL = '[ENTITY] Fetch PatientDetailAddressModel audit failed',

	FETCH_PATIENT_DETAIL_ADDRESS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientDetailAddressModel audits by entity id',
	FETCH_PATIENT_DETAIL_ADDRESS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientDetailAddressModel audits by entity id successfully',
	FETCH_PATIENT_DETAIL_ADDRESS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientDetailAddressModel audits by entity id failed',

	FETCH_ALL_PATIENT_DETAIL_ADDRESS = '[ENTITY] Fetch all PatientDetailAddressModel',
	FETCH_ALL_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Fetch all PatientDetailAddressModel successfully',
	FETCH_ALL_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Fetch all PatientDetailAddressModel failed',

	FETCH_PATIENT_DETAIL_ADDRESS_WITH_QUERY = '[ENTITY] Fetch PatientDetailAddressModel with query',
	FETCH_PATIENT_DETAIL_ADDRESS_WITH_QUERY_OK = '[ENTITY] Fetch PatientDetailAddressModel with query successfully',
	FETCH_PATIENT_DETAIL_ADDRESS_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientDetailAddressModel with query failed',

	FETCH_LAST_PATIENT_DETAIL_ADDRESS_WITH_QUERY = '[ENTITY] Fetch last PatientDetailAddressModel with query',
	FETCH_LAST_PATIENT_DETAIL_ADDRESS_WITH_QUERY_OK = '[ENTITY] Fetch last PatientDetailAddressModel with query successfully',
	FETCH_LAST_PATIENT_DETAIL_ADDRESS_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientDetailAddressModel with query failed',

	EXPORT_PATIENT_DETAIL_ADDRESS = '[ENTITY] Export PatientDetailAddressModel',
	EXPORT_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Export PatientDetailAddressModel successfully',
	EXPORT_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Export PatientDetailAddressModel failed',

	EXPORT_ALL_PATIENT_DETAIL_ADDRESS = '[ENTITY] Export All PatientDetailAddressModels',
	EXPORT_ALL_PATIENT_DETAIL_ADDRESS_OK = '[ENTITY] Export All PatientDetailAddressModels successfully',
	EXPORT_ALL_PATIENT_DETAIL_ADDRESS_FAIL = '[ENTITY] Export All PatientDetailAddressModels failed',

	EXPORT_PATIENT_DETAIL_ADDRESS_EXCLUDING_IDS = '[ENTITY] Export PatientDetailAddressModels excluding Ids',
	EXPORT_PATIENT_DETAIL_ADDRESS_EXCLUDING_IDS_OK = '[ENTITY] Export PatientDetailAddressModel excluding Ids successfully',
	EXPORT_PATIENT_DETAIL_ADDRESS_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientDetailAddressModel excluding Ids failed',

	COUNT_PATIENT_DETAIL_ADDRESSS = '[ENTITY] Fetch number of PatientDetailAddressModel records',
	COUNT_PATIENT_DETAIL_ADDRESSS_OK = '[ENTITY] Fetch number of PatientDetailAddressModel records successfully ',
	COUNT_PATIENT_DETAIL_ADDRESSS_FAIL = '[ENTITY] Fetch number of PatientDetailAddressModel records failed',

	IMPORT_PATIENT_DETAIL_ADDRESSS = '[ENTITY] Import PatientDetailAddressModels',
	IMPORT_PATIENT_DETAIL_ADDRESSS_OK = '[ENTITY] Import PatientDetailAddressModels successfully',
	IMPORT_PATIENT_DETAIL_ADDRESSS_FAIL = '[ENTITY] Import PatientDetailAddressModels fail',


	INITIALISE_PATIENT_DETAIL_ADDRESS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientDetailAddressModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientDetailAddressAction implements Action {
	readonly className: string = 'PatientDetailAddressModel';

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

export class PatientDetailAddressAction extends BasePatientDetailAddressAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientDetailAddressAction here] off begin
	// % protected region % [Add any additional class fields for PatientDetailAddressAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientDetailAddressModel>,
		// % protected region % [Add any additional constructor parameters for PatientDetailAddressAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientDetailAddressAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientDetailAddressAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientDetailAddressAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientDetailAddressAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientDetailAddressAction here] end
	}

	// % protected region % [Add any additional class methods for PatientDetailAddressAction here] off begin
	// % protected region % [Add any additional class methods for PatientDetailAddressAction here] end
}

export class PatientDetailAddressActionOK extends BasePatientDetailAddressAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientDetailAddressActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientDetailAddressActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientDetailAddressModel>,
		// % protected region % [Add any additional constructor parameters for PatientDetailAddressActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientDetailAddressActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientDetailAddressModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientDetailAddressActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientDetailAddressActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientDetailAddressActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientDetailAddressActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientDetailAddressActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientDetailAddressActionOK here] end
}

export class PatientDetailAddressActionFail extends BasePatientDetailAddressAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientDetailAddressActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientDetailAddressActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientDetailAddressModel>,
		// % protected region % [Add any additional constructor parameters for PatientDetailAddressActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientDetailAddressActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientDetailAddressActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientDetailAddressActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientDetailAddressActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientDetailAddressActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientDetailAddressActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientDetailAddressActionFail here] end
}

export function isPatientDetailAddressModelAction(e: any): e is BasePatientDetailAddressAction {
	return Object.values(PatientDetailAddressModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
