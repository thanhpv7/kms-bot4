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
import {NhisInvestigationModel} from './nhis_investigation.model';
import {NhisInvestigationModelAudit} from './nhis_investigation.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of NHIS Investigation model actions to be dispatched by NgRx.
 */
export enum NhisInvestigationModelActionTypes {
	CREATE_NHIS_INVESTIGATION = '[ENTITY] Create NhisInvestigationModel',
	CREATE_NHIS_INVESTIGATION_OK = '[ENTITY] Create NhisInvestigationModel successfully',
	CREATE_NHIS_INVESTIGATION_FAIL = '[ENTITY] Create NhisInvestigationModel failed',

	CREATE_ALL_NHIS_INVESTIGATION = '[ENTITY] Create All NhisInvestigationModel',
	CREATE_ALL_NHIS_INVESTIGATION_OK = '[ENTITY] Create All NhisInvestigationModel successfully',
	CREATE_ALL_NHIS_INVESTIGATION_FAIL = '[ENTITY] Create All NhisInvestigationModel failed',

	DELETE_NHIS_INVESTIGATION = '[ENTITY] Delete NhisInvestigationModel',
	DELETE_NHIS_INVESTIGATION_OK = '[ENTITY] Delete NhisInvestigationModel successfully',
	DELETE_NHIS_INVESTIGATION_FAIL = '[ENTITY] Delete NhisInvestigationModel failed',


	DELETE_NHIS_INVESTIGATION_EXCLUDING_IDS = '[ENTITY] Delete NhisInvestigationModels Excluding Ids',
	DELETE_NHIS_INVESTIGATION_EXCLUDING_IDS_OK = '[ENTITY] Delete NhisInvestigationModels Excluding Ids successfully',
	DELETE_NHIS_INVESTIGATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NhisInvestigationModels Excluding Ids failed',

	DELETE_ALL_NHIS_INVESTIGATION = '[ENTITY] Delete all NhisInvestigationModels',
	DELETE_ALL_NHIS_INVESTIGATION_OK = '[ENTITY] Delete all NhisInvestigationModels successfully',
	DELETE_ALL_NHIS_INVESTIGATION_FAIL = '[ENTITY] Delete all NhisInvestigationModels failed',

	UPDATE_NHIS_INVESTIGATION = '[ENTITY] Update NhisInvestigationModel',
	UPDATE_NHIS_INVESTIGATION_OK = '[ENTITY] Update NhisInvestigationModel successfully',
	UPDATE_NHIS_INVESTIGATION_FAIL = '[ENTITY] Update NhisInvestigationModel failed',

	UPDATE_ALL_NHIS_INVESTIGATION = '[ENTITY] Update all NhisInvestigationModel',
	UPDATE_ALL_NHIS_INVESTIGATION_OK = '[ENTITY] Update all NhisInvestigationModel successfully',
	UPDATE_ALL_NHIS_INVESTIGATION_FAIL = '[ENTITY] Update all NhisInvestigationModel failed',

	FETCH_NHIS_INVESTIGATION= '[ENTITY] Fetch NhisInvestigationModel',
	FETCH_NHIS_INVESTIGATION_OK = '[ENTITY] Fetch NhisInvestigationModel successfully',
	FETCH_NHIS_INVESTIGATION_FAIL = '[ENTITY] Fetch NhisInvestigationModel failed',

	FETCH_NHIS_INVESTIGATION_AUDIT= '[ENTITY] Fetch NhisInvestigationModel audit',
	FETCH_NHIS_INVESTIGATION_AUDIT_OK = '[ENTITY] Fetch NhisInvestigationModel audit successfully',
	FETCH_NHIS_INVESTIGATION_AUDIT_FAIL = '[ENTITY] Fetch NhisInvestigationModel audit failed',

	FETCH_NHIS_INVESTIGATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NhisInvestigationModel audits by entity id',
	FETCH_NHIS_INVESTIGATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NhisInvestigationModel audits by entity id successfully',
	FETCH_NHIS_INVESTIGATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NhisInvestigationModel audits by entity id failed',

	FETCH_ALL_NHIS_INVESTIGATION = '[ENTITY] Fetch all NhisInvestigationModel',
	FETCH_ALL_NHIS_INVESTIGATION_OK = '[ENTITY] Fetch all NhisInvestigationModel successfully',
	FETCH_ALL_NHIS_INVESTIGATION_FAIL = '[ENTITY] Fetch all NhisInvestigationModel failed',

	FETCH_NHIS_INVESTIGATION_WITH_QUERY = '[ENTITY] Fetch NhisInvestigationModel with query',
	FETCH_NHIS_INVESTIGATION_WITH_QUERY_OK = '[ENTITY] Fetch NhisInvestigationModel with query successfully',
	FETCH_NHIS_INVESTIGATION_WITH_QUERY_FAIL = '[ENTITY] Fetch NhisInvestigationModel with query failed',

