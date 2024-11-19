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
import {MedicationHeaderModel} from './medication_header.model';
import {MedicationHeaderModelAudit} from './medication_header.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medication Header model actions to be dispatched by NgRx.
 */
export enum MedicationHeaderModelActionTypes {
	CREATE_MEDICATION_HEADER = '[ENTITY] Create MedicationHeaderModel',
	CREATE_MEDICATION_HEADER_OK = '[ENTITY] Create MedicationHeaderModel successfully',
	CREATE_MEDICATION_HEADER_FAIL = '[ENTITY] Create MedicationHeaderModel failed',

	CREATE_ALL_MEDICATION_HEADER = '[ENTITY] Create All MedicationHeaderModel',
	CREATE_ALL_MEDICATION_HEADER_OK = '[ENTITY] Create All MedicationHeaderModel successfully',
	CREATE_ALL_MEDICATION_HEADER_FAIL = '[ENTITY] Create All MedicationHeaderModel failed',

	DELETE_MEDICATION_HEADER = '[ENTITY] Delete MedicationHeaderModel',
	DELETE_MEDICATION_HEADER_OK = '[ENTITY] Delete MedicationHeaderModel successfully',
	DELETE_MEDICATION_HEADER_FAIL = '[ENTITY] Delete MedicationHeaderModel failed',


	DELETE_MEDICATION_HEADER_EXCLUDING_IDS = '[ENTITY] Delete MedicationHeaderModels Excluding Ids',
	DELETE_MEDICATION_HEADER_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicationHeaderModels Excluding Ids successfully',
	DELETE_MEDICATION_HEADER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicationHeaderModels Excluding Ids failed',

	DELETE_ALL_MEDICATION_HEADER = '[ENTITY] Delete all MedicationHeaderModels',
	DELETE_ALL_MEDICATION_HEADER_OK = '[ENTITY] Delete all MedicationHeaderModels successfully',
	DELETE_ALL_MEDICATION_HEADER_FAIL = '[ENTITY] Delete all MedicationHeaderModels failed',

	UPDATE_MEDICATION_HEADER = '[ENTITY] Update MedicationHeaderModel',
	UPDATE_MEDICATION_HEADER_OK = '[ENTITY] Update MedicationHeaderModel successfully',
	UPDATE_MEDICATION_HEADER_FAIL = '[ENTITY] Update MedicationHeaderModel failed',

	UPDATE_ALL_MEDICATION_HEADER = '[ENTITY] Update all MedicationHeaderModel',
	UPDATE_ALL_MEDICATION_HEADER_OK = '[ENTITY] Update all MedicationHeaderModel successfully',
	UPDATE_ALL_MEDICATION_HEADER_FAIL = '[ENTITY] Update all MedicationHeaderModel failed',

	FETCH_MEDICATION_HEADER= '[ENTITY] Fetch MedicationHeaderModel',
	FETCH_MEDICATION_HEADER_OK = '[ENTITY] Fetch MedicationHeaderModel successfully',
	FETCH_MEDICATION_HEADER_FAIL = '[ENTITY] Fetch MedicationHeaderModel failed',

	FETCH_MEDICATION_HEADER_AUDIT= '[ENTITY] Fetch MedicationHeaderModel audit',
	FETCH_MEDICATION_HEADER_AUDIT_OK = '[ENTITY] Fetch MedicationHeaderModel audit successfully',
	FETCH_MEDICATION_HEADER_AUDIT_FAIL = '[ENTITY] Fetch MedicationHeaderModel audit failed',

	FETCH_MEDICATION_HEADER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicationHeaderModel audits by entity id',
	FETCH_MEDICATION_HEADER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicationHeaderModel audits by entity id successfully',
	FETCH_MEDICATION_HEADER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicationHeaderModel audits by entity id failed',

	FETCH_ALL_MEDICATION_HEADER = '[ENTITY] Fetch all MedicationHeaderModel',
	FETCH_ALL_MEDICATION_HEADER_OK = '[ENTITY] Fetch all MedicationHeaderModel successfully',
	FETCH_ALL_MEDICATION_HEADER_FAIL = '[ENTITY] Fetch all MedicationHeaderModel failed',

