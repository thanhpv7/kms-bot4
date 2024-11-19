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
import {FormulirKonselingTesHivModel} from './formulir_konseling_tes_hiv.model';
import {FormulirKonselingTesHivModelAudit} from './formulir_konseling_tes_hiv.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Formulir Konseling Tes Hiv model actions to be dispatched by NgRx.
 */
export enum FormulirKonselingTesHivModelActionTypes {
	CREATE_FORMULIR_KONSELING_TES_HIV = '[ENTITY] Create FormulirKonselingTesHivModel',
	CREATE_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Create FormulirKonselingTesHivModel successfully',
	CREATE_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Create FormulirKonselingTesHivModel failed',

	CREATE_ALL_FORMULIR_KONSELING_TES_HIV = '[ENTITY] Create All FormulirKonselingTesHivModel',
	CREATE_ALL_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Create All FormulirKonselingTesHivModel successfully',
	CREATE_ALL_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Create All FormulirKonselingTesHivModel failed',

	DELETE_FORMULIR_KONSELING_TES_HIV = '[ENTITY] Delete FormulirKonselingTesHivModel',
	DELETE_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Delete FormulirKonselingTesHivModel successfully',
	DELETE_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Delete FormulirKonselingTesHivModel failed',


	DELETE_FORMULIR_KONSELING_TES_HIV_EXCLUDING_IDS = '[ENTITY] Delete FormulirKonselingTesHivModels Excluding Ids',
	DELETE_FORMULIR_KONSELING_TES_HIV_EXCLUDING_IDS_OK = '[ENTITY] Delete FormulirKonselingTesHivModels Excluding Ids successfully',
	DELETE_FORMULIR_KONSELING_TES_HIV_EXCLUDING_IDS_FAIL = '[ENTITY] Delete FormulirKonselingTesHivModels Excluding Ids failed',

	DELETE_ALL_FORMULIR_KONSELING_TES_HIV = '[ENTITY] Delete all FormulirKonselingTesHivModels',
	DELETE_ALL_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Delete all FormulirKonselingTesHivModels successfully',
	DELETE_ALL_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Delete all FormulirKonselingTesHivModels failed',

	UPDATE_FORMULIR_KONSELING_TES_HIV = '[ENTITY] Update FormulirKonselingTesHivModel',
	UPDATE_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Update FormulirKonselingTesHivModel successfully',
	UPDATE_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Update FormulirKonselingTesHivModel failed',

	UPDATE_ALL_FORMULIR_KONSELING_TES_HIV = '[ENTITY] Update all FormulirKonselingTesHivModel',
	UPDATE_ALL_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Update all FormulirKonselingTesHivModel successfully',
	UPDATE_ALL_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Update all FormulirKonselingTesHivModel failed',

	FETCH_FORMULIR_KONSELING_TES_HIV= '[ENTITY] Fetch FormulirKonselingTesHivModel',
	FETCH_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Fetch FormulirKonselingTesHivModel successfully',
	FETCH_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Fetch FormulirKonselingTesHivModel failed',

	FETCH_FORMULIR_KONSELING_TES_HIV_AUDIT= '[ENTITY] Fetch FormulirKonselingTesHivModel audit',
	FETCH_FORMULIR_KONSELING_TES_HIV_AUDIT_OK = '[ENTITY] Fetch FormulirKonselingTesHivModel audit successfully',
	FETCH_FORMULIR_KONSELING_TES_HIV_AUDIT_FAIL = '[ENTITY] Fetch FormulirKonselingTesHivModel audit failed',

	FETCH_FORMULIR_KONSELING_TES_HIV_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch FormulirKonselingTesHivModel audits by entity id',
	FETCH_FORMULIR_KONSELING_TES_HIV_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch FormulirKonselingTesHivModel audits by entity id successfully',
	FETCH_FORMULIR_KONSELING_TES_HIV_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch FormulirKonselingTesHivModel audits by entity id failed',

	FETCH_ALL_FORMULIR_KONSELING_TES_HIV = '[ENTITY] Fetch all FormulirKonselingTesHivModel',
	FETCH_ALL_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Fetch all FormulirKonselingTesHivModel successfully',
	FETCH_ALL_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Fetch all FormulirKonselingTesHivModel failed',

	FETCH_FORMULIR_KONSELING_TES_HIV_WITH_QUERY = '[ENTITY] Fetch FormulirKonselingTesHivModel with query',
	FETCH_FORMULIR_KONSELING_TES_HIV_WITH_QUERY_OK = '[ENTITY] Fetch FormulirKonselingTesHivModel with query successfully',
	FETCH_FORMULIR_KONSELING_TES_HIV_WITH_QUERY_FAIL = '[ENTITY] Fetch FormulirKonselingTesHivModel with query failed',

	FETCH_LAST_FORMULIR_KONSELING_TES_HIV_WITH_QUERY = '[ENTITY] Fetch last FormulirKonselingTesHivModel with query',
	FETCH_LAST_FORMULIR_KONSELING_TES_HIV_WITH_QUERY_OK = '[ENTITY] Fetch last FormulirKonselingTesHivModel with query successfully',
	FETCH_LAST_FORMULIR_KONSELING_TES_HIV_WITH_QUERY_FAIL = '[ENTITY] Fetch last FormulirKonselingTesHivModel with query failed',

