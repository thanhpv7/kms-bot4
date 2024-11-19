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
import {MedicationCompoundModel} from './medication_compound.model';
import {MedicationCompoundModelAudit} from './medication_compound.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medication Compound model actions to be dispatched by NgRx.
 */
export enum MedicationCompoundModelActionTypes {
	CREATE_MEDICATION_COMPOUND = '[ENTITY] Create MedicationCompoundModel',
	CREATE_MEDICATION_COMPOUND_OK = '[ENTITY] Create MedicationCompoundModel successfully',
	CREATE_MEDICATION_COMPOUND_FAIL = '[ENTITY] Create MedicationCompoundModel failed',

	CREATE_ALL_MEDICATION_COMPOUND = '[ENTITY] Create All MedicationCompoundModel',
	CREATE_ALL_MEDICATION_COMPOUND_OK = '[ENTITY] Create All MedicationCompoundModel successfully',
	CREATE_ALL_MEDICATION_COMPOUND_FAIL = '[ENTITY] Create All MedicationCompoundModel failed',

	DELETE_MEDICATION_COMPOUND = '[ENTITY] Delete MedicationCompoundModel',
	DELETE_MEDICATION_COMPOUND_OK = '[ENTITY] Delete MedicationCompoundModel successfully',
	DELETE_MEDICATION_COMPOUND_FAIL = '[ENTITY] Delete MedicationCompoundModel failed',


	DELETE_MEDICATION_COMPOUND_EXCLUDING_IDS = '[ENTITY] Delete MedicationCompoundModels Excluding Ids',
	DELETE_MEDICATION_COMPOUND_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicationCompoundModels Excluding Ids successfully',
	DELETE_MEDICATION_COMPOUND_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicationCompoundModels Excluding Ids failed',

	DELETE_ALL_MEDICATION_COMPOUND = '[ENTITY] Delete all MedicationCompoundModels',
	DELETE_ALL_MEDICATION_COMPOUND_OK = '[ENTITY] Delete all MedicationCompoundModels successfully',
	DELETE_ALL_MEDICATION_COMPOUND_FAIL = '[ENTITY] Delete all MedicationCompoundModels failed',

	UPDATE_MEDICATION_COMPOUND = '[ENTITY] Update MedicationCompoundModel',
	UPDATE_MEDICATION_COMPOUND_OK = '[ENTITY] Update MedicationCompoundModel successfully',
	UPDATE_MEDICATION_COMPOUND_FAIL = '[ENTITY] Update MedicationCompoundModel failed',

	UPDATE_ALL_MEDICATION_COMPOUND = '[ENTITY] Update all MedicationCompoundModel',
	UPDATE_ALL_MEDICATION_COMPOUND_OK = '[ENTITY] Update all MedicationCompoundModel successfully',
	UPDATE_ALL_MEDICATION_COMPOUND_FAIL = '[ENTITY] Update all MedicationCompoundModel failed',

	FETCH_MEDICATION_COMPOUND= '[ENTITY] Fetch MedicationCompoundModel',
	FETCH_MEDICATION_COMPOUND_OK = '[ENTITY] Fetch MedicationCompoundModel successfully',
	FETCH_MEDICATION_COMPOUND_FAIL = '[ENTITY] Fetch MedicationCompoundModel failed',

	FETCH_MEDICATION_COMPOUND_AUDIT= '[ENTITY] Fetch MedicationCompoundModel audit',
	FETCH_MEDICATION_COMPOUND_AUDIT_OK = '[ENTITY] Fetch MedicationCompoundModel audit successfully',
	FETCH_MEDICATION_COMPOUND_AUDIT_FAIL = '[ENTITY] Fetch MedicationCompoundModel audit failed',

	FETCH_MEDICATION_COMPOUND_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicationCompoundModel audits by entity id',
	FETCH_MEDICATION_COMPOUND_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicationCompoundModel audits by entity id successfully',
	FETCH_MEDICATION_COMPOUND_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicationCompoundModel audits by entity id failed',

	FETCH_ALL_MEDICATION_COMPOUND = '[ENTITY] Fetch all MedicationCompoundModel',
	FETCH_ALL_MEDICATION_COMPOUND_OK = '[ENTITY] Fetch all MedicationCompoundModel successfully',
	FETCH_ALL_MEDICATION_COMPOUND_FAIL = '[ENTITY] Fetch all MedicationCompoundModel failed',

