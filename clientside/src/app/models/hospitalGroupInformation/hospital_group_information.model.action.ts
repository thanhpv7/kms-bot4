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
import {HospitalGroupInformationModel} from './hospital_group_information.model';
import {HospitalGroupInformationModelAudit} from './hospital_group_information.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Hospital Group Information model actions to be dispatched by NgRx.
 */
export enum HospitalGroupInformationModelActionTypes {
	CREATE_HOSPITAL_GROUP_INFORMATION = '[ENTITY] Create HospitalGroupInformationModel',
	CREATE_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Create HospitalGroupInformationModel successfully',
	CREATE_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Create HospitalGroupInformationModel failed',

	CREATE_ALL_HOSPITAL_GROUP_INFORMATION = '[ENTITY] Create All HospitalGroupInformationModel',
	CREATE_ALL_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Create All HospitalGroupInformationModel successfully',
	CREATE_ALL_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Create All HospitalGroupInformationModel failed',

	DELETE_HOSPITAL_GROUP_INFORMATION = '[ENTITY] Delete HospitalGroupInformationModel',
	DELETE_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Delete HospitalGroupInformationModel successfully',
	DELETE_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Delete HospitalGroupInformationModel failed',


	DELETE_HOSPITAL_GROUP_INFORMATION_EXCLUDING_IDS = '[ENTITY] Delete HospitalGroupInformationModels Excluding Ids',
	DELETE_HOSPITAL_GROUP_INFORMATION_EXCLUDING_IDS_OK = '[ENTITY] Delete HospitalGroupInformationModels Excluding Ids successfully',
	DELETE_HOSPITAL_GROUP_INFORMATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete HospitalGroupInformationModels Excluding Ids failed',

	DELETE_ALL_HOSPITAL_GROUP_INFORMATION = '[ENTITY] Delete all HospitalGroupInformationModels',
	DELETE_ALL_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Delete all HospitalGroupInformationModels successfully',
	DELETE_ALL_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Delete all HospitalGroupInformationModels failed',

	UPDATE_HOSPITAL_GROUP_INFORMATION = '[ENTITY] Update HospitalGroupInformationModel',
	UPDATE_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Update HospitalGroupInformationModel successfully',
	UPDATE_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Update HospitalGroupInformationModel failed',

	UPDATE_ALL_HOSPITAL_GROUP_INFORMATION = '[ENTITY] Update all HospitalGroupInformationModel',
	UPDATE_ALL_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Update all HospitalGroupInformationModel successfully',
	UPDATE_ALL_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Update all HospitalGroupInformationModel failed',

	FETCH_HOSPITAL_GROUP_INFORMATION= '[ENTITY] Fetch HospitalGroupInformationModel',
	FETCH_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Fetch HospitalGroupInformationModel successfully',
	FETCH_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Fetch HospitalGroupInformationModel failed',

	FETCH_HOSPITAL_GROUP_INFORMATION_AUDIT= '[ENTITY] Fetch HospitalGroupInformationModel audit',
	FETCH_HOSPITAL_GROUP_INFORMATION_AUDIT_OK = '[ENTITY] Fetch HospitalGroupInformationModel audit successfully',
	FETCH_HOSPITAL_GROUP_INFORMATION_AUDIT_FAIL = '[ENTITY] Fetch HospitalGroupInformationModel audit failed',

	FETCH_HOSPITAL_GROUP_INFORMATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch HospitalGroupInformationModel audits by entity id',
	FETCH_HOSPITAL_GROUP_INFORMATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch HospitalGroupInformationModel audits by entity id successfully',
	FETCH_HOSPITAL_GROUP_INFORMATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch HospitalGroupInformationModel audits by entity id failed',

	FETCH_ALL_HOSPITAL_GROUP_INFORMATION = '[ENTITY] Fetch all HospitalGroupInformationModel',
	FETCH_ALL_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Fetch all HospitalGroupInformationModel successfully',
	FETCH_ALL_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Fetch all HospitalGroupInformationModel failed',

	FETCH_HOSPITAL_GROUP_INFORMATION_WITH_QUERY = '[ENTITY] Fetch HospitalGroupInformationModel with query',
	FETCH_HOSPITAL_GROUP_INFORMATION_WITH_QUERY_OK = '[ENTITY] Fetch HospitalGroupInformationModel with query successfully',
	FETCH_HOSPITAL_GROUP_INFORMATION_WITH_QUERY_FAIL = '[ENTITY] Fetch HospitalGroupInformationModel with query failed',

	FETCH_LAST_HOSPITAL_GROUP_INFORMATION_WITH_QUERY = '[ENTITY] Fetch last HospitalGroupInformationModel with query',
	FETCH_LAST_HOSPITAL_GROUP_INFORMATION_WITH_QUERY_OK = '[ENTITY] Fetch last HospitalGroupInformationModel with query successfully',
	FETCH_LAST_HOSPITAL_GROUP_INFORMATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last HospitalGroupInformationModel with query failed',

