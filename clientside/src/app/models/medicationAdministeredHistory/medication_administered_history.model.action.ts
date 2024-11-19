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
import {MedicationAdministeredHistoryModel} from './medication_administered_history.model';
import {MedicationAdministeredHistoryModelAudit} from './medication_administered_history.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medication Administered History model actions to be dispatched by NgRx.
 */
export enum MedicationAdministeredHistoryModelActionTypes {
	CREATE_MEDICATION_ADMINISTERED_HISTORY = '[ENTITY] Create MedicationAdministeredHistoryModel',
	CREATE_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Create MedicationAdministeredHistoryModel successfully',
	CREATE_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Create MedicationAdministeredHistoryModel failed',

	CREATE_ALL_MEDICATION_ADMINISTERED_HISTORY = '[ENTITY] Create All MedicationAdministeredHistoryModel',
	CREATE_ALL_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Create All MedicationAdministeredHistoryModel successfully',
	CREATE_ALL_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Create All MedicationAdministeredHistoryModel failed',

	DELETE_MEDICATION_ADMINISTERED_HISTORY = '[ENTITY] Delete MedicationAdministeredHistoryModel',
	DELETE_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Delete MedicationAdministeredHistoryModel successfully',
	DELETE_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Delete MedicationAdministeredHistoryModel failed',


	DELETE_MEDICATION_ADMINISTERED_HISTORY_EXCLUDING_IDS = '[ENTITY] Delete MedicationAdministeredHistoryModels Excluding Ids',
	DELETE_MEDICATION_ADMINISTERED_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicationAdministeredHistoryModels Excluding Ids successfully',
	DELETE_MEDICATION_ADMINISTERED_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicationAdministeredHistoryModels Excluding Ids failed',

	DELETE_ALL_MEDICATION_ADMINISTERED_HISTORY = '[ENTITY] Delete all MedicationAdministeredHistoryModels',
	DELETE_ALL_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Delete all MedicationAdministeredHistoryModels successfully',
	DELETE_ALL_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Delete all MedicationAdministeredHistoryModels failed',

	UPDATE_MEDICATION_ADMINISTERED_HISTORY = '[ENTITY] Update MedicationAdministeredHistoryModel',
	UPDATE_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Update MedicationAdministeredHistoryModel successfully',
	UPDATE_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Update MedicationAdministeredHistoryModel failed',

	UPDATE_ALL_MEDICATION_ADMINISTERED_HISTORY = '[ENTITY] Update all MedicationAdministeredHistoryModel',
	UPDATE_ALL_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Update all MedicationAdministeredHistoryModel successfully',
	UPDATE_ALL_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Update all MedicationAdministeredHistoryModel failed',

	FETCH_MEDICATION_ADMINISTERED_HISTORY= '[ENTITY] Fetch MedicationAdministeredHistoryModel',
	FETCH_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Fetch MedicationAdministeredHistoryModel successfully',
	FETCH_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Fetch MedicationAdministeredHistoryModel failed',

	FETCH_MEDICATION_ADMINISTERED_HISTORY_AUDIT= '[ENTITY] Fetch MedicationAdministeredHistoryModel audit',
	FETCH_MEDICATION_ADMINISTERED_HISTORY_AUDIT_OK = '[ENTITY] Fetch MedicationAdministeredHistoryModel audit successfully',
	FETCH_MEDICATION_ADMINISTERED_HISTORY_AUDIT_FAIL = '[ENTITY] Fetch MedicationAdministeredHistoryModel audit failed',

	FETCH_MEDICATION_ADMINISTERED_HISTORY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicationAdministeredHistoryModel audits by entity id',
	FETCH_MEDICATION_ADMINISTERED_HISTORY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicationAdministeredHistoryModel audits by entity id successfully',
	FETCH_MEDICATION_ADMINISTERED_HISTORY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicationAdministeredHistoryModel audits by entity id failed',

	FETCH_ALL_MEDICATION_ADMINISTERED_HISTORY = '[ENTITY] Fetch all MedicationAdministeredHistoryModel',
	FETCH_ALL_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Fetch all MedicationAdministeredHistoryModel successfully',
	FETCH_ALL_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Fetch all MedicationAdministeredHistoryModel failed',

	FETCH_MEDICATION_ADMINISTERED_HISTORY_WITH_QUERY = '[ENTITY] Fetch MedicationAdministeredHistoryModel with query',
	FETCH_MEDICATION_ADMINISTERED_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch MedicationAdministeredHistoryModel with query successfully',
	FETCH_MEDICATION_ADMINISTERED_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicationAdministeredHistoryModel with query failed',

