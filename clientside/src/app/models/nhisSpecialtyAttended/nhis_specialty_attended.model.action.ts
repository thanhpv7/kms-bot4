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
import {NhisSpecialtyAttendedModel} from './nhis_specialty_attended.model';
import {NhisSpecialtyAttendedModelAudit} from './nhis_specialty_attended.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of NHIS Specialty Attended model actions to be dispatched by NgRx.
 */
export enum NhisSpecialtyAttendedModelActionTypes {
	CREATE_NHIS_SPECIALTY_ATTENDED = '[ENTITY] Create NhisSpecialtyAttendedModel',
	CREATE_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Create NhisSpecialtyAttendedModel successfully',
	CREATE_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Create NhisSpecialtyAttendedModel failed',

	CREATE_ALL_NHIS_SPECIALTY_ATTENDED = '[ENTITY] Create All NhisSpecialtyAttendedModel',
	CREATE_ALL_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Create All NhisSpecialtyAttendedModel successfully',
	CREATE_ALL_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Create All NhisSpecialtyAttendedModel failed',

	DELETE_NHIS_SPECIALTY_ATTENDED = '[ENTITY] Delete NhisSpecialtyAttendedModel',
	DELETE_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Delete NhisSpecialtyAttendedModel successfully',
	DELETE_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Delete NhisSpecialtyAttendedModel failed',


	DELETE_NHIS_SPECIALTY_ATTENDED_EXCLUDING_IDS = '[ENTITY] Delete NhisSpecialtyAttendedModels Excluding Ids',
	DELETE_NHIS_SPECIALTY_ATTENDED_EXCLUDING_IDS_OK = '[ENTITY] Delete NhisSpecialtyAttendedModels Excluding Ids successfully',
	DELETE_NHIS_SPECIALTY_ATTENDED_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NhisSpecialtyAttendedModels Excluding Ids failed',

	DELETE_ALL_NHIS_SPECIALTY_ATTENDED = '[ENTITY] Delete all NhisSpecialtyAttendedModels',
	DELETE_ALL_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Delete all NhisSpecialtyAttendedModels successfully',
	DELETE_ALL_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Delete all NhisSpecialtyAttendedModels failed',

	UPDATE_NHIS_SPECIALTY_ATTENDED = '[ENTITY] Update NhisSpecialtyAttendedModel',
	UPDATE_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Update NhisSpecialtyAttendedModel successfully',
	UPDATE_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Update NhisSpecialtyAttendedModel failed',

	UPDATE_ALL_NHIS_SPECIALTY_ATTENDED = '[ENTITY] Update all NhisSpecialtyAttendedModel',
	UPDATE_ALL_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Update all NhisSpecialtyAttendedModel successfully',
	UPDATE_ALL_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Update all NhisSpecialtyAttendedModel failed',

	FETCH_NHIS_SPECIALTY_ATTENDED= '[ENTITY] Fetch NhisSpecialtyAttendedModel',
	FETCH_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Fetch NhisSpecialtyAttendedModel successfully',
	FETCH_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Fetch NhisSpecialtyAttendedModel failed',

	FETCH_NHIS_SPECIALTY_ATTENDED_AUDIT= '[ENTITY] Fetch NhisSpecialtyAttendedModel audit',
	FETCH_NHIS_SPECIALTY_ATTENDED_AUDIT_OK = '[ENTITY] Fetch NhisSpecialtyAttendedModel audit successfully',
	FETCH_NHIS_SPECIALTY_ATTENDED_AUDIT_FAIL = '[ENTITY] Fetch NhisSpecialtyAttendedModel audit failed',

	FETCH_NHIS_SPECIALTY_ATTENDED_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NhisSpecialtyAttendedModel audits by entity id',
	FETCH_NHIS_SPECIALTY_ATTENDED_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NhisSpecialtyAttendedModel audits by entity id successfully',
	FETCH_NHIS_SPECIALTY_ATTENDED_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NhisSpecialtyAttendedModel audits by entity id failed',

	FETCH_ALL_NHIS_SPECIALTY_ATTENDED = '[ENTITY] Fetch all NhisSpecialtyAttendedModel',
	FETCH_ALL_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Fetch all NhisSpecialtyAttendedModel successfully',
	FETCH_ALL_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Fetch all NhisSpecialtyAttendedModel failed',

	FETCH_NHIS_SPECIALTY_ATTENDED_WITH_QUERY = '[ENTITY] Fetch NhisSpecialtyAttendedModel with query',
	FETCH_NHIS_SPECIALTY_ATTENDED_WITH_QUERY_OK = '[ENTITY] Fetch NhisSpecialtyAttendedModel with query successfully',
	FETCH_NHIS_SPECIALTY_ATTENDED_WITH_QUERY_FAIL = '[ENTITY] Fetch NhisSpecialtyAttendedModel with query failed',

	FETCH_LAST_NHIS_SPECIALTY_ATTENDED_WITH_QUERY = '[ENTITY] Fetch last NhisSpecialtyAttendedModel with query',
	FETCH_LAST_NHIS_SPECIALTY_ATTENDED_WITH_QUERY_OK = '[ENTITY] Fetch last NhisSpecialtyAttendedModel with query successfully',
	FETCH_LAST_NHIS_SPECIALTY_ATTENDED_WITH_QUERY_FAIL = '[ENTITY] Fetch last NhisSpecialtyAttendedModel with query failed',

