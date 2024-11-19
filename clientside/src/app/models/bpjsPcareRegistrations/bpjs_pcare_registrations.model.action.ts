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
import {BpjsPcareRegistrationsModel} from './bpjs_pcare_registrations.model';
import {BpjsPcareRegistrationsModelAudit} from './bpjs_pcare_registrations.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Pcare Registrations model actions to be dispatched by NgRx.
 */
export enum BpjsPcareRegistrationsModelActionTypes {
	CREATE_BPJS_PCARE_REGISTRATIONS = '[ENTITY] Create BpjsPcareRegistrationsModel',
	CREATE_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Create BpjsPcareRegistrationsModel successfully',
	CREATE_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Create BpjsPcareRegistrationsModel failed',

	CREATE_ALL_BPJS_PCARE_REGISTRATIONS = '[ENTITY] Create All BpjsPcareRegistrationsModel',
	CREATE_ALL_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Create All BpjsPcareRegistrationsModel successfully',
	CREATE_ALL_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Create All BpjsPcareRegistrationsModel failed',

	DELETE_BPJS_PCARE_REGISTRATIONS = '[ENTITY] Delete BpjsPcareRegistrationsModel',
	DELETE_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Delete BpjsPcareRegistrationsModel successfully',
	DELETE_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Delete BpjsPcareRegistrationsModel failed',


	DELETE_BPJS_PCARE_REGISTRATIONS_EXCLUDING_IDS = '[ENTITY] Delete BpjsPcareRegistrationsModels Excluding Ids',
	DELETE_BPJS_PCARE_REGISTRATIONS_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsPcareRegistrationsModels Excluding Ids successfully',
	DELETE_BPJS_PCARE_REGISTRATIONS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsPcareRegistrationsModels Excluding Ids failed',

	DELETE_ALL_BPJS_PCARE_REGISTRATIONS = '[ENTITY] Delete all BpjsPcareRegistrationsModels',
	DELETE_ALL_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Delete all BpjsPcareRegistrationsModels successfully',
	DELETE_ALL_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Delete all BpjsPcareRegistrationsModels failed',

	UPDATE_BPJS_PCARE_REGISTRATIONS = '[ENTITY] Update BpjsPcareRegistrationsModel',
	UPDATE_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Update BpjsPcareRegistrationsModel successfully',
	UPDATE_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Update BpjsPcareRegistrationsModel failed',

	UPDATE_ALL_BPJS_PCARE_REGISTRATIONS = '[ENTITY] Update all BpjsPcareRegistrationsModel',
	UPDATE_ALL_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Update all BpjsPcareRegistrationsModel successfully',
	UPDATE_ALL_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Update all BpjsPcareRegistrationsModel failed',

	FETCH_BPJS_PCARE_REGISTRATIONS= '[ENTITY] Fetch BpjsPcareRegistrationsModel',
	FETCH_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Fetch BpjsPcareRegistrationsModel successfully',
	FETCH_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Fetch BpjsPcareRegistrationsModel failed',

	FETCH_BPJS_PCARE_REGISTRATIONS_AUDIT= '[ENTITY] Fetch BpjsPcareRegistrationsModel audit',
	FETCH_BPJS_PCARE_REGISTRATIONS_AUDIT_OK = '[ENTITY] Fetch BpjsPcareRegistrationsModel audit successfully',
	FETCH_BPJS_PCARE_REGISTRATIONS_AUDIT_FAIL = '[ENTITY] Fetch BpjsPcareRegistrationsModel audit failed',

	FETCH_BPJS_PCARE_REGISTRATIONS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsPcareRegistrationsModel audits by entity id',
	FETCH_BPJS_PCARE_REGISTRATIONS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsPcareRegistrationsModel audits by entity id successfully',
	FETCH_BPJS_PCARE_REGISTRATIONS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsPcareRegistrationsModel audits by entity id failed',

	FETCH_ALL_BPJS_PCARE_REGISTRATIONS = '[ENTITY] Fetch all BpjsPcareRegistrationsModel',
	FETCH_ALL_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Fetch all BpjsPcareRegistrationsModel successfully',
	FETCH_ALL_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Fetch all BpjsPcareRegistrationsModel failed',

	FETCH_BPJS_PCARE_REGISTRATIONS_WITH_QUERY = '[ENTITY] Fetch BpjsPcareRegistrationsModel with query',
	FETCH_BPJS_PCARE_REGISTRATIONS_WITH_QUERY_OK = '[ENTITY] Fetch BpjsPcareRegistrationsModel with query successfully',
	FETCH_BPJS_PCARE_REGISTRATIONS_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsPcareRegistrationsModel with query failed',

