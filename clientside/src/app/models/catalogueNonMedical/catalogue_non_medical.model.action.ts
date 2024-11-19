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
import {CatalogueNonMedicalModel} from './catalogue_non_medical.model';
import {CatalogueNonMedicalModelAudit} from './catalogue_non_medical.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Catalogue Non Medical model actions to be dispatched by NgRx.
 */
export enum CatalogueNonMedicalModelActionTypes {
	CREATE_CATALOGUE_NON_MEDICAL = '[ENTITY] Create CatalogueNonMedicalModel',
	CREATE_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Create CatalogueNonMedicalModel successfully',
	CREATE_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Create CatalogueNonMedicalModel failed',

	CREATE_ALL_CATALOGUE_NON_MEDICAL = '[ENTITY] Create All CatalogueNonMedicalModel',
	CREATE_ALL_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Create All CatalogueNonMedicalModel successfully',
	CREATE_ALL_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Create All CatalogueNonMedicalModel failed',

	DELETE_CATALOGUE_NON_MEDICAL = '[ENTITY] Delete CatalogueNonMedicalModel',
	DELETE_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Delete CatalogueNonMedicalModel successfully',
	DELETE_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Delete CatalogueNonMedicalModel failed',


	DELETE_CATALOGUE_NON_MEDICAL_EXCLUDING_IDS = '[ENTITY] Delete CatalogueNonMedicalModels Excluding Ids',
	DELETE_CATALOGUE_NON_MEDICAL_EXCLUDING_IDS_OK = '[ENTITY] Delete CatalogueNonMedicalModels Excluding Ids successfully',
	DELETE_CATALOGUE_NON_MEDICAL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CatalogueNonMedicalModels Excluding Ids failed',

	DELETE_ALL_CATALOGUE_NON_MEDICAL = '[ENTITY] Delete all CatalogueNonMedicalModels',
	DELETE_ALL_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Delete all CatalogueNonMedicalModels successfully',
	DELETE_ALL_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Delete all CatalogueNonMedicalModels failed',

	UPDATE_CATALOGUE_NON_MEDICAL = '[ENTITY] Update CatalogueNonMedicalModel',
	UPDATE_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Update CatalogueNonMedicalModel successfully',
	UPDATE_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Update CatalogueNonMedicalModel failed',

	UPDATE_ALL_CATALOGUE_NON_MEDICAL = '[ENTITY] Update all CatalogueNonMedicalModel',
	UPDATE_ALL_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Update all CatalogueNonMedicalModel successfully',
	UPDATE_ALL_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Update all CatalogueNonMedicalModel failed',

	FETCH_CATALOGUE_NON_MEDICAL= '[ENTITY] Fetch CatalogueNonMedicalModel',
	FETCH_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Fetch CatalogueNonMedicalModel successfully',
	FETCH_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Fetch CatalogueNonMedicalModel failed',

	FETCH_CATALOGUE_NON_MEDICAL_AUDIT= '[ENTITY] Fetch CatalogueNonMedicalModel audit',
	FETCH_CATALOGUE_NON_MEDICAL_AUDIT_OK = '[ENTITY] Fetch CatalogueNonMedicalModel audit successfully',
	FETCH_CATALOGUE_NON_MEDICAL_AUDIT_FAIL = '[ENTITY] Fetch CatalogueNonMedicalModel audit failed',

	FETCH_CATALOGUE_NON_MEDICAL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CatalogueNonMedicalModel audits by entity id',
	FETCH_CATALOGUE_NON_MEDICAL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CatalogueNonMedicalModel audits by entity id successfully',
	FETCH_CATALOGUE_NON_MEDICAL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CatalogueNonMedicalModel audits by entity id failed',

	FETCH_ALL_CATALOGUE_NON_MEDICAL = '[ENTITY] Fetch all CatalogueNonMedicalModel',
	FETCH_ALL_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Fetch all CatalogueNonMedicalModel successfully',
	FETCH_ALL_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Fetch all CatalogueNonMedicalModel failed',

	FETCH_CATALOGUE_NON_MEDICAL_WITH_QUERY = '[ENTITY] Fetch CatalogueNonMedicalModel with query',
	FETCH_CATALOGUE_NON_MEDICAL_WITH_QUERY_OK = '[ENTITY] Fetch CatalogueNonMedicalModel with query successfully',
	FETCH_CATALOGUE_NON_MEDICAL_WITH_QUERY_FAIL = '[ENTITY] Fetch CatalogueNonMedicalModel with query failed',

	FETCH_LAST_CATALOGUE_NON_MEDICAL_WITH_QUERY = '[ENTITY] Fetch last CatalogueNonMedicalModel with query',
	FETCH_LAST_CATALOGUE_NON_MEDICAL_WITH_QUERY_OK = '[ENTITY] Fetch last CatalogueNonMedicalModel with query successfully',
	FETCH_LAST_CATALOGUE_NON_MEDICAL_WITH_QUERY_FAIL = '[ENTITY] Fetch last CatalogueNonMedicalModel with query failed',