	EXPORT_NHIS_SPECIALTY_ATTENDED = '[ENTITY] Export NhisSpecialtyAttendedModel',
	EXPORT_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Export NhisSpecialtyAttendedModel successfully',
	EXPORT_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Export NhisSpecialtyAttendedModel failed',

	EXPORT_ALL_NHIS_SPECIALTY_ATTENDED = '[ENTITY] Export All NhisSpecialtyAttendedModels',
	EXPORT_ALL_NHIS_SPECIALTY_ATTENDED_OK = '[ENTITY] Export All NhisSpecialtyAttendedModels successfully',
	EXPORT_ALL_NHIS_SPECIALTY_ATTENDED_FAIL = '[ENTITY] Export All NhisSpecialtyAttendedModels failed',

	EXPORT_NHIS_SPECIALTY_ATTENDED_EXCLUDING_IDS = '[ENTITY] Export NhisSpecialtyAttendedModels excluding Ids',
	EXPORT_NHIS_SPECIALTY_ATTENDED_EXCLUDING_IDS_OK = '[ENTITY] Export NhisSpecialtyAttendedModel excluding Ids successfully',
	EXPORT_NHIS_SPECIALTY_ATTENDED_EXCLUDING_IDS_FAIL = '[ENTITY] Export NhisSpecialtyAttendedModel excluding Ids failed',

	COUNT_NHIS_SPECIALTY_ATTENDEDS = '[ENTITY] Fetch number of NhisSpecialtyAttendedModel records',
	COUNT_NHIS_SPECIALTY_ATTENDEDS_OK = '[ENTITY] Fetch number of NhisSpecialtyAttendedModel records successfully ',
	COUNT_NHIS_SPECIALTY_ATTENDEDS_FAIL = '[ENTITY] Fetch number of NhisSpecialtyAttendedModel records failed',

	IMPORT_NHIS_SPECIALTY_ATTENDEDS = '[ENTITY] Import NhisSpecialtyAttendedModels',
	IMPORT_NHIS_SPECIALTY_ATTENDEDS_OK = '[ENTITY] Import NhisSpecialtyAttendedModels successfully',
	IMPORT_NHIS_SPECIALTY_ATTENDEDS_FAIL = '[ENTITY] Import NhisSpecialtyAttendedModels fail',


	INITIALISE_NHIS_SPECIALTY_ATTENDED_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NhisSpecialtyAttendedModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNhisSpecialtyAttendedAction implements Action {
	readonly className: string = 'NhisSpecialtyAttendedModel';

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

export class NhisSpecialtyAttendedAction extends BaseNhisSpecialtyAttendedAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisSpecialtyAttendedAction here] off begin
	// % protected region % [Add any additional class fields for NhisSpecialtyAttendedAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisSpecialtyAttendedModel>,
		// % protected region % [Add any additional constructor parameters for NhisSpecialtyAttendedAction here] off begin
		// % protected region % [Add any additional constructor parameters for NhisSpecialtyAttendedAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisSpecialtyAttendedAction here] off begin
			// % protected region % [Add any additional constructor arguments for NhisSpecialtyAttendedAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisSpecialtyAttendedAction here] off begin
		// % protected region % [Add any additional constructor logic for NhisSpecialtyAttendedAction here] end
	}

	// % protected region % [Add any additional class methods for NhisSpecialtyAttendedAction here] off begin
	// % protected region % [Add any additional class methods for NhisSpecialtyAttendedAction here] end
}

export class NhisSpecialtyAttendedActionOK extends BaseNhisSpecialtyAttendedAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisSpecialtyAttendedActionOK here] off begin
	// % protected region % [Add any additional class fields for NhisSpecialtyAttendedActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisSpecialtyAttendedModel>,
		// % protected region % [Add any additional constructor parameters for NhisSpecialtyAttendedActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NhisSpecialtyAttendedActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NhisSpecialtyAttendedModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisSpecialtyAttendedActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NhisSpecialtyAttendedActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisSpecialtyAttendedActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NhisSpecialtyAttendedActionOK here] end
	}

	// % protected region % [Add any additional class methods for NhisSpecialtyAttendedActionOK here] off begin
	// % protected region % [Add any additional class methods for NhisSpecialtyAttendedActionOK here] end
}

export class NhisSpecialtyAttendedActionFail extends BaseNhisSpecialtyAttendedAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisSpecialtyAttendedActionFail here] off begin
	// % protected region % [Add any additional class fields for NhisSpecialtyAttendedActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NhisSpecialtyAttendedModel>,
		// % protected region % [Add any additional constructor parameters for NhisSpecialtyAttendedActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NhisSpecialtyAttendedActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisSpecialtyAttendedActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NhisSpecialtyAttendedActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisSpecialtyAttendedActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NhisSpecialtyAttendedActionFail here] end
	}

	// % protected region % [Add any additional class methods for NhisSpecialtyAttendedActionFail here] off begin
	// % protected region % [Add any additional class methods for NhisSpecialtyAttendedActionFail here] end
}

export function isNhisSpecialtyAttendedModelAction(e: any): e is BaseNhisSpecialtyAttendedAction {
	return Object.values(NhisSpecialtyAttendedModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
