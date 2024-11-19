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
import {CatalogueUOMModel} from './catalogue_uom.model';
import {CatalogueUOMModelAudit} from './catalogue_uom.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Catalogue UOM model actions to be dispatched by NgRx.
 */
export enum CatalogueUOMModelActionTypes {
	CREATE_CATALOGUE_UOM = '[ENTITY] Create CatalogueUOMModel',
	CREATE_CATALOGUE_UOM_OK = '[ENTITY] Create CatalogueUOMModel successfully',
	CREATE_CATALOGUE_UOM_FAIL = '[ENTITY] Create CatalogueUOMModel failed',

	CREATE_ALL_CATALOGUE_UOM = '[ENTITY] Create All CatalogueUOMModel',
	CREATE_ALL_CATALOGUE_UOM_OK = '[ENTITY] Create All CatalogueUOMModel successfully',
	CREATE_ALL_CATALOGUE_UOM_FAIL = '[ENTITY] Create All CatalogueUOMModel failed',

	DELETE_CATALOGUE_UOM = '[ENTITY] Delete CatalogueUOMModel',
	DELETE_CATALOGUE_UOM_OK = '[ENTITY] Delete CatalogueUOMModel successfully',
	DELETE_CATALOGUE_UOM_FAIL = '[ENTITY] Delete CatalogueUOMModel failed',


	DELETE_CATALOGUE_UOM_EXCLUDING_IDS = '[ENTITY] Delete CatalogueUOMModels Excluding Ids',
	DELETE_CATALOGUE_UOM_EXCLUDING_IDS_OK = '[ENTITY] Delete CatalogueUOMModels Excluding Ids successfully',
	DELETE_CATALOGUE_UOM_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CatalogueUOMModels Excluding Ids failed',

	DELETE_ALL_CATALOGUE_UOM = '[ENTITY] Delete all CatalogueUOMModels',
	DELETE_ALL_CATALOGUE_UOM_OK = '[ENTITY] Delete all CatalogueUOMModels successfully',
	DELETE_ALL_CATALOGUE_UOM_FAIL = '[ENTITY] Delete all CatalogueUOMModels failed',

	UPDATE_CATALOGUE_UOM = '[ENTITY] Update CatalogueUOMModel',
	UPDATE_CATALOGUE_UOM_OK = '[ENTITY] Update CatalogueUOMModel successfully',
	UPDATE_CATALOGUE_UOM_FAIL = '[ENTITY] Update CatalogueUOMModel failed',

	UPDATE_ALL_CATALOGUE_UOM = '[ENTITY] Update all CatalogueUOMModel',
	UPDATE_ALL_CATALOGUE_UOM_OK = '[ENTITY] Update all CatalogueUOMModel successfully',
	UPDATE_ALL_CATALOGUE_UOM_FAIL = '[ENTITY] Update all CatalogueUOMModel failed',

	FETCH_CATALOGUE_UOM= '[ENTITY] Fetch CatalogueUOMModel',
	FETCH_CATALOGUE_UOM_OK = '[ENTITY] Fetch CatalogueUOMModel successfully',
	FETCH_CATALOGUE_UOM_FAIL = '[ENTITY] Fetch CatalogueUOMModel failed',

	FETCH_CATALOGUE_UOM_AUDIT= '[ENTITY] Fetch CatalogueUOMModel audit',
	FETCH_CATALOGUE_UOM_AUDIT_OK = '[ENTITY] Fetch CatalogueUOMModel audit successfully',
	FETCH_CATALOGUE_UOM_AUDIT_FAIL = '[ENTITY] Fetch CatalogueUOMModel audit failed',

	FETCH_CATALOGUE_UOM_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CatalogueUOMModel audits by entity id',
	FETCH_CATALOGUE_UOM_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CatalogueUOMModel audits by entity id successfully',
	FETCH_CATALOGUE_UOM_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CatalogueUOMModel audits by entity id failed',

	FETCH_ALL_CATALOGUE_UOM = '[ENTITY] Fetch all CatalogueUOMModel',
	FETCH_ALL_CATALOGUE_UOM_OK = '[ENTITY] Fetch all CatalogueUOMModel successfully',
	FETCH_ALL_CATALOGUE_UOM_FAIL = '[ENTITY] Fetch all CatalogueUOMModel failed',

	FETCH_CATALOGUE_UOM_WITH_QUERY = '[ENTITY] Fetch CatalogueUOMModel with query',
	FETCH_CATALOGUE_UOM_WITH_QUERY_OK = '[ENTITY] Fetch CatalogueUOMModel with query successfully',
	FETCH_CATALOGUE_UOM_WITH_QUERY_FAIL = '[ENTITY] Fetch CatalogueUOMModel with query failed',