	EXPORT_CATALOGUE_NON_MEDICAL = '[ENTITY] Export CatalogueNonMedicalModel',
	EXPORT_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Export CatalogueNonMedicalModel successfully',
	EXPORT_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Export CatalogueNonMedicalModel failed',

	EXPORT_ALL_CATALOGUE_NON_MEDICAL = '[ENTITY] Export All CatalogueNonMedicalModels',
	EXPORT_ALL_CATALOGUE_NON_MEDICAL_OK = '[ENTITY] Export All CatalogueNonMedicalModels successfully',
	EXPORT_ALL_CATALOGUE_NON_MEDICAL_FAIL = '[ENTITY] Export All CatalogueNonMedicalModels failed',

	EXPORT_CATALOGUE_NON_MEDICAL_EXCLUDING_IDS = '[ENTITY] Export CatalogueNonMedicalModels excluding Ids',
	EXPORT_CATALOGUE_NON_MEDICAL_EXCLUDING_IDS_OK = '[ENTITY] Export CatalogueNonMedicalModel excluding Ids successfully',
	EXPORT_CATALOGUE_NON_MEDICAL_EXCLUDING_IDS_FAIL = '[ENTITY] Export CatalogueNonMedicalModel excluding Ids failed',

	COUNT_CATALOGUE_NON_MEDICALS = '[ENTITY] Fetch number of CatalogueNonMedicalModel records',
	COUNT_CATALOGUE_NON_MEDICALS_OK = '[ENTITY] Fetch number of CatalogueNonMedicalModel records successfully ',
	COUNT_CATALOGUE_NON_MEDICALS_FAIL = '[ENTITY] Fetch number of CatalogueNonMedicalModel records failed',

	IMPORT_CATALOGUE_NON_MEDICALS = '[ENTITY] Import CatalogueNonMedicalModels',
	IMPORT_CATALOGUE_NON_MEDICALS_OK = '[ENTITY] Import CatalogueNonMedicalModels successfully',
	IMPORT_CATALOGUE_NON_MEDICALS_FAIL = '[ENTITY] Import CatalogueNonMedicalModels fail',


	INITIALISE_CATALOGUE_NON_MEDICAL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CatalogueNonMedicalModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCatalogueNonMedicalAction implements Action {
	readonly className: string = 'CatalogueNonMedicalModel';

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

export class CatalogueNonMedicalAction extends BaseCatalogueNonMedicalAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CatalogueNonMedicalAction here] off begin
	// % protected region % [Add any additional class fields for CatalogueNonMedicalAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CatalogueNonMedicalModel>,
		// % protected region % [Add any additional constructor parameters for CatalogueNonMedicalAction here] off begin
		// % protected region % [Add any additional constructor parameters for CatalogueNonMedicalAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CatalogueNonMedicalAction here] off begin
			// % protected region % [Add any additional constructor arguments for CatalogueNonMedicalAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CatalogueNonMedicalAction here] off begin
		// % protected region % [Add any additional constructor logic for CatalogueNonMedicalAction here] end
	}

	// % protected region % [Add any additional class methods for CatalogueNonMedicalAction here] off begin
	// % protected region % [Add any additional class methods for CatalogueNonMedicalAction here] end
}

export class CatalogueNonMedicalActionOK extends BaseCatalogueNonMedicalAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CatalogueNonMedicalActionOK here] off begin
	// % protected region % [Add any additional class fields for CatalogueNonMedicalActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CatalogueNonMedicalModel>,
		// % protected region % [Add any additional constructor parameters for CatalogueNonMedicalActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CatalogueNonMedicalActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CatalogueNonMedicalModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CatalogueNonMedicalActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CatalogueNonMedicalActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CatalogueNonMedicalActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CatalogueNonMedicalActionOK here] end
	}

	// % protected region % [Add any additional class methods for CatalogueNonMedicalActionOK here] off begin
	// % protected region % [Add any additional class methods for CatalogueNonMedicalActionOK here] end
}

export class CatalogueNonMedicalActionFail extends BaseCatalogueNonMedicalAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CatalogueNonMedicalActionFail here] off begin
	// % protected region % [Add any additional class fields for CatalogueNonMedicalActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CatalogueNonMedicalModel>,
		// % protected region % [Add any additional constructor parameters for CatalogueNonMedicalActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CatalogueNonMedicalActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CatalogueNonMedicalActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CatalogueNonMedicalActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CatalogueNonMedicalActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CatalogueNonMedicalActionFail here] end
	}

	// % protected region % [Add any additional class methods for CatalogueNonMedicalActionFail here] off begin
	// % protected region % [Add any additional class methods for CatalogueNonMedicalActionFail here] end
}

export function isCatalogueNonMedicalModelAction(e: any): e is BaseCatalogueNonMedicalAction {
	return Object.values(CatalogueNonMedicalModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
