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
import {HospitalBranchInformationModel} from './hospital_branch_information.model';
import {HospitalBranchInformationModelAudit} from './hospital_branch_information.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Hospital Branch Information model actions to be dispatched by NgRx.
 */
export enum HospitalBranchInformationModelActionTypes {
	CREATE_HOSPITAL_BRANCH_INFORMATION = '[ENTITY] Create HospitalBranchInformationModel',
	CREATE_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Create HospitalBranchInformationModel successfully',
	CREATE_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Create HospitalBranchInformationModel failed',

	CREATE_ALL_HOSPITAL_BRANCH_INFORMATION = '[ENTITY] Create All HospitalBranchInformationModel',
	CREATE_ALL_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Create All HospitalBranchInformationModel successfully',
	CREATE_ALL_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Create All HospitalBranchInformationModel failed',

	DELETE_HOSPITAL_BRANCH_INFORMATION = '[ENTITY] Delete HospitalBranchInformationModel',
	DELETE_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Delete HospitalBranchInformationModel successfully',
	DELETE_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Delete HospitalBranchInformationModel failed',


	DELETE_HOSPITAL_BRANCH_INFORMATION_EXCLUDING_IDS = '[ENTITY] Delete HospitalBranchInformationModels Excluding Ids',
	DELETE_HOSPITAL_BRANCH_INFORMATION_EXCLUDING_IDS_OK = '[ENTITY] Delete HospitalBranchInformationModels Excluding Ids successfully',
	DELETE_HOSPITAL_BRANCH_INFORMATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete HospitalBranchInformationModels Excluding Ids failed',

	DELETE_ALL_HOSPITAL_BRANCH_INFORMATION = '[ENTITY] Delete all HospitalBranchInformationModels',
	DELETE_ALL_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Delete all HospitalBranchInformationModels successfully',
	DELETE_ALL_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Delete all HospitalBranchInformationModels failed',

	UPDATE_HOSPITAL_BRANCH_INFORMATION = '[ENTITY] Update HospitalBranchInformationModel',
	UPDATE_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Update HospitalBranchInformationModel successfully',
	UPDATE_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Update HospitalBranchInformationModel failed',

	UPDATE_ALL_HOSPITAL_BRANCH_INFORMATION = '[ENTITY] Update all HospitalBranchInformationModel',
	UPDATE_ALL_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Update all HospitalBranchInformationModel successfully',
	UPDATE_ALL_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Update all HospitalBranchInformationModel failed',

	FETCH_HOSPITAL_BRANCH_INFORMATION= '[ENTITY] Fetch HospitalBranchInformationModel',
	FETCH_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Fetch HospitalBranchInformationModel successfully',
	FETCH_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Fetch HospitalBranchInformationModel failed',

	FETCH_HOSPITAL_BRANCH_INFORMATION_AUDIT= '[ENTITY] Fetch HospitalBranchInformationModel audit',
	FETCH_HOSPITAL_BRANCH_INFORMATION_AUDIT_OK = '[ENTITY] Fetch HospitalBranchInformationModel audit successfully',
	FETCH_HOSPITAL_BRANCH_INFORMATION_AUDIT_FAIL = '[ENTITY] Fetch HospitalBranchInformationModel audit failed',

	FETCH_HOSPITAL_BRANCH_INFORMATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch HospitalBranchInformationModel audits by entity id',
	FETCH_HOSPITAL_BRANCH_INFORMATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch HospitalBranchInformationModel audits by entity id successfully',
	FETCH_HOSPITAL_BRANCH_INFORMATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch HospitalBranchInformationModel audits by entity id failed',

	FETCH_ALL_HOSPITAL_BRANCH_INFORMATION = '[ENTITY] Fetch all HospitalBranchInformationModel',
	FETCH_ALL_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Fetch all HospitalBranchInformationModel successfully',
	FETCH_ALL_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Fetch all HospitalBranchInformationModel failed',

	FETCH_HOSPITAL_BRANCH_INFORMATION_WITH_QUERY = '[ENTITY] Fetch HospitalBranchInformationModel with query',
	FETCH_HOSPITAL_BRANCH_INFORMATION_WITH_QUERY_OK = '[ENTITY] Fetch HospitalBranchInformationModel with query successfully',
	FETCH_HOSPITAL_BRANCH_INFORMATION_WITH_QUERY_FAIL = '[ENTITY] Fetch HospitalBranchInformationModel with query failed',

	FETCH_LAST_HOSPITAL_BRANCH_INFORMATION_WITH_QUERY = '[ENTITY] Fetch last HospitalBranchInformationModel with query',
	FETCH_LAST_HOSPITAL_BRANCH_INFORMATION_WITH_QUERY_OK = '[ENTITY] Fetch last HospitalBranchInformationModel with query successfully',
	FETCH_LAST_HOSPITAL_BRANCH_INFORMATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last HospitalBranchInformationModel with query failed',

