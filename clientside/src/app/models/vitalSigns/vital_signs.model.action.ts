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
import {VitalSignsModel} from './vital_signs.model';
import {VitalSignsModelAudit} from './vital_signs.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Vital Signs model actions to be dispatched by NgRx.
 */
export enum VitalSignsModelActionTypes {
	CREATE_VITAL_SIGNS = '[ENTITY] Create VitalSignsModel',
	CREATE_VITAL_SIGNS_OK = '[ENTITY] Create VitalSignsModel successfully',
	CREATE_VITAL_SIGNS_FAIL = '[ENTITY] Create VitalSignsModel failed',

	CREATE_ALL_VITAL_SIGNS = '[ENTITY] Create All VitalSignsModel',
	CREATE_ALL_VITAL_SIGNS_OK = '[ENTITY] Create All VitalSignsModel successfully',
	CREATE_ALL_VITAL_SIGNS_FAIL = '[ENTITY] Create All VitalSignsModel failed',

	DELETE_VITAL_SIGNS = '[ENTITY] Delete VitalSignsModel',
	DELETE_VITAL_SIGNS_OK = '[ENTITY] Delete VitalSignsModel successfully',
	DELETE_VITAL_SIGNS_FAIL = '[ENTITY] Delete VitalSignsModel failed',


	DELETE_VITAL_SIGNS_EXCLUDING_IDS = '[ENTITY] Delete VitalSignsModels Excluding Ids',
	DELETE_VITAL_SIGNS_EXCLUDING_IDS_OK = '[ENTITY] Delete VitalSignsModels Excluding Ids successfully',
	DELETE_VITAL_SIGNS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete VitalSignsModels Excluding Ids failed',

	DELETE_ALL_VITAL_SIGNS = '[ENTITY] Delete all VitalSignsModels',
	DELETE_ALL_VITAL_SIGNS_OK = '[ENTITY] Delete all VitalSignsModels successfully',
	DELETE_ALL_VITAL_SIGNS_FAIL = '[ENTITY] Delete all VitalSignsModels failed',

	UPDATE_VITAL_SIGNS = '[ENTITY] Update VitalSignsModel',
	UPDATE_VITAL_SIGNS_OK = '[ENTITY] Update VitalSignsModel successfully',
	UPDATE_VITAL_SIGNS_FAIL = '[ENTITY] Update VitalSignsModel failed',

	UPDATE_ALL_VITAL_SIGNS = '[ENTITY] Update all VitalSignsModel',
	UPDATE_ALL_VITAL_SIGNS_OK = '[ENTITY] Update all VitalSignsModel successfully',
	UPDATE_ALL_VITAL_SIGNS_FAIL = '[ENTITY] Update all VitalSignsModel failed',

	FETCH_VITAL_SIGNS= '[ENTITY] Fetch VitalSignsModel',
	FETCH_VITAL_SIGNS_OK = '[ENTITY] Fetch VitalSignsModel successfully',
	FETCH_VITAL_SIGNS_FAIL = '[ENTITY] Fetch VitalSignsModel failed',

	FETCH_VITAL_SIGNS_AUDIT= '[ENTITY] Fetch VitalSignsModel audit',
	FETCH_VITAL_SIGNS_AUDIT_OK = '[ENTITY] Fetch VitalSignsModel audit successfully',
	FETCH_VITAL_SIGNS_AUDIT_FAIL = '[ENTITY] Fetch VitalSignsModel audit failed',

	FETCH_VITAL_SIGNS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch VitalSignsModel audits by entity id',
	FETCH_VITAL_SIGNS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch VitalSignsModel audits by entity id successfully',
	FETCH_VITAL_SIGNS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch VitalSignsModel audits by entity id failed',

	FETCH_ALL_VITAL_SIGNS = '[ENTITY] Fetch all VitalSignsModel',
	FETCH_ALL_VITAL_SIGNS_OK = '[ENTITY] Fetch all VitalSignsModel successfully',
	FETCH_ALL_VITAL_SIGNS_FAIL = '[ENTITY] Fetch all VitalSignsModel failed',

	FETCH_VITAL_SIGNS_WITH_QUERY = '[ENTITY] Fetch VitalSignsModel with query',
	FETCH_VITAL_SIGNS_WITH_QUERY_OK = '[ENTITY] Fetch VitalSignsModel with query successfully',
	FETCH_VITAL_SIGNS_WITH_QUERY_FAIL = '[ENTITY] Fetch VitalSignsModel with query failed',