	EXPORT_HOSPITAL_GROUP_INFORMATION = '[ENTITY] Export HospitalGroupInformationModel',
	EXPORT_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Export HospitalGroupInformationModel successfully',
	EXPORT_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Export HospitalGroupInformationModel failed',

	EXPORT_ALL_HOSPITAL_GROUP_INFORMATION = '[ENTITY] Export All HospitalGroupInformationModels',
	EXPORT_ALL_HOSPITAL_GROUP_INFORMATION_OK = '[ENTITY] Export All HospitalGroupInformationModels successfully',
	EXPORT_ALL_HOSPITAL_GROUP_INFORMATION_FAIL = '[ENTITY] Export All HospitalGroupInformationModels failed',

	EXPORT_HOSPITAL_GROUP_INFORMATION_EXCLUDING_IDS = '[ENTITY] Export HospitalGroupInformationModels excluding Ids',
	EXPORT_HOSPITAL_GROUP_INFORMATION_EXCLUDING_IDS_OK = '[ENTITY] Export HospitalGroupInformationModel excluding Ids successfully',
	EXPORT_HOSPITAL_GROUP_INFORMATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export HospitalGroupInformationModel excluding Ids failed',

	COUNT_HOSPITAL_GROUP_INFORMATIONS = '[ENTITY] Fetch number of HospitalGroupInformationModel records',
	COUNT_HOSPITAL_GROUP_INFORMATIONS_OK = '[ENTITY] Fetch number of HospitalGroupInformationModel records successfully ',
	COUNT_HOSPITAL_GROUP_INFORMATIONS_FAIL = '[ENTITY] Fetch number of HospitalGroupInformationModel records failed',

	IMPORT_HOSPITAL_GROUP_INFORMATIONS = '[ENTITY] Import HospitalGroupInformationModels',
	IMPORT_HOSPITAL_GROUP_INFORMATIONS_OK = '[ENTITY] Import HospitalGroupInformationModels successfully',
	IMPORT_HOSPITAL_GROUP_INFORMATIONS_FAIL = '[ENTITY] Import HospitalGroupInformationModels fail',


	INITIALISE_HOSPITAL_GROUP_INFORMATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of HospitalGroupInformationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseHospitalGroupInformationAction implements Action {
	readonly className: string = 'HospitalGroupInformationModel';

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

export class HospitalGroupInformationAction extends BaseHospitalGroupInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HospitalGroupInformationAction here] off begin
	// % protected region % [Add any additional class fields for HospitalGroupInformationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HospitalGroupInformationModel>,
		// % protected region % [Add any additional constructor parameters for HospitalGroupInformationAction here] off begin
		// % protected region % [Add any additional constructor parameters for HospitalGroupInformationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HospitalGroupInformationAction here] off begin
			// % protected region % [Add any additional constructor arguments for HospitalGroupInformationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HospitalGroupInformationAction here] off begin
		// % protected region % [Add any additional constructor logic for HospitalGroupInformationAction here] end
	}

	// % protected region % [Add any additional class methods for HospitalGroupInformationAction here] off begin
	// % protected region % [Add any additional class methods for HospitalGroupInformationAction here] end
}

export class HospitalGroupInformationActionOK extends BaseHospitalGroupInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HospitalGroupInformationActionOK here] off begin
	// % protected region % [Add any additional class fields for HospitalGroupInformationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HospitalGroupInformationModel>,
		// % protected region % [Add any additional constructor parameters for HospitalGroupInformationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for HospitalGroupInformationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: HospitalGroupInformationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HospitalGroupInformationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for HospitalGroupInformationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HospitalGroupInformationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for HospitalGroupInformationActionOK here] end
	}

	// % protected region % [Add any additional class methods for HospitalGroupInformationActionOK here] off begin
	// % protected region % [Add any additional class methods for HospitalGroupInformationActionOK here] end
}

export class HospitalGroupInformationActionFail extends BaseHospitalGroupInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HospitalGroupInformationActionFail here] off begin
	// % protected region % [Add any additional class fields for HospitalGroupInformationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<HospitalGroupInformationModel>,
		// % protected region % [Add any additional constructor parameters for HospitalGroupInformationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for HospitalGroupInformationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HospitalGroupInformationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for HospitalGroupInformationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HospitalGroupInformationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for HospitalGroupInformationActionFail here] end
	}

	// % protected region % [Add any additional class methods for HospitalGroupInformationActionFail here] off begin
	// % protected region % [Add any additional class methods for HospitalGroupInformationActionFail here] end
}

export function isHospitalGroupInformationModelAction(e: any): e is BaseHospitalGroupInformationAction {
	return Object.values(HospitalGroupInformationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
