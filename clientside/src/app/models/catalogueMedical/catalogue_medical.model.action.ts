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
import {CatalogueMedicalModel} from './catalogue_medical.model';
import {CatalogueMedicalModelAudit} from './catalogue_medical.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Catalogue Medical  model actions to be dispatched by NgRx.
 */
export enum CatalogueMedicalModelActionTypes {
	CREATE_CATALOGUE_MEDICAL = '[ENTITY] Create CatalogueMedicalModel',
	CREATE_CATALOGUE_MEDICAL_OK = '[ENTITY] Create CatalogueMedicalModel successfully',
	CREATE_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Create CatalogueMedicalModel failed',

	CREATE_ALL_CATALOGUE_MEDICAL = '[ENTITY] Create All CatalogueMedicalModel',
	CREATE_ALL_CATALOGUE_MEDICAL_OK = '[ENTITY] Create All CatalogueMedicalModel successfully',
	CREATE_ALL_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Create All CatalogueMedicalModel failed',

	DELETE_CATALOGUE_MEDICAL = '[ENTITY] Delete CatalogueMedicalModel',
	DELETE_CATALOGUE_MEDICAL_OK = '[ENTITY] Delete CatalogueMedicalModel successfully',
	DELETE_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Delete CatalogueMedicalModel failed',


	DELETE_CATALOGUE_MEDICAL_EXCLUDING_IDS = '[ENTITY] Delete CatalogueMedicalModels Excluding Ids',
	DELETE_CATALOGUE_MEDICAL_EXCLUDING_IDS_OK = '[ENTITY] Delete CatalogueMedicalModels Excluding Ids successfully',
	DELETE_CATALOGUE_MEDICAL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CatalogueMedicalModels Excluding Ids failed',

	DELETE_ALL_CATALOGUE_MEDICAL = '[ENTITY] Delete all CatalogueMedicalModels',
	DELETE_ALL_CATALOGUE_MEDICAL_OK = '[ENTITY] Delete all CatalogueMedicalModels successfully',
	DELETE_ALL_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Delete all CatalogueMedicalModels failed',

	UPDATE_CATALOGUE_MEDICAL = '[ENTITY] Update CatalogueMedicalModel',
	UPDATE_CATALOGUE_MEDICAL_OK = '[ENTITY] Update CatalogueMedicalModel successfully',
	UPDATE_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Update CatalogueMedicalModel failed',

	UPDATE_ALL_CATALOGUE_MEDICAL = '[ENTITY] Update all CatalogueMedicalModel',
	UPDATE_ALL_CATALOGUE_MEDICAL_OK = '[ENTITY] Update all CatalogueMedicalModel successfully',
	UPDATE_ALL_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Update all CatalogueMedicalModel failed',

	FETCH_CATALOGUE_MEDICAL= '[ENTITY] Fetch CatalogueMedicalModel',
	FETCH_CATALOGUE_MEDICAL_OK = '[ENTITY] Fetch CatalogueMedicalModel successfully',
	FETCH_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Fetch CatalogueMedicalModel failed',

	FETCH_CATALOGUE_MEDICAL_AUDIT= '[ENTITY] Fetch CatalogueMedicalModel audit',
	FETCH_CATALOGUE_MEDICAL_AUDIT_OK = '[ENTITY] Fetch CatalogueMedicalModel audit successfully',
	FETCH_CATALOGUE_MEDICAL_AUDIT_FAIL = '[ENTITY] Fetch CatalogueMedicalModel audit failed',

	FETCH_CATALOGUE_MEDICAL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CatalogueMedicalModel audits by entity id',
	FETCH_CATALOGUE_MEDICAL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CatalogueMedicalModel audits by entity id successfully',
	FETCH_CATALOGUE_MEDICAL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CatalogueMedicalModel audits by entity id failed',

	FETCH_ALL_CATALOGUE_MEDICAL = '[ENTITY] Fetch all CatalogueMedicalModel',
	FETCH_ALL_CATALOGUE_MEDICAL_OK = '[ENTITY] Fetch all CatalogueMedicalModel successfully',
	FETCH_ALL_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Fetch all CatalogueMedicalModel failed',

	FETCH_CATALOGUE_MEDICAL_WITH_QUERY = '[ENTITY] Fetch CatalogueMedicalModel with query',
	FETCH_CATALOGUE_MEDICAL_WITH_QUERY_OK = '[ENTITY] Fetch CatalogueMedicalModel with query successfully',
	FETCH_CATALOGUE_MEDICAL_WITH_QUERY_FAIL = '[ENTITY] Fetch CatalogueMedicalModel with query failed',