	FETCH_LAST_CATALOGUE_UOM_WITH_QUERY = '[ENTITY] Fetch last CatalogueUOMModel with query',
	FETCH_LAST_CATALOGUE_UOM_WITH_QUERY_OK = '[ENTITY] Fetch last CatalogueUOMModel with query successfully',
	FETCH_LAST_CATALOGUE_UOM_WITH_QUERY_FAIL = '[ENTITY] Fetch last CatalogueUOMModel with query failed',

	EXPORT_CATALOGUE_UOM = '[ENTITY] Export CatalogueUOMModel',
	EXPORT_CATALOGUE_UOM_OK = '[ENTITY] Export CatalogueUOMModel successfully',
	EXPORT_CATALOGUE_UOM_FAIL = '[ENTITY] Export CatalogueUOMModel failed',

	EXPORT_ALL_CATALOGUE_UOM = '[ENTITY] Export All CatalogueUOMModels',
	EXPORT_ALL_CATALOGUE_UOM_OK = '[ENTITY] Export All CatalogueUOMModels successfully',
	EXPORT_ALL_CATALOGUE_UOM_FAIL = '[ENTITY] Export All CatalogueUOMModels failed',

	EXPORT_CATALOGUE_UOM_EXCLUDING_IDS = '[ENTITY] Export CatalogueUOMModels excluding Ids',
	EXPORT_CATALOGUE_UOM_EXCLUDING_IDS_OK = '[ENTITY] Export CatalogueUOMModel excluding Ids successfully',
	EXPORT_CATALOGUE_UOM_EXCLUDING_IDS_FAIL = '[ENTITY] Export CatalogueUOMModel excluding Ids failed',

	COUNT_CATALOGUE_UOMS = '[ENTITY] Fetch number of CatalogueUOMModel records',
	COUNT_CATALOGUE_UOMS_OK = '[ENTITY] Fetch number of CatalogueUOMModel records successfully ',
	COUNT_CATALOGUE_UOMS_FAIL = '[ENTITY] Fetch number of CatalogueUOMModel records failed',

	IMPORT_CATALOGUE_UOMS = '[ENTITY] Import CatalogueUOMModels',
	IMPORT_CATALOGUE_UOMS_OK = '[ENTITY] Import CatalogueUOMModels successfully',
	IMPORT_CATALOGUE_UOMS_FAIL = '[ENTITY] Import CatalogueUOMModels fail',


	INITIALISE_CATALOGUE_UOM_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CatalogueUOMModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCatalogueUOMAction implements Action {
	readonly className: string = 'CatalogueUOMModel';

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

export class CatalogueUOMAction extends BaseCatalogueUOMAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CatalogueUOMAction here] off begin
	// % protected region % [Add any additional class fields for CatalogueUOMAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CatalogueUOMModel>,
		// % protected region % [Add any additional constructor parameters for CatalogueUOMAction here] off begin
		// % protected region % [Add any additional constructor parameters for CatalogueUOMAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CatalogueUOMAction here] off begin
			// % protected region % [Add any additional constructor arguments for CatalogueUOMAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CatalogueUOMAction here] off begin
		// % protected region % [Add any additional constructor logic for CatalogueUOMAction here] end
	}

	// % protected region % [Add any additional class methods for CatalogueUOMAction here] off begin
	// % protected region % [Add any additional class methods for CatalogueUOMAction here] end
}

export class CatalogueUOMActionOK extends BaseCatalogueUOMAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CatalogueUOMActionOK here] off begin
	// % protected region % [Add any additional class fields for CatalogueUOMActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CatalogueUOMModel>,
		// % protected region % [Add any additional constructor parameters for CatalogueUOMActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CatalogueUOMActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CatalogueUOMModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CatalogueUOMActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CatalogueUOMActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CatalogueUOMActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CatalogueUOMActionOK here] end
	}

	// % protected region % [Add any additional class methods for CatalogueUOMActionOK here] off begin
	// % protected region % [Add any additional class methods for CatalogueUOMActionOK here] end
}

export class CatalogueUOMActionFail extends BaseCatalogueUOMAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CatalogueUOMActionFail here] off begin
	// % protected region % [Add any additional class fields for CatalogueUOMActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CatalogueUOMModel>,
		// % protected region % [Add any additional constructor parameters for CatalogueUOMActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CatalogueUOMActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CatalogueUOMActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CatalogueUOMActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CatalogueUOMActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CatalogueUOMActionFail here] end
	}

	// % protected region % [Add any additional class methods for CatalogueUOMActionFail here] off begin
	// % protected region % [Add any additional class methods for CatalogueUOMActionFail here] end
}

export function isCatalogueUOMModelAction(e: any): e is BaseCatalogueUOMAction {
	return Object.values(CatalogueUOMModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