	FETCH_LAST_MEDICATION_ADMINISTERED_HISTORY_WITH_QUERY = '[ENTITY] Fetch last MedicationAdministeredHistoryModel with query',
	FETCH_LAST_MEDICATION_ADMINISTERED_HISTORY_WITH_QUERY_OK = '[ENTITY] Fetch last MedicationAdministeredHistoryModel with query successfully',
	FETCH_LAST_MEDICATION_ADMINISTERED_HISTORY_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicationAdministeredHistoryModel with query failed',

	EXPORT_MEDICATION_ADMINISTERED_HISTORY = '[ENTITY] Export MedicationAdministeredHistoryModel',
	EXPORT_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Export MedicationAdministeredHistoryModel successfully',
	EXPORT_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Export MedicationAdministeredHistoryModel failed',

	EXPORT_ALL_MEDICATION_ADMINISTERED_HISTORY = '[ENTITY] Export All MedicationAdministeredHistoryModels',
	EXPORT_ALL_MEDICATION_ADMINISTERED_HISTORY_OK = '[ENTITY] Export All MedicationAdministeredHistoryModels successfully',
	EXPORT_ALL_MEDICATION_ADMINISTERED_HISTORY_FAIL = '[ENTITY] Export All MedicationAdministeredHistoryModels failed',

	EXPORT_MEDICATION_ADMINISTERED_HISTORY_EXCLUDING_IDS = '[ENTITY] Export MedicationAdministeredHistoryModels excluding Ids',
	EXPORT_MEDICATION_ADMINISTERED_HISTORY_EXCLUDING_IDS_OK = '[ENTITY] Export MedicationAdministeredHistoryModel excluding Ids successfully',
	EXPORT_MEDICATION_ADMINISTERED_HISTORY_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicationAdministeredHistoryModel excluding Ids failed',

	COUNT_MEDICATION_ADMINISTERED_HISTORYS = '[ENTITY] Fetch number of MedicationAdministeredHistoryModel records',
	COUNT_MEDICATION_ADMINISTERED_HISTORYS_OK = '[ENTITY] Fetch number of MedicationAdministeredHistoryModel records successfully ',
	COUNT_MEDICATION_ADMINISTERED_HISTORYS_FAIL = '[ENTITY] Fetch number of MedicationAdministeredHistoryModel records failed',

	IMPORT_MEDICATION_ADMINISTERED_HISTORYS = '[ENTITY] Import MedicationAdministeredHistoryModels',
	IMPORT_MEDICATION_ADMINISTERED_HISTORYS_OK = '[ENTITY] Import MedicationAdministeredHistoryModels successfully',
	IMPORT_MEDICATION_ADMINISTERED_HISTORYS_FAIL = '[ENTITY] Import MedicationAdministeredHistoryModels fail',


	INITIALISE_MEDICATION_ADMINISTERED_HISTORY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicationAdministeredHistoryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicationAdministeredHistoryAction implements Action {
	readonly className: string = 'MedicationAdministeredHistoryModel';

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

export class MedicationAdministeredHistoryAction extends BaseMedicationAdministeredHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationAdministeredHistoryAction here] off begin
	// % protected region % [Add any additional class fields for MedicationAdministeredHistoryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicationAdministeredHistoryModel>,
		// % protected region % [Add any additional constructor parameters for MedicationAdministeredHistoryAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationAdministeredHistoryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationAdministeredHistoryAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationAdministeredHistoryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationAdministeredHistoryAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicationAdministeredHistoryAction here] end
	}

	// % protected region % [Add any additional class methods for MedicationAdministeredHistoryAction here] off begin
	// % protected region % [Add any additional class methods for MedicationAdministeredHistoryAction here] end
}

export class MedicationAdministeredHistoryActionOK extends BaseMedicationAdministeredHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationAdministeredHistoryActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicationAdministeredHistoryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicationAdministeredHistoryModel>,
		// % protected region % [Add any additional constructor parameters for MedicationAdministeredHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationAdministeredHistoryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicationAdministeredHistoryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationAdministeredHistoryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationAdministeredHistoryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationAdministeredHistoryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicationAdministeredHistoryActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicationAdministeredHistoryActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicationAdministeredHistoryActionOK here] end
}

export class MedicationAdministeredHistoryActionFail extends BaseMedicationAdministeredHistoryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationAdministeredHistoryActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicationAdministeredHistoryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicationAdministeredHistoryModel>,
		// % protected region % [Add any additional constructor parameters for MedicationAdministeredHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationAdministeredHistoryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationAdministeredHistoryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationAdministeredHistoryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationAdministeredHistoryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicationAdministeredHistoryActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicationAdministeredHistoryActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicationAdministeredHistoryActionFail here] end
}

export function isMedicationAdministeredHistoryModelAction(e: any): e is BaseMedicationAdministeredHistoryAction {
	return Object.values(MedicationAdministeredHistoryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