	FETCH_MEDICATION_COMPOUND_WITH_QUERY = '[ENTITY] Fetch MedicationCompoundModel with query',
	FETCH_MEDICATION_COMPOUND_WITH_QUERY_OK = '[ENTITY] Fetch MedicationCompoundModel with query successfully',
	FETCH_MEDICATION_COMPOUND_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicationCompoundModel with query failed',

	FETCH_LAST_MEDICATION_COMPOUND_WITH_QUERY = '[ENTITY] Fetch last MedicationCompoundModel with query',
	FETCH_LAST_MEDICATION_COMPOUND_WITH_QUERY_OK = '[ENTITY] Fetch last MedicationCompoundModel with query successfully',
	FETCH_LAST_MEDICATION_COMPOUND_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicationCompoundModel with query failed',

	EXPORT_MEDICATION_COMPOUND = '[ENTITY] Export MedicationCompoundModel',
	EXPORT_MEDICATION_COMPOUND_OK = '[ENTITY] Export MedicationCompoundModel successfully',
	EXPORT_MEDICATION_COMPOUND_FAIL = '[ENTITY] Export MedicationCompoundModel failed',

	EXPORT_ALL_MEDICATION_COMPOUND = '[ENTITY] Export All MedicationCompoundModels',
	EXPORT_ALL_MEDICATION_COMPOUND_OK = '[ENTITY] Export All MedicationCompoundModels successfully',
	EXPORT_ALL_MEDICATION_COMPOUND_FAIL = '[ENTITY] Export All MedicationCompoundModels failed',

	EXPORT_MEDICATION_COMPOUND_EXCLUDING_IDS = '[ENTITY] Export MedicationCompoundModels excluding Ids',
	EXPORT_MEDICATION_COMPOUND_EXCLUDING_IDS_OK = '[ENTITY] Export MedicationCompoundModel excluding Ids successfully',
	EXPORT_MEDICATION_COMPOUND_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicationCompoundModel excluding Ids failed',

	COUNT_MEDICATION_COMPOUNDS = '[ENTITY] Fetch number of MedicationCompoundModel records',
	COUNT_MEDICATION_COMPOUNDS_OK = '[ENTITY] Fetch number of MedicationCompoundModel records successfully ',
	COUNT_MEDICATION_COMPOUNDS_FAIL = '[ENTITY] Fetch number of MedicationCompoundModel records failed',

	IMPORT_MEDICATION_COMPOUNDS = '[ENTITY] Import MedicationCompoundModels',
	IMPORT_MEDICATION_COMPOUNDS_OK = '[ENTITY] Import MedicationCompoundModels successfully',
	IMPORT_MEDICATION_COMPOUNDS_FAIL = '[ENTITY] Import MedicationCompoundModels fail',


	INITIALISE_MEDICATION_COMPOUND_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicationCompoundModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicationCompoundAction implements Action {
	readonly className: string = 'MedicationCompoundModel';

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

export class MedicationCompoundAction extends BaseMedicationCompoundAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationCompoundAction here] off begin
	// % protected region % [Add any additional class fields for MedicationCompoundAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicationCompoundModel>,
		// % protected region % [Add any additional constructor parameters for MedicationCompoundAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationCompoundAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationCompoundAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationCompoundAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationCompoundAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicationCompoundAction here] end
	}

	// % protected region % [Add any additional class methods for MedicationCompoundAction here] off begin
	// % protected region % [Add any additional class methods for MedicationCompoundAction here] end
}

export class MedicationCompoundActionOK extends BaseMedicationCompoundAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationCompoundActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicationCompoundActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicationCompoundModel>,
		// % protected region % [Add any additional constructor parameters for MedicationCompoundActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationCompoundActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicationCompoundModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationCompoundActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationCompoundActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationCompoundActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicationCompoundActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicationCompoundActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicationCompoundActionOK here] end
}

export class MedicationCompoundActionFail extends BaseMedicationCompoundAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationCompoundActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicationCompoundActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicationCompoundModel>,
		// % protected region % [Add any additional constructor parameters for MedicationCompoundActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationCompoundActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationCompoundActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationCompoundActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationCompoundActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicationCompoundActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicationCompoundActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicationCompoundActionFail here] end
}

export function isMedicationCompoundModelAction(e: any): e is BaseMedicationCompoundAction {
	return Object.values(MedicationCompoundModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