	FETCH_LAST_BPJS_PCARE_REGISTRATIONS_WITH_QUERY = '[ENTITY] Fetch last BpjsPcareRegistrationsModel with query',
	FETCH_LAST_BPJS_PCARE_REGISTRATIONS_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsPcareRegistrationsModel with query successfully',
	FETCH_LAST_BPJS_PCARE_REGISTRATIONS_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsPcareRegistrationsModel with query failed',

	EXPORT_BPJS_PCARE_REGISTRATIONS = '[ENTITY] Export BpjsPcareRegistrationsModel',
	EXPORT_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Export BpjsPcareRegistrationsModel successfully',
	EXPORT_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Export BpjsPcareRegistrationsModel failed',

	EXPORT_ALL_BPJS_PCARE_REGISTRATIONS = '[ENTITY] Export All BpjsPcareRegistrationsModels',
	EXPORT_ALL_BPJS_PCARE_REGISTRATIONS_OK = '[ENTITY] Export All BpjsPcareRegistrationsModels successfully',
	EXPORT_ALL_BPJS_PCARE_REGISTRATIONS_FAIL = '[ENTITY] Export All BpjsPcareRegistrationsModels failed',

	EXPORT_BPJS_PCARE_REGISTRATIONS_EXCLUDING_IDS = '[ENTITY] Export BpjsPcareRegistrationsModels excluding Ids',
	EXPORT_BPJS_PCARE_REGISTRATIONS_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsPcareRegistrationsModel excluding Ids successfully',
	EXPORT_BPJS_PCARE_REGISTRATIONS_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsPcareRegistrationsModel excluding Ids failed',

	COUNT_BPJS_PCARE_REGISTRATIONSS = '[ENTITY] Fetch number of BpjsPcareRegistrationsModel records',
	COUNT_BPJS_PCARE_REGISTRATIONSS_OK = '[ENTITY] Fetch number of BpjsPcareRegistrationsModel records successfully ',
	COUNT_BPJS_PCARE_REGISTRATIONSS_FAIL = '[ENTITY] Fetch number of BpjsPcareRegistrationsModel records failed',

	IMPORT_BPJS_PCARE_REGISTRATIONSS = '[ENTITY] Import BpjsPcareRegistrationsModels',
	IMPORT_BPJS_PCARE_REGISTRATIONSS_OK = '[ENTITY] Import BpjsPcareRegistrationsModels successfully',
	IMPORT_BPJS_PCARE_REGISTRATIONSS_FAIL = '[ENTITY] Import BpjsPcareRegistrationsModels fail',


	INITIALISE_BPJS_PCARE_REGISTRATIONS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsPcareRegistrationsModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsPcareRegistrationsAction implements Action {
	readonly className: string = 'BpjsPcareRegistrationsModel';

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

export class BpjsPcareRegistrationsAction extends BaseBpjsPcareRegistrationsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareRegistrationsAction here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareRegistrationsAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareRegistrationsModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareRegistrationsAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareRegistrationsAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareRegistrationsAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareRegistrationsAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareRegistrationsAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareRegistrationsAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareRegistrationsAction here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareRegistrationsAction here] end
}

export class BpjsPcareRegistrationsActionOK extends BaseBpjsPcareRegistrationsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareRegistrationsActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareRegistrationsActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsPcareRegistrationsModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareRegistrationsActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareRegistrationsActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsPcareRegistrationsModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareRegistrationsActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareRegistrationsActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareRegistrationsActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareRegistrationsActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareRegistrationsActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareRegistrationsActionOK here] end
}

export class BpjsPcareRegistrationsActionFail extends BaseBpjsPcareRegistrationsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsPcareRegistrationsActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsPcareRegistrationsActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsPcareRegistrationsModel>,
		// % protected region % [Add any additional constructor parameters for BpjsPcareRegistrationsActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsPcareRegistrationsActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsPcareRegistrationsActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsPcareRegistrationsActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsPcareRegistrationsActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsPcareRegistrationsActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsPcareRegistrationsActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsPcareRegistrationsActionFail here] end
}

export function isBpjsPcareRegistrationsModelAction(e: any): e is BaseBpjsPcareRegistrationsAction {
	return Object.values(BpjsPcareRegistrationsModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