	EXPORT_FORMULIR_KONSELING_TES_HIV = '[ENTITY] Export FormulirKonselingTesHivModel',
	EXPORT_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Export FormulirKonselingTesHivModel successfully',
	EXPORT_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Export FormulirKonselingTesHivModel failed',

	EXPORT_ALL_FORMULIR_KONSELING_TES_HIV = '[ENTITY] Export All FormulirKonselingTesHivModels',
	EXPORT_ALL_FORMULIR_KONSELING_TES_HIV_OK = '[ENTITY] Export All FormulirKonselingTesHivModels successfully',
	EXPORT_ALL_FORMULIR_KONSELING_TES_HIV_FAIL = '[ENTITY] Export All FormulirKonselingTesHivModels failed',

	EXPORT_FORMULIR_KONSELING_TES_HIV_EXCLUDING_IDS = '[ENTITY] Export FormulirKonselingTesHivModels excluding Ids',
	EXPORT_FORMULIR_KONSELING_TES_HIV_EXCLUDING_IDS_OK = '[ENTITY] Export FormulirKonselingTesHivModel excluding Ids successfully',
	EXPORT_FORMULIR_KONSELING_TES_HIV_EXCLUDING_IDS_FAIL = '[ENTITY] Export FormulirKonselingTesHivModel excluding Ids failed',

	COUNT_FORMULIR_KONSELING_TES_HIVS = '[ENTITY] Fetch number of FormulirKonselingTesHivModel records',
	COUNT_FORMULIR_KONSELING_TES_HIVS_OK = '[ENTITY] Fetch number of FormulirKonselingTesHivModel records successfully ',
	COUNT_FORMULIR_KONSELING_TES_HIVS_FAIL = '[ENTITY] Fetch number of FormulirKonselingTesHivModel records failed',

	IMPORT_FORMULIR_KONSELING_TES_HIVS = '[ENTITY] Import FormulirKonselingTesHivModels',
	IMPORT_FORMULIR_KONSELING_TES_HIVS_OK = '[ENTITY] Import FormulirKonselingTesHivModels successfully',
	IMPORT_FORMULIR_KONSELING_TES_HIVS_FAIL = '[ENTITY] Import FormulirKonselingTesHivModels fail',


	INITIALISE_FORMULIR_KONSELING_TES_HIV_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of FormulirKonselingTesHivModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseFormulirKonselingTesHivAction implements Action {
	readonly className: string = 'FormulirKonselingTesHivModel';

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

export class FormulirKonselingTesHivAction extends BaseFormulirKonselingTesHivAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FormulirKonselingTesHivAction here] off begin
	// % protected region % [Add any additional class fields for FormulirKonselingTesHivAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<FormulirKonselingTesHivModel>,
		// % protected region % [Add any additional constructor parameters for FormulirKonselingTesHivAction here] off begin
		// % protected region % [Add any additional constructor parameters for FormulirKonselingTesHivAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FormulirKonselingTesHivAction here] off begin
			// % protected region % [Add any additional constructor arguments for FormulirKonselingTesHivAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FormulirKonselingTesHivAction here] off begin
		// % protected region % [Add any additional constructor logic for FormulirKonselingTesHivAction here] end
	}

	// % protected region % [Add any additional class methods for FormulirKonselingTesHivAction here] off begin
	// % protected region % [Add any additional class methods for FormulirKonselingTesHivAction here] end
}

export class FormulirKonselingTesHivActionOK extends BaseFormulirKonselingTesHivAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FormulirKonselingTesHivActionOK here] off begin
	// % protected region % [Add any additional class fields for FormulirKonselingTesHivActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<FormulirKonselingTesHivModel>,
		// % protected region % [Add any additional constructor parameters for FormulirKonselingTesHivActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for FormulirKonselingTesHivActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: FormulirKonselingTesHivModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FormulirKonselingTesHivActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for FormulirKonselingTesHivActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FormulirKonselingTesHivActionOK here] off begin
		// % protected region % [Add any additional constructor logic for FormulirKonselingTesHivActionOK here] end
	}

	// % protected region % [Add any additional class methods for FormulirKonselingTesHivActionOK here] off begin
	// % protected region % [Add any additional class methods for FormulirKonselingTesHivActionOK here] end
}

export class FormulirKonselingTesHivActionFail extends BaseFormulirKonselingTesHivAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for FormulirKonselingTesHivActionFail here] off begin
	// % protected region % [Add any additional class fields for FormulirKonselingTesHivActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<FormulirKonselingTesHivModel>,
		// % protected region % [Add any additional constructor parameters for FormulirKonselingTesHivActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for FormulirKonselingTesHivActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for FormulirKonselingTesHivActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for FormulirKonselingTesHivActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for FormulirKonselingTesHivActionFail here] off begin
		// % protected region % [Add any additional constructor logic for FormulirKonselingTesHivActionFail here] end
	}

	// % protected region % [Add any additional class methods for FormulirKonselingTesHivActionFail here] off begin
	// % protected region % [Add any additional class methods for FormulirKonselingTesHivActionFail here] end
}

export function isFormulirKonselingTesHivModelAction(e: any): e is BaseFormulirKonselingTesHivAction {
	return Object.values(FormulirKonselingTesHivModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