	FETCH_LAST_VITAL_SIGNS_WITH_QUERY = '[ENTITY] Fetch last VitalSignsModel with query',
	FETCH_LAST_VITAL_SIGNS_WITH_QUERY_OK = '[ENTITY] Fetch last VitalSignsModel with query successfully',
	FETCH_LAST_VITAL_SIGNS_WITH_QUERY_FAIL = '[ENTITY] Fetch last VitalSignsModel with query failed',

	EXPORT_VITAL_SIGNS = '[ENTITY] Export VitalSignsModel',
	EXPORT_VITAL_SIGNS_OK = '[ENTITY] Export VitalSignsModel successfully',
	EXPORT_VITAL_SIGNS_FAIL = '[ENTITY] Export VitalSignsModel failed',

	EXPORT_ALL_VITAL_SIGNS = '[ENTITY] Export All VitalSignsModels',
	EXPORT_ALL_VITAL_SIGNS_OK = '[ENTITY] Export All VitalSignsModels successfully',
	EXPORT_ALL_VITAL_SIGNS_FAIL = '[ENTITY] Export All VitalSignsModels failed',

	EXPORT_VITAL_SIGNS_EXCLUDING_IDS = '[ENTITY] Export VitalSignsModels excluding Ids',
	EXPORT_VITAL_SIGNS_EXCLUDING_IDS_OK = '[ENTITY] Export VitalSignsModel excluding Ids successfully',
	EXPORT_VITAL_SIGNS_EXCLUDING_IDS_FAIL = '[ENTITY] Export VitalSignsModel excluding Ids failed',

	COUNT_VITAL_SIGNSS = '[ENTITY] Fetch number of VitalSignsModel records',
	COUNT_VITAL_SIGNSS_OK = '[ENTITY] Fetch number of VitalSignsModel records successfully ',
	COUNT_VITAL_SIGNSS_FAIL = '[ENTITY] Fetch number of VitalSignsModel records failed',

	IMPORT_VITAL_SIGNSS = '[ENTITY] Import VitalSignsModels',
	IMPORT_VITAL_SIGNSS_OK = '[ENTITY] Import VitalSignsModels successfully',
	IMPORT_VITAL_SIGNSS_FAIL = '[ENTITY] Import VitalSignsModels fail',


	INITIALISE_VITAL_SIGNS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of VitalSignsModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseVitalSignsAction implements Action {
	readonly className: string = 'VitalSignsModel';

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

export class VitalSignsAction extends BaseVitalSignsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for VitalSignsAction here] off begin
	// % protected region % [Add any additional class fields for VitalSignsAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<VitalSignsModel>,
		// % protected region % [Add any additional constructor parameters for VitalSignsAction here] off begin
		// % protected region % [Add any additional constructor parameters for VitalSignsAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for VitalSignsAction here] off begin
			// % protected region % [Add any additional constructor arguments for VitalSignsAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for VitalSignsAction here] off begin
		// % protected region % [Add any additional constructor logic for VitalSignsAction here] end
	}

	// % protected region % [Add any additional class methods for VitalSignsAction here] off begin
	// % protected region % [Add any additional class methods for VitalSignsAction here] end
}

export class VitalSignsActionOK extends BaseVitalSignsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for VitalSignsActionOK here] off begin
	// % protected region % [Add any additional class fields for VitalSignsActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<VitalSignsModel>,
		// % protected region % [Add any additional constructor parameters for VitalSignsActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for VitalSignsActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: VitalSignsModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for VitalSignsActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for VitalSignsActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for VitalSignsActionOK here] off begin
		// % protected region % [Add any additional constructor logic for VitalSignsActionOK here] end
	}

	// % protected region % [Add any additional class methods for VitalSignsActionOK here] off begin
	// % protected region % [Add any additional class methods for VitalSignsActionOK here] end
}

export class VitalSignsActionFail extends BaseVitalSignsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for VitalSignsActionFail here] off begin
	// % protected region % [Add any additional class fields for VitalSignsActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<VitalSignsModel>,
		// % protected region % [Add any additional constructor parameters for VitalSignsActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for VitalSignsActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for VitalSignsActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for VitalSignsActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for VitalSignsActionFail here] off begin
		// % protected region % [Add any additional constructor logic for VitalSignsActionFail here] end
	}

	// % protected region % [Add any additional class methods for VitalSignsActionFail here] off begin
	// % protected region % [Add any additional class methods for VitalSignsActionFail here] end
}

export function isVitalSignsModelAction(e: any): e is BaseVitalSignsAction {
	return Object.values(VitalSignsModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