	FETCH_LAST_NHIS_INVESTIGATION_WITH_QUERY = '[ENTITY] Fetch last NhisInvestigationModel with query',
	FETCH_LAST_NHIS_INVESTIGATION_WITH_QUERY_OK = '[ENTITY] Fetch last NhisInvestigationModel with query successfully',
	FETCH_LAST_NHIS_INVESTIGATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last NhisInvestigationModel with query failed',

	EXPORT_NHIS_INVESTIGATION = '[ENTITY] Export NhisInvestigationModel',
	EXPORT_NHIS_INVESTIGATION_OK = '[ENTITY] Export NhisInvestigationModel successfully',
	EXPORT_NHIS_INVESTIGATION_FAIL = '[ENTITY] Export NhisInvestigationModel failed',

	EXPORT_ALL_NHIS_INVESTIGATION = '[ENTITY] Export All NhisInvestigationModels',
	EXPORT_ALL_NHIS_INVESTIGATION_OK = '[ENTITY] Export All NhisInvestigationModels successfully',
	EXPORT_ALL_NHIS_INVESTIGATION_FAIL = '[ENTITY] Export All NhisInvestigationModels failed',

	EXPORT_NHIS_INVESTIGATION_EXCLUDING_IDS = '[ENTITY] Export NhisInvestigationModels excluding Ids',
	EXPORT_NHIS_INVESTIGATION_EXCLUDING_IDS_OK = '[ENTITY] Export NhisInvestigationModel excluding Ids successfully',
	EXPORT_NHIS_INVESTIGATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export NhisInvestigationModel excluding Ids failed',

	COUNT_NHIS_INVESTIGATIONS = '[ENTITY] Fetch number of NhisInvestigationModel records',
	COUNT_NHIS_INVESTIGATIONS_OK = '[ENTITY] Fetch number of NhisInvestigationModel records successfully ',
	COUNT_NHIS_INVESTIGATIONS_FAIL = '[ENTITY] Fetch number of NhisInvestigationModel records failed',

	IMPORT_NHIS_INVESTIGATIONS = '[ENTITY] Import NhisInvestigationModels',
	IMPORT_NHIS_INVESTIGATIONS_OK = '[ENTITY] Import NhisInvestigationModels successfully',
	IMPORT_NHIS_INVESTIGATIONS_FAIL = '[ENTITY] Import NhisInvestigationModels fail',


	INITIALISE_NHIS_INVESTIGATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NhisInvestigationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNhisInvestigationAction implements Action {
	readonly className: string = 'NhisInvestigationModel';

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

export class NhisInvestigationAction extends BaseNhisInvestigationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisInvestigationAction here] off begin
	// % protected region % [Add any additional class fields for NhisInvestigationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisInvestigationModel>,
		// % protected region % [Add any additional constructor parameters for NhisInvestigationAction here] off begin
		// % protected region % [Add any additional constructor parameters for NhisInvestigationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisInvestigationAction here] off begin
			// % protected region % [Add any additional constructor arguments for NhisInvestigationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisInvestigationAction here] off begin
		// % protected region % [Add any additional constructor logic for NhisInvestigationAction here] end
	}

	// % protected region % [Add any additional class methods for NhisInvestigationAction here] off begin
	// % protected region % [Add any additional class methods for NhisInvestigationAction here] end
}

export class NhisInvestigationActionOK extends BaseNhisInvestigationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisInvestigationActionOK here] off begin
	// % protected region % [Add any additional class fields for NhisInvestigationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisInvestigationModel>,
		// % protected region % [Add any additional constructor parameters for NhisInvestigationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NhisInvestigationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NhisInvestigationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisInvestigationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NhisInvestigationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisInvestigationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NhisInvestigationActionOK here] end
	}

	// % protected region % [Add any additional class methods for NhisInvestigationActionOK here] off begin
	// % protected region % [Add any additional class methods for NhisInvestigationActionOK here] end
}

export class NhisInvestigationActionFail extends BaseNhisInvestigationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisInvestigationActionFail here] off begin
	// % protected region % [Add any additional class fields for NhisInvestigationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NhisInvestigationModel>,
		// % protected region % [Add any additional constructor parameters for NhisInvestigationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NhisInvestigationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisInvestigationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NhisInvestigationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisInvestigationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NhisInvestigationActionFail here] end
	}

	// % protected region % [Add any additional class methods for NhisInvestigationActionFail here] off begin
	// % protected region % [Add any additional class methods for NhisInvestigationActionFail here] end
}

export function isNhisInvestigationModelAction(e: any): e is BaseNhisInvestigationAction {
	return Object.values(NhisInvestigationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