	FETCH_LAST_CATALOGUE_MEDICAL_WITH_QUERY = '[ENTITY] Fetch last CatalogueMedicalModel with query',
	FETCH_LAST_CATALOGUE_MEDICAL_WITH_QUERY_OK = '[ENTITY] Fetch last CatalogueMedicalModel with query successfully',
	FETCH_LAST_CATALOGUE_MEDICAL_WITH_QUERY_FAIL = '[ENTITY] Fetch last CatalogueMedicalModel with query failed',

	EXPORT_CATALOGUE_MEDICAL = '[ENTITY] Export CatalogueMedicalModel',
	EXPORT_CATALOGUE_MEDICAL_OK = '[ENTITY] Export CatalogueMedicalModel successfully',
	EXPORT_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Export CatalogueMedicalModel failed',

	EXPORT_ALL_CATALOGUE_MEDICAL = '[ENTITY] Export All CatalogueMedicalModels',
	EXPORT_ALL_CATALOGUE_MEDICAL_OK = '[ENTITY] Export All CatalogueMedicalModels successfully',
	EXPORT_ALL_CATALOGUE_MEDICAL_FAIL = '[ENTITY] Export All CatalogueMedicalModels failed',

	EXPORT_CATALOGUE_MEDICAL_EXCLUDING_IDS = '[ENTITY] Export CatalogueMedicalModels excluding Ids',
	EXPORT_CATALOGUE_MEDICAL_EXCLUDING_IDS_OK = '[ENTITY] Export CatalogueMedicalModel excluding Ids successfully',
	EXPORT_CATALOGUE_MEDICAL_EXCLUDING_IDS_FAIL = '[ENTITY] Export CatalogueMedicalModel excluding Ids failed',

	COUNT_CATALOGUE_MEDICALS = '[ENTITY] Fetch number of CatalogueMedicalModel records',
	COUNT_CATALOGUE_MEDICALS_OK = '[ENTITY] Fetch number of CatalogueMedicalModel records successfully ',
	COUNT_CATALOGUE_MEDICALS_FAIL = '[ENTITY] Fetch number of CatalogueMedicalModel records failed',

	IMPORT_CATALOGUE_MEDICALS = '[ENTITY] Import CatalogueMedicalModels',
	IMPORT_CATALOGUE_MEDICALS_OK = '[ENTITY] Import CatalogueMedicalModels successfully',
	IMPORT_CATALOGUE_MEDICALS_FAIL = '[ENTITY] Import CatalogueMedicalModels fail',


	INITIALISE_CATALOGUE_MEDICAL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CatalogueMedicalModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCatalogueMedicalAction implements Action {
	readonly className: string = 'CatalogueMedicalModel';

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

export class CatalogueMedicalAction extends BaseCatalogueMedicalAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CatalogueMedicalAction here] off begin
	// % protected region % [Add any additional class fields for CatalogueMedicalAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CatalogueMedicalModel>,
		// % protected region % [Add any additional constructor parameters for CatalogueMedicalAction here] off begin
		// % protected region % [Add any additional constructor parameters for CatalogueMedicalAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CatalogueMedicalAction here] off begin
			// % protected region % [Add any additional constructor arguments for CatalogueMedicalAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CatalogueMedicalAction here] off begin
		// % protected region % [Add any additional constructor logic for CatalogueMedicalAction here] end
	}

	// % protected region % [Add any additional class methods for CatalogueMedicalAction here] off begin
	// % protected region % [Add any additional class methods for CatalogueMedicalAction here] end
}

export class CatalogueMedicalActionOK extends BaseCatalogueMedicalAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CatalogueMedicalActionOK here] off begin
	// % protected region % [Add any additional class fields for CatalogueMedicalActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CatalogueMedicalModel>,
		// % protected region % [Add any additional constructor parameters for CatalogueMedicalActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CatalogueMedicalActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CatalogueMedicalModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CatalogueMedicalActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CatalogueMedicalActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CatalogueMedicalActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CatalogueMedicalActionOK here] end
	}

	// % protected region % [Add any additional class methods for CatalogueMedicalActionOK here] off begin
	// % protected region % [Add any additional class methods for CatalogueMedicalActionOK here] end
}

export class CatalogueMedicalActionFail extends BaseCatalogueMedicalAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CatalogueMedicalActionFail here] off begin
	// % protected region % [Add any additional class fields for CatalogueMedicalActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CatalogueMedicalModel>,
		// % protected region % [Add any additional constructor parameters for CatalogueMedicalActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CatalogueMedicalActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CatalogueMedicalActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CatalogueMedicalActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CatalogueMedicalActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CatalogueMedicalActionFail here] end
	}

	// % protected region % [Add any additional class methods for CatalogueMedicalActionFail here] off begin
	// % protected region % [Add any additional class methods for CatalogueMedicalActionFail here] end
}

export function isCatalogueMedicalModelAction(e: any): e is BaseCatalogueMedicalAction {
	return Object.values(CatalogueMedicalModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