	FETCH_MEDICATION_HEADER_WITH_QUERY = '[ENTITY] Fetch MedicationHeaderModel with query',
	FETCH_MEDICATION_HEADER_WITH_QUERY_OK = '[ENTITY] Fetch MedicationHeaderModel with query successfully',
	FETCH_MEDICATION_HEADER_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicationHeaderModel with query failed',

	FETCH_LAST_MEDICATION_HEADER_WITH_QUERY = '[ENTITY] Fetch last MedicationHeaderModel with query',
	FETCH_LAST_MEDICATION_HEADER_WITH_QUERY_OK = '[ENTITY] Fetch last MedicationHeaderModel with query successfully',
	FETCH_LAST_MEDICATION_HEADER_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicationHeaderModel with query failed',

	EXPORT_MEDICATION_HEADER = '[ENTITY] Export MedicationHeaderModel',
	EXPORT_MEDICATION_HEADER_OK = '[ENTITY] Export MedicationHeaderModel successfully',
	EXPORT_MEDICATION_HEADER_FAIL = '[ENTITY] Export MedicationHeaderModel failed',

	EXPORT_ALL_MEDICATION_HEADER = '[ENTITY] Export All MedicationHeaderModels',
	EXPORT_ALL_MEDICATION_HEADER_OK = '[ENTITY] Export All MedicationHeaderModels successfully',
	EXPORT_ALL_MEDICATION_HEADER_FAIL = '[ENTITY] Export All MedicationHeaderModels failed',

	EXPORT_MEDICATION_HEADER_EXCLUDING_IDS = '[ENTITY] Export MedicationHeaderModels excluding Ids',
	EXPORT_MEDICATION_HEADER_EXCLUDING_IDS_OK = '[ENTITY] Export MedicationHeaderModel excluding Ids successfully',
	EXPORT_MEDICATION_HEADER_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicationHeaderModel excluding Ids failed',

	COUNT_MEDICATION_HEADERS = '[ENTITY] Fetch number of MedicationHeaderModel records',
	COUNT_MEDICATION_HEADERS_OK = '[ENTITY] Fetch number of MedicationHeaderModel records successfully ',
	COUNT_MEDICATION_HEADERS_FAIL = '[ENTITY] Fetch number of MedicationHeaderModel records failed',

	IMPORT_MEDICATION_HEADERS = '[ENTITY] Import MedicationHeaderModels',
	IMPORT_MEDICATION_HEADERS_OK = '[ENTITY] Import MedicationHeaderModels successfully',
	IMPORT_MEDICATION_HEADERS_FAIL = '[ENTITY] Import MedicationHeaderModels fail',


	INITIALISE_MEDICATION_HEADER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicationHeaderModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicationHeaderAction implements Action {
	readonly className: string = 'MedicationHeaderModel';

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

export class MedicationHeaderAction extends BaseMedicationHeaderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationHeaderAction here] off begin
	// % protected region % [Add any additional class fields for MedicationHeaderAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicationHeaderModel>,
		// % protected region % [Add any additional constructor parameters for MedicationHeaderAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationHeaderAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationHeaderAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationHeaderAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationHeaderAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicationHeaderAction here] end
	}

	// % protected region % [Add any additional class methods for MedicationHeaderAction here] off begin
	// % protected region % [Add any additional class methods for MedicationHeaderAction here] end
}

export class MedicationHeaderActionOK extends BaseMedicationHeaderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationHeaderActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicationHeaderActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicationHeaderModel>,
		// % protected region % [Add any additional constructor parameters for MedicationHeaderActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationHeaderActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicationHeaderModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationHeaderActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationHeaderActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationHeaderActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicationHeaderActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicationHeaderActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicationHeaderActionOK here] end
}

export class MedicationHeaderActionFail extends BaseMedicationHeaderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicationHeaderActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicationHeaderActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicationHeaderModel>,
		// % protected region % [Add any additional constructor parameters for MedicationHeaderActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicationHeaderActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicationHeaderActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicationHeaderActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicationHeaderActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicationHeaderActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicationHeaderActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicationHeaderActionFail here] end
}

export function isMedicationHeaderModelAction(e: any): e is BaseMedicationHeaderAction {
	return Object.values(MedicationHeaderModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