	EXPORT_HOSPITAL_BRANCH_INFORMATION = '[ENTITY] Export HospitalBranchInformationModel',
	EXPORT_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Export HospitalBranchInformationModel successfully',
	EXPORT_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Export HospitalBranchInformationModel failed',

	EXPORT_ALL_HOSPITAL_BRANCH_INFORMATION = '[ENTITY] Export All HospitalBranchInformationModels',
	EXPORT_ALL_HOSPITAL_BRANCH_INFORMATION_OK = '[ENTITY] Export All HospitalBranchInformationModels successfully',
	EXPORT_ALL_HOSPITAL_BRANCH_INFORMATION_FAIL = '[ENTITY] Export All HospitalBranchInformationModels failed',

	EXPORT_HOSPITAL_BRANCH_INFORMATION_EXCLUDING_IDS = '[ENTITY] Export HospitalBranchInformationModels excluding Ids',
	EXPORT_HOSPITAL_BRANCH_INFORMATION_EXCLUDING_IDS_OK = '[ENTITY] Export HospitalBranchInformationModel excluding Ids successfully',
	EXPORT_HOSPITAL_BRANCH_INFORMATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export HospitalBranchInformationModel excluding Ids failed',

	COUNT_HOSPITAL_BRANCH_INFORMATIONS = '[ENTITY] Fetch number of HospitalBranchInformationModel records',
	COUNT_HOSPITAL_BRANCH_INFORMATIONS_OK = '[ENTITY] Fetch number of HospitalBranchInformationModel records successfully ',
	COUNT_HOSPITAL_BRANCH_INFORMATIONS_FAIL = '[ENTITY] Fetch number of HospitalBranchInformationModel records failed',

	IMPORT_HOSPITAL_BRANCH_INFORMATIONS = '[ENTITY] Import HospitalBranchInformationModels',
	IMPORT_HOSPITAL_BRANCH_INFORMATIONS_OK = '[ENTITY] Import HospitalBranchInformationModels successfully',
	IMPORT_HOSPITAL_BRANCH_INFORMATIONS_FAIL = '[ENTITY] Import HospitalBranchInformationModels fail',


	INITIALISE_HOSPITAL_BRANCH_INFORMATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of HospitalBranchInformationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseHospitalBranchInformationAction implements Action {
	readonly className: string = 'HospitalBranchInformationModel';

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

export class HospitalBranchInformationAction extends BaseHospitalBranchInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HospitalBranchInformationAction here] off begin
	// % protected region % [Add any additional class fields for HospitalBranchInformationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HospitalBranchInformationModel>,
		// % protected region % [Add any additional constructor parameters for HospitalBranchInformationAction here] off begin
		// % protected region % [Add any additional constructor parameters for HospitalBranchInformationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HospitalBranchInformationAction here] off begin
			// % protected region % [Add any additional constructor arguments for HospitalBranchInformationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HospitalBranchInformationAction here] off begin
		// % protected region % [Add any additional constructor logic for HospitalBranchInformationAction here] end
	}

	// % protected region % [Add any additional class methods for HospitalBranchInformationAction here] off begin
	// % protected region % [Add any additional class methods for HospitalBranchInformationAction here] end
}

export class HospitalBranchInformationActionOK extends BaseHospitalBranchInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HospitalBranchInformationActionOK here] off begin
	// % protected region % [Add any additional class fields for HospitalBranchInformationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<HospitalBranchInformationModel>,
		// % protected region % [Add any additional constructor parameters for HospitalBranchInformationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for HospitalBranchInformationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: HospitalBranchInformationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HospitalBranchInformationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for HospitalBranchInformationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HospitalBranchInformationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for HospitalBranchInformationActionOK here] end
	}

	// % protected region % [Add any additional class methods for HospitalBranchInformationActionOK here] off begin
	// % protected region % [Add any additional class methods for HospitalBranchInformationActionOK here] end
}

export class HospitalBranchInformationActionFail extends BaseHospitalBranchInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for HospitalBranchInformationActionFail here] off begin
	// % protected region % [Add any additional class fields for HospitalBranchInformationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<HospitalBranchInformationModel>,
		// % protected region % [Add any additional constructor parameters for HospitalBranchInformationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for HospitalBranchInformationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for HospitalBranchInformationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for HospitalBranchInformationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for HospitalBranchInformationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for HospitalBranchInformationActionFail here] end
	}

	// % protected region % [Add any additional class methods for HospitalBranchInformationActionFail here] off begin
	// % protected region % [Add any additional class methods for HospitalBranchInformationActionFail here] end
}

export function isHospitalBranchInformationModelAction(e: any): e is BaseHospitalBranchInformationAction {
	return Object.values(HospitalBranchInformationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
